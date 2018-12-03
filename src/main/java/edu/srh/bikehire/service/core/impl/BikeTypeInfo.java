package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.BikeType;

public class BikeTypeInfo implements BikeType {
	private String bikeTypeId;
	private String bikeType;
	private String ageCategory;
	
	public String getBikeTypeId() {
		return bikeTypeId;
	}

	public String getBikeType() {
		return bikeType;
	}

	public String getAgeCategory() {
		return ageCategory;
	}

}
