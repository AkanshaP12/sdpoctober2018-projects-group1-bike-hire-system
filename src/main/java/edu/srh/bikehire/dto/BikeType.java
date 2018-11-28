package edu.srh.bikehire.dto;

import java.util.Calendar;

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

	private String bikeTypeId;
	private String type;
	private String ageCategory;
	private Calendar creationTimeStamp;
	public String getBikeTypeId() {
		return bikeTypeId;
	}
	public void setBikeTypeId(String bikeTypeId) {
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
	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}

	
	
}
