package edu.srh.bikehire.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BikeRentMappingDTOImpl {

/*
	CREATE TABLE `BikeRentMapping` (
	`BikeTypeId` bigint NOT NULL,     ---   Defined in bike.java
	`RentPerHour` int(10) NOT NULL,
	`RentPerDay` int(10) NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	); 	
 */
	@Column(name = "BikeTypeId")
	private String bikeTypeId;
	
	@Column(name = "RentPerHour")
	private int rentPerHour;
	
	@Column(name = "RentPerDay")
	private int rentPerDay;

	@Column(name = "LastModifiedTimeStamp")
	private String lastModifiedTimeStamp;

	public String getBikeTypeId() {
		return bikeTypeId;
	}
	public void setBikeTypeId(String bikeTypeId) {
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
