package com.xworkz.parkingapp.user;

public interface UserRepo {

	boolean saveInfo(UserEntity entity);
	
	UserEntity findByUserEmail(String userEmail);

	boolean userSignInUpdate(String otp,String userEmail);

	 UserEntity userLoginRepo(String userEmail);

	boolean updatedTime(UserEntity entity);

		
	
	 }


