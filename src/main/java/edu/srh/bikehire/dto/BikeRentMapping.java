package edu.srh.bikehire.dto;

import java.math.BigInteger;

public class BikeRentMapping {

/*
	CREATE TABLE `BikeRentMapping` (
	`BikeTypeId` bigint NOT NULL,     ---   Defined in bike.java
	`RentPerHour` int(10) NOT NULL,
	`RentPerDay` int(10) NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	); 	
 */
	private BigInteger bikeTypeId;
	private int rentPerHour;
	private int rentPerDay;
	private String lastModifiedTimeStamp;
	
	public BigInteger getBikeTypeId() {
		return bikeTypeId;
	}
	public void setBikeTypeId(BigInteger bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}
	public int getRentPerHour() {
		return rentPerHour;
	}
	public void setRentPerHour(int rentPerHour) {
		this.rentPerHour = rentPerHour;
	}
	public int getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(int rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	public String getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(String lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	
	
	
}
