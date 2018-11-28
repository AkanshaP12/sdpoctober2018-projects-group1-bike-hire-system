package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "bike")
public class Bike {

	
/**
	CREATE TABLE `Bike` (
	`BikeId` bigint NOT NULL,
	`BikeTypeId` bigint NOT NULL,
	`Manufacturer` varchar(200) NOT NULL,
	`YearOfManufacture` int(4) NOT NULL,
	`BikeTitle` varchar(200) NOT NULL,
	`WareHouseID` bigint NOT NULL,
	`DepositAmount` int(10) NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	PRIMARY KEY (`BikeId`)
	);
**/
	
	@Id
	@Column(name = "bikeId")
	private String bikeId;
	
	@Id
	@Column(name = "bikeTypeId")
	private String bikeTypeId;
	
	@Id
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Id
	@Column(name = "yearOfManufacture")
	private int yearOfManufacture;
	
	@Id
	@Column(name = "bikeTitle")
	private String bikeTitle;
	
	@Id
	@Column(name = "wareHouseID")
	private String wareHouseID;

	@Id
	@Column(name = "depositAmount")
	private int depositAmount;

	@Id
	@Column(name = "creationTimeStamp")
	private Calendar creationTimeStamp;

	public String getBikeId() {
		return bikeId;
	}

	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeTypeId() {
		return bikeTypeId;
	}

	public void setBikeTypeId(String bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getBikeTitle() {
		return bikeTitle;
	}

	public void setBikeTitle(String bikeTitle) {
		this.bikeTitle = bikeTitle;
	}

	public String getWareHouseID() {
		return wareHouseID;
	}

	public void setWareHouseID(String wareHouseID) {
		this.wareHouseID = wareHouseID;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}

		
}
