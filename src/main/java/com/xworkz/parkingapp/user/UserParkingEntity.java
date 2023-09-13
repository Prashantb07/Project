package com.xworkz.parkingapp.user;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="userparking_details")
@NamedQueries({
@NamedQuery(name="fetch", query="select entity from UserParkingEntity as entity where entity.userId=:id"),
@NamedQuery(name="fetchpark", query="select entity from UserParkingEntity as entity where entity.parkingId=:pid"),
@NamedQuery(name = "updateuserinfo", query = "update UserParkingEntity entity set entity.location=:loc, entity.vtype=:vtype,entity.vclassification=:vclass, entity.term=:ter, entity.price=:pr, entity.discount=:dis, entity.totalAmount=:tamount, entity.fileName=:fName where entity.parkingId=:pid"),
@NamedQuery(name="deleteParkingById",query="delete from UserParkingEntity entity where entity.parkingId=:pid")})
public class UserParkingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
