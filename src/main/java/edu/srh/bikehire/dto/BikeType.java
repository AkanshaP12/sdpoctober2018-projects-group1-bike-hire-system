package edu.srh.bikehire.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class BikeType {
	
	/*
	 
	 CREATE TABLE `BikeType` (
	`BikeTypeId` bigint NOT NULL,
	`Type` varchar(100) NOT NULL,
	`AgeCategory` varchar(100) NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	PRIMARY KEY (`BikeTypeId`)
    );
	
	 */

	private BigInteger bikeTypeId;
	private String type;
	private String ageCategory;
	private Timestamp creationTimeStamp;
	public BigInteger getBikeTypeId() {
		return bikeTypeId;
	}
	public void setBikeTypeId(BigInteger bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}
	public Timestamp getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Timestamp creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	

}
