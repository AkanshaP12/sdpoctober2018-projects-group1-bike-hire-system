package edu.srh.bikehire.assetmangement;

import java.util.Calendar;

public class BikeRentDetails {
	private String bikeTypeID;
	private int rentPerHour;
	private int bikePerDay;
	private Calendar lastModifiedTimestamp;
	
	
	public String getBikeTypeID() {
		return bikeTypeID;
	}
	public void setBikeTypeID(String bikeTypeID) {
		this.bikeTypeID = bikeTypeID;
	}
	public int getRentPerHour() {
		return rentPerHour;
	}
	public void setRentPerHour(int rentPerHour) {
		this.rentPerHour = rentPerHour;
	}
	public int getBikePerDay() {
		return bikePerDay;
	}
	public void setBikePerDay(int bikePerDay) {
		this.bikePerDay = bikePerDay;
	}
	public Calendar getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}
	public void setLastModifiedTimestamp(Calendar lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}
	
	
	

}
