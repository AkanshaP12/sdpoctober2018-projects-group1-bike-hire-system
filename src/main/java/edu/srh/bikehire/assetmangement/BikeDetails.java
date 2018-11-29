package edu.srh.bikehire.assetmangement;

import java.util.Calendar;

public class BikeDetails {
	private String bikeID;
	private String bikeTypeID;
	private String bikeManufacturer;
	private int yearOfManufacture;
	private String wareHouseID;
	private String bikeTitle;
	private int bikeDepositAmount;
	private Calendar creationTimeStamp;
	
	
	public String getBikeID() {
		return bikeID;
	}

	public void setBikeID(String bikeID) {
		this.bikeID = bikeID;
	}

	public String getBikeTypeID() {
		return bikeTypeID;
	}

	public void setBikeTypeID(String bikeTypeID) {
		this.bikeTypeID = bikeTypeID;
	}

	public String getBikeManufacturer() {
		return bikeManufacturer;
	}

	public void setBikeManufacturer(String bikeManufacturer) {
		this.bikeManufacturer = bikeManufacturer;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getWareHouseID() {
		return wareHouseID;
	}

	public void setWareHouseID(String wareHouseID) {
		this.wareHouseID = wareHouseID;
	}

	public String getBikeTitle() {
		return bikeTitle;
	}

	public void setBikeTitle(String bikeTitle) {
		this.bikeTitle = bikeTitle;
	}

	public int getBikeDepositAmount() {
		return bikeDepositAmount;
	}

	public void setBikeDepositAmount(int bikeDepositAmount) {
		this.bikeDepositAmount = bikeDepositAmount;
	}

	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	
	
	
}
