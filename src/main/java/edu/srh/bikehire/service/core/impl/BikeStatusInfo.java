package edu.srh.bikehire.service.core.impl;

import java.util.Calendar;

import edu.srh.bikehire.service.core.BikeStatus;

public class BikeStatusInfo implements BikeStatus {
	private String bikeId;
	private String status;
	private Calendar lastServiceDate;
	private String manufacturer;
	
	public String getBikeId() {
		return bikeId;
	}

	public String getStatus() {
		return status;
	}

	public Calendar getLastServiceDate() {
		return lastServiceDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

}
