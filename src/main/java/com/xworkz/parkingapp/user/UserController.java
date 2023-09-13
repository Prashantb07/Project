package com.xworkz.parkingapp.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.xworkz.parkingapp.constant.ApplicationConstant;


@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService service;

//	@Autowired
//	private UserParkingService parkingService;

	public UserController() {
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@PostMapping("/userSave")
	public String userParkSave(@Valid UserDTO dto, @Valid UserParkingDTO dtos, BindingResult bindingResult,
			Model model) {
		System.out.println("running userParkSave");

		if (bindingResult.hasErrors()) {
			System.out.println("Data is valid");
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("dto", dto);
			return "/userinfo.jsp";
		} else {
			System.out.println("data is valid");
			service.validateAndSave(dto, dtos);
			// parkingService.validateAndSave(dtos);
			model.addAttribute("msg", "userinfo of "+ dto.getUserName()+"saved successfully");
		}
		return "/responseuser.jsp";
	}

	/*
	 * @PostMapping("/sendotp") public String sendOTP(String userEmail, Model model,
	 * String otp,UserEntity entity, String generateOtp, String login,
	 * HttpServletRequest req) { System.out.println("Running sendOTP method");
	 * 
	 * System.out.println("Controller: generateOtp "+ generateOtp);
	 * System.out.println("Controller: login from UI "+ login);
	 * System.out.println("Controller: email from UI "+ userEmail);
	 * System.out.println("Controller: otp from UI "+ otp);
	 * 
	 * if(generateOtp != null && "generateOtp".equals(generateOtp)) {
	 * System.out.println("inside otp"); //UserDTO
	 * dto=userService.userLogin(email,oneTimePassword); UserEntity entity1=
	 * service.findByUserEmail(userEmail);
	 * 
	 * HttpSession session=req.getSession(true); session.setAttribute("emailId",
	 * userEmail);
	 * 
	 * System.out.println(entity1); if(entity1 != null) { UserEntity
	 * ent=service.userSignIn(userEmail, entity); if(ent != null) {
	 * model.addAttribute("mail", userEmail);
	 * model.addAttribute("successMsg","OTP send to registered email successfully");
	 * } else { model.addAttribute("mail", userEmail);
	 * model.addAttribute("generateotperror", "Re-generate the OTP"); } } else {
	 * model.addAttribute("mail", userEmail); model.addAttribute("emailerror",
	 * "Not a registered email"); } } else if(login != null &&
	 * "Login".equals(login)) { System.out.println("validating otp...");
	 * System.out.println("controller: onGenerateOTP(): email from userLogin.jsp: "
	 * +userEmail ); UserDTO isOtpValid=service.userLogin(userEmail, otp);
	 * UserEntity eneen=service.findByUserEmail(userEmail);
	 * System.out.println("eneen: "+eneen); // boolean otpNotExpired =
	 * eneen.getOtpExpiryTime().isAfter(LocalTime.now()); //
	 * System.out.println("OTP Not Expired "+ otpNotExpired);
	 * 
	 * if(isOtpValid !=null) { HttpSession session=req.getSession(true);
	 * session.setAttribute("userDto", eneen);
	 * 
	 * return "UserLoginSuccess.jsp"; } else {
	 * model.addAttribute("error","Invalid OTP"); }
	 * 
	 * 
	 * }
	 * 
	 * return "Usersingin.jsp";
	 */

	/*
	 * @PostMapping("/sendotp") public String sendOTP(@RequestParam("userEmail")
	 * String userEmail, Model model, UserEntity entity) {
	 * System.out.println("Running sendOTP method");
	 * 
	 * service.otpSendMail(userEmail, entity); service.userSignIn(userEmail,
	 * entity); model.addAttribute("successMsg", "OTP send to email successfully");
	 * return "/Usersingin.jsp"; }
	 */

	@PostMapping("/sendotp")
	public String sendOTP(String generateOtp, String login, String userEmail, Model model, UserEntity entity,
			String otp, HttpServletRequest req) {
		System.out.println("Running sendOTP method");

		System.out.println("controller : generateOtp " + generateOtp);
		System.out.println("Controller : login from UI  " + login);
		System.out.println("Controller : email from UI " + userEmail);
		System.out.println("Controller : otp from UI " + otp);
		//service.otpSendMail(userEmail,entity);

		if (generateOtp != null && "generateOtp".equals(generateOtp)) {
			System.out.println("inside otp");
			UserEntity entity1 = service.findByUserEmail(userEmail);

			HttpSession session = req.getSession();
			session.setAttribute("emailId", userEmail);

			System.out.println(entity1);
			if (entity1 != null) {
				UserEntity ent = service.userSignIn(userEmail, entity);
				if (ent != null) {
					model.addAttribute("emailId", userEmail);
					model.addAttribute("successMsg", "OTP send to email successfully");
				} else {
					model.addAttribute("emailId", userEmail);
					model.addAttribute("successMsg", "Re - generate the otp");

				}
			} else {
				model.addAttribute("emailId", userEmail);
				model.addAttribute("emailError", "Not a registered mail id");

			}

		} else if (login != null && "Login".equals(login)) {
			System.out.println("validating otp");
			System.out.println("controller : on generate otp():email from userlogin.jsp:" + userEmail);
			UserDTO isOtpValid = service.userLogin(userEmail, otp);
			UserEntity eneen = service.findByUserEmail(userEmail); 
			System.out.println("eneen:"+eneen);
			// boolean otpNotExpired = eneen.getOtpExpiryTime().isAfter(LocalTime.now());
			// if(otpNotExpired) {

			// UserDTO isOtpValid = service.login(emailId, oneTimePassword);

			if (isOtpValid != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("userDto", eneen);

				return "UserLoginSucess.jsp";
			} else {
				
				model.addAttribute("error", "Invalid OTP");

			}

		}

		return "Usersingin.jsp";
	}
	
	@PostMapping("/onSave")
	public String onSave(@Valid UserParkingDTO dto,BindingResult bindingResult, Model model, MultipartFile file, HttpServletRequest req) throws IOException {
		System.out.println("running oSave"+dto);
		
		model.addAttribute("dtos",dto);
		
		if(bindingResult.hasErrors()) {
			System.out.println("Data is inValid");
			model.addAttribute("errors",bindingResult.getAllErrors());
			model.addAttribute("dto",dto);
			
			return "/userParkinginfo.jsp";
		
	}else {
		System.out.println("File received: "+file.getName());
		System.out.println("File Size: "+file.getSize());
		System.out.println("File Type: "+file.getContentType());
		System.out.println("File bytes: "+file.getBytes());
		
		dto.setFileName(System.currentTimeMillis()+ "-" +file.getOriginalFilename());
		//dto.setFileName(file.getOriginalFilename());
		dto.setContentType(file.getContentType());
		dto.setFileSize(file.getSize());
		
		File physiicalFile = new File(ApplicationConstant.FILE_LOCATION + dto.getFileName());
		
		try (OutputStream os = new FileOutputStream(physiicalFile)) {
			os.write(file.getBytes());
		}
		HttpSession session=req.getSession();
		UserEntity entity = (UserEntity) session.getAttribute("userDto");			
		System.out.println("Data is valid");
		service.onSave(dto , entity.getUserEmail());
	
		model.addAttribute("successMsg","userinfo"+dto.getLocation()+"saved successfully");
		
	}
		return "/responseuser.jsp";
		
	}
	
	@GetMapping("/fetchdata")
	public String fetchAllData(UserDTO dto,UserParkingDTO dtos,HttpServletResponse response,Model model,HttpServletRequest req,String fileName,String contentType) throws IOException {
		System.out.println("running fetchAllData");
		
		HttpSession session = req.getSession();
		UserEntity sessionDto = (UserEntity) session.getAttribute("userDto");
		
		/*
		 * File file = new File(ApplicationConstant.FILE_LOCATION+dtos.getFileName());
		 * response.setContentType(dtos.getContentType()); OutputStream outputStream =
		 * response.getOutputStream(); FileInputStream inputStream = new
		 * FileInputStream(file); byte[] buffer = new byte[4096]; int length;
		 * 
		 * while((length = inputStream.read(buffer))>0) {
		 * outputStream.write(buffer,0,length); } inputStream.close();
		 * 
		 * outputStream.flush();
		 */
		
		UserDTO list = service.getAllUserInfo(sessionDto.getUserEmail());
		List<UserParkingDTO> list1 = service.getAllParkingInfo(sessionDto.getUserEmail());
		//model.addAttribute("userDto",list);
		model.addAttribute("userInfoDto",list1);
		System.out.println("viewing parking info"+list1);
		return "/userView.jsp";
		
	}
	
	@GetMapping("/fileDownload")
	public void imageDownload(String fileName,String contentType,HttpServletResponse response) throws IOException {
		System.out.println("running imageDownload");
		File file = new File(ApplicationConstant.FILE_LOCATION+fileName);
		response.setContentType(contentType);
		OutputStream outputStream = response.getOutputStream();
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		int length;
		
		while((length = in.read(buffer))>0) {
			outputStream.write(buffer,0,length);
		}
		in.close();
		outputStream.flush();
	}
	
	@GetMapping(value = "/update/{parkingId}")
	public String updateUser(@PathVariable("parkingId") int parkingId,HttpServletRequest req ) {
	System.out.println("inside updateUser method");
	
	UserParkingDTO dto = service.updateAllParkInfo(parkingId);
	
	req.setAttribute("parkingid",dto);
	RedirectView view = new RedirectView();
	view.setUrl(req.getContextPath()+"/");
	
		return "/updateUser.jsp";
		
	}
	
	@PostMapping(value = "/updateuserpark")
	public String update(@ModelAttribute UserParkingDTO dto ,MultipartFile file, HttpServletRequest req) throws IOException {
		System.out.println("inside update method");
		
		System.out.println("File recieved:"+file.getName());
		System.out.println("File Size:"+file.getSize());
		System.out.println("File Type:"+file.getContentType());
		System.out.println("File bytes:"+file.getBytes());
		
		dto.setFileName(System.currentTimeMillis()+"_"+file.getOriginalFilename());
		dto.setContentType(file.getContentType());
		dto.setFileSize(file.getSize());
		
		File physicalFile = new File(ApplicationConstant.FILE_LOCATION+dto.getFileName());
		
		try(OutputStream outputStream = new FileOutputStream(physicalFile)){
			outputStream.write(file.getBytes());
		}
		
		System.out.println(dto);
		service.updateUserByIdSer(dto);
		
		req.setAttribute("parkingid",dto);
		return "/updateSucess.jsp";
		
	}
	@GetMapping(value="delete/{parkingId}")
	public RedirectView deleteById(@PathVariable("parkingId")int parkingId,HttpServletRequest req) {
		
		System.out.println("inside deleteByid method");
		
		UserParkingDTO dto = service.deleteParkingByIdSer(parkingId);
		req.setAttribute("parkingid", dto);
		RedirectView view = new RedirectView();
		view.setUrl(req.getContextPath()+"/fetch");
				
		return view;
		
	}
}
