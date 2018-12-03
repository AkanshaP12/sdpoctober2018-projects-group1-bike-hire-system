package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.Bike;

public class BikeInfo implements Bike {

	private String bikeId;
	private String bikeTypeId;
	private String manufacturer;
	private int yearOfManufacturer;
	private String bikeTitle;
	private String wareHouseID;
	private int depositAmount;
	
	public String getBikeId() {
		return bikeId;
	}

	public String getBikeTypeId() {
		return bikeTypeId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getYearOfManufacture() {
		return yearOfManufacturer;
	}

	public String getBikeTitle() {
		return bikeTitle;
	}

	public String getWareHouseID() {
		return wareHouseID;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

}
