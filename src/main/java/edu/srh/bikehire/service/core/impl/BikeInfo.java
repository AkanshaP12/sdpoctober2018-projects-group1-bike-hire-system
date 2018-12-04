package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.Bike;

public class BikeInfo implements Bike {

	private int bikeId;
	private int bikeTypeId;
	private String manufacturer;
	private int yearOfManufacturer;
	private String bikeTitle;
	private int wareHouseID;
	private int depositAmount;
	
	public int getBikeId() {
		return bikeId;
	}

	public int getBikeTypeId() {
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

	public int getWareHouseID() {
		return wareHouseID;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

}
