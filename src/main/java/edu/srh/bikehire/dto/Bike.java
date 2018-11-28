package edu.srh.bikehire.dto;

import java.math.BigInteger;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "bike")
public class Bike {

	
/**
	CREATE TABLE `BikeType` (
			`BikeTypeId` bigint NOT NULL,
			`Type` varchar(100) NOT NULL,
			`AgeCategory` varchar(100) NOT NULL,
			`CreationTimeStamp` TIMESTAMP NOT NULL,
			PRIMARY KEY (`BikeTypeId`)
		);
**/
	
	@Id
	@Column(name = "bikeTypeId")
	private BigInteger bikeTypeId;
	
	@Id
	@Column(name = "typeI")
	private String type;
	
	@Id
	@Column(name = "ageCategory")
	private String ageCategory;
	
	@Id
	@Column(name = "creationTimeStamp")
	private Timestamp creationTimeStamp;
	
	public Bike() {
	}

	public Bike(BigInteger bikeTypeId, String type, String ageCategory) {
		this.bikeTypeId = bikeTypeId;
		this.type = type;
		this.ageCategory = ageCategory;
	}
	
	public Bike(BigInteger bikeTypeId, String type) {
		this.bikeTypeId = bikeTypeId;
		this.type = type;
	}
	
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
