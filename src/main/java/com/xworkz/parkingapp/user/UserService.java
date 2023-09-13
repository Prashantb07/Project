package com.xworkz.parkingapp.user;

import java.util.List;

import javax.validation.Valid;

public interface UserService {

	boolean validateAndSave(@Valid UserDTO dto, @Valid UserParkingDTO dtos);

	boolean sendMail(String emailId);
	
	boolean otpSendMail(String userEmail, UserEntity entity);
	
	UserEntity userSignIn(String userEmail,UserEntity entity);

	UserEntity findByUserEmail(String userEmail);


	UserDTO userLogin(String userEmail, String otp);
	
	void onSave(UserParkingDTO dto, String userEmail );
	
	UserDTO getAllUserInfo(String userEmail);

	List<UserParkingDTO> getAllParkingInfo(String userEmail);
	
    UserParkingDTO updateAllParkInfo(int parkingId);
    
    void updateUserByIdSer(UserParkingDTO dto);
    
	UserParkingDTO deleteParkingByIdSer(int parkingId);

	 
}
