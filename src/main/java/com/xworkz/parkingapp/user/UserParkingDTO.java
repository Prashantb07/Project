package com.xworkz.parkingapp.user;

import lombok.Data;

@Data
public class UserParkingDTO {

	private int parkingId;
	
	private int userId;
	
	private String location;

	private String vtype;

	private String vclassification;

	private String term;

	private int price;

	private String discount;
	
	private int totalAmount;
	
	private String fileName;
	
	private String contentType;
	
	private long fileSize;

}
