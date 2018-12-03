package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.BikeRent;

public class BikeRentInfo implements BikeRent {
	private String bikeTypeId;
	private int rentPerHour;
	private int rentPerDay;
	
	public String getBikeTypeId() {
		return bikeTypeId;
	}

	public int getRentPerHour() {
		return rentPerHour;
	}

	public int getRentPerDay() {
		return rentPerDay;
	}

}
