package com.xworkz.parkingapp.user;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private UserParkingRepo repopark;

	public UserServiceImpl() {
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(UserDTO dto, UserParkingDTO dtos) {

		System.out.println("running validateAndSave");
		UserEntity record = repo.findByUserEmail(dto.getUserEmail());
		if (record == null) {
			UserEntity entity = new UserEntity();
			BeanUtils.copyProperties(dto, entity);
			System.out.println(entity);
			UserService service=new UserServiceImpl();
			service.sendMail(dto.getUserEmail());
			repo.saveInfo(entity);
			if (entity != null) {

				UserParkingEntity entity1 = new UserParkingEntity();

				// System.out.println("the current user id" +entity.getUserId());
				UserEntity userByEmail = this.repo.findByUserEmail(dto.getUserEmail());
				dtos.setUserId(userByEmail.getUserId());
				BeanUtils.copyProperties(dtos, entity1);
				System.out.println(entity1);
				repopark.saveparkingInfo(entity1);
				return true;
			}
		}
		return true;

	}

	@Override
	public boolean sendMail(String userEmail) {
System.out.println("Inside sendMail");
		
		String portNumber="587";
		String hostName="smtp.office365.com";
		final String fromEmail="prashantb094@outlook.com";
		final String password="Prashantb@094";
		String to=userEmail;
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug",true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");
		
		Session session=Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		
		MimeMessage message=new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration completed");
			message.setText("Thanks for registering!!!");
			//here we need to add code
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean otpSendMail(String userEmail, UserEntity entity) {

		System.out.println("Inside otpSendMail");

		String portNumber = "587";
		String hostName = "smtp.office365.com";
		final String fromEmail = "prashantb094@outlook.com";
		final String password = "Prashantb@094";
		String to = userEmail;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);

		try {

			String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
			System.out.println(otp);

			// oneTimePassword = otp;
			entity.setOtp(otp);

			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Here your One Time Password sent by Satish");
			message.setText("OTP = " + entity.getOtp() + " ");
			// here we need to add code
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public UserEntity userSignIn(String userEmail, UserEntity entity) {
		System.out.println("Inside userSignIn");

		UserEntity record = this.repo.findByUserEmail(entity.getUserEmail());

		UserService service = new UserServiceImpl();
		service.otpSendMail(userEmail, entity);
		String oneTimePassword = entity.getOtp();

		repo.userSignInUpdate(oneTimePassword, userEmail);
		return record;
	}

	@Override
	public UserEntity findByUserEmail(String userEmail) {
		return repo.findByUserEmail(userEmail);
	}

	@Override
	public UserDTO userLogin(String userEmail, String otp) {
			System.out.println("Running userLoginser");
			
			UserEntity entity=this.repo.userLoginRepo(userEmail);
			
			if(entity.getUserEmail().equals(userEmail) && entity.getOtp().equals(otp)){
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy, hh:mm:ss");
				String formatedDate=dateFormat.format(new Date()).toString();
				
				entity.setLoginTime(formatedDate);
				boolean status=repo.updatedTime(entity);
				UserEntity updatedEntity=repo.userLoginRepo(userEmail);
				UserDTO  dto=new UserDTO();
				BeanUtils.copyProperties(updatedEntity,dto);
				return dto;
			}
				return null;
	}

	@Override
	public void onSave(UserParkingDTO dto, String userEmail) {
		UserParkingEntity entity = new UserParkingEntity();
		BeanUtils.copyProperties(dto, entity);
		UserEntity userEntity = repo.findByUserEmail(userEmail);
		entity.setUserId(userEntity.getUserId());
		repopark.saveparkingInfo(entity);
		
	}

	@Override
	public UserDTO getAllUserInfo(String userEmail) {
		System.out.println("running getAllUserinfo");
		
		UserEntity entity = this.repo.findByUserEmail(userEmail);
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}

	@Override
	public List<UserParkingDTO> getAllParkingInfo(String userEmail) {
			System.out.println("running getAllParking info");
			
			UserEntity entity = this.repo.findByUserEmail(userEmail);
		List<UserParkingEntity> entities=this.repopark.findByUserId(entity.getUserId());
		List<UserParkingDTO> dtos = entities.stream().map(ent->{
			UserParkingDTO userParkingDTO=new UserParkingDTO();
			BeanUtils.copyProperties(ent, userParkingDTO);
			return userParkingDTO;		
			}).collect(Collectors.toList());
			
			
		return dtos;
		
	}

	@Override
	public UserParkingDTO updateAllParkInfo(int parkingId) {
		System.out.println("running updateAllParkInfo ");
		
		
		//UserEntity entity=this.userRepository.findByUserEmail(email);
		UserParkingEntity entity=repopark.updateByParkId(parkingId);
		if(entity!=null) {
			UserParkingDTO dtos=new UserParkingDTO();
			BeanUtils.copyProperties(entity, dtos);
			return dtos;	
		}
		return null;
	}

	@Override
	public void updateUserByIdSer(UserParkingDTO dto) {
		System.out.println("running updateUserByIdSer");
		
		/*
		 * UserParkingEntity entity = new UserParkingEntity(); UserParkingEntity entity2
		 * = repopark.updateUserInfo(entity); UserParkingDTO dtos = new
		 * UserParkingDTO(); BeanUtils.copyProperties(dtos, dto);
		 * 
		 * System.out.println(dto);
		 */
		System.out.println(dto);
		UserParkingEntity entity = new UserParkingEntity();
		BeanUtils.copyProperties(dto, entity);
		repopark.updateUserInfo(entity);
		System.out.println(entity);
		
	}

	@Override
	public UserParkingDTO deleteParkingByIdSer(int parkingId) {
System.out.println("Running deleteParkingByIdSer");
		
		UserParkingEntity entity=repopark.deleteByParkId(parkingId);
		if(entity!=null) {
			UserParkingDTO dto=new UserParkingDTO();
			BeanUtils.copyProperties(entity, dto);
		
			return dto;	
	}
	
	return null;
}
}