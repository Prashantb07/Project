package com.xworkz.parkingapp.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="userInfo_details")
@NamedQueries({
@NamedQuery(name = "findByUserEmail", query = "select entity from UserEntity as entity where entity.userEmail=:email"),
@NamedQuery(name = "updateOTP", query = "update UserEntity entity set entity.otp=:oneTime where entity.userEmail=:mail")})
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	private String userEmail;
	
	private long userMobileNo;
	
	private static final long OTP_VALID_DURATION = 5*60*1000;
	
	private String otp;
	
	private Date otpTime;
	
	private String loginTime;

}