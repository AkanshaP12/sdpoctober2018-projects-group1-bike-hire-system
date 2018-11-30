package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "bike")
public class Bike {

	/**
	 * CREATE TABLE `Bike` ( `BikeId` bigint NOT NULL, `BikeTypeId` bigint NOT NULL,
	 * `Manufacturer` varchar(200) NOT NULL, `YearOfManufacture` int(4) NOT NULL,
	 * `BikeTitle` varchar(200) NOT NULL, `WareHouseID` bigint NOT NULL,
	 * `DepositAmount` int(10) NOT NULL, `CreationTimeStamp` TIMESTAMP NOT NULL,
	 * PRIMARY KEY (`BikeId`) );
	 **/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BikeId")
	private String bikeId;

	@Column(name = "BikeTypeId")
	private String bikeTypeId;

	@Column(name = "Manufacturer")
	private String manufacturer;

	@Column(name = "YearOfManufacture")
	private int yearOfManufacture;

	@Column(name = "BikeTitle")
	private String bikeTitle;

	@Column(name = "WareHouseID")
	private String wareHouseID;

	@Column(name = "DepositAmount")
	private int depositAmount;

	@Column(name = "CreationTimeStamp")
	private String creationTimeStamp;  //make it calendar

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

	public String getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(String string) {
		this.creationTimeStamp = string;
	}

}
