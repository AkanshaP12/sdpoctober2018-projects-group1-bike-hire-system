package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BikeTypeId")
	private String bikeTypeId;
	@Column(name = "Type")
	private String type;
	@Column(name = "AgeCategory")
	private String ageCategory;
	@Column(name = "CreationTimeStamp")
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
