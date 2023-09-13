package com.xworkz.parkingapp.user;

import java.util.List;

public interface UserParkingRepo {

	boolean saveparkingInfo(UserParkingEntity entity);

	List<UserParkingEntity> findByUserId(int userId);
	
	UserParkingEntity updateByParkId(int parkingId);
	
	UserParkingEntity updateUserInfo(UserParkingEntity entity);

	UserParkingEntity deleteByParkId(int parkingId);
}
