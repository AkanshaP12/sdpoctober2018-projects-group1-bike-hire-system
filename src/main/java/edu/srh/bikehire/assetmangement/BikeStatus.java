package edu.srh.bikehire.assetmangement;

import java.util.Calendar;

public class BikeStatus {
	
	private String bikeID;
	private String bikeRentStatus;
	private String bikeManufacturer;
	private Calendar lastServiceDate;
	private Calendar lastModifiedDate;
	public String getBikeID() {
		return bikeID;
	}
	public void setBikeID(String bikeID) {
		this.bikeID = bikeID;
	}
	public String getBikeRentStatus() {
		return bikeRentStatus;
	}
	public void setBikeRentStatus(String bikeRentStatus) {
		this.bikeRentStatus = bikeRentStatus;
	}
	public String getBikeManufacturer() {
		return bikeManufacturer;
	}
	public void setBikeManufacturer(String bikeManufacturer) {
		this.bikeManufacturer = bikeManufacturer;
	}
	public Calendar getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Calendar lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Calendar lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	
	
	
	

}
