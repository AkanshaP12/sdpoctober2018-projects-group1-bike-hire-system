package edu.srh.bikehire.dto;

import java.math.BigInteger;

public class BikeStatus {

/*
 CREATE TABLE `BikeStatus` (
	`BikeId` bigint NOT NULL,
	`Status` varchar(50) NOT NULL,
	`LastServiceDate` TIMESTAMP NOT NULL,
	`LastModifiedDate` TIMESTAMP NOT NULL,
	`Manufacturer` varchar(200) NOT NULL
 );

 */
	private BigInteger bikeId;
	private String status;
	private String lastServiceDate;
	private String lastModifiedDate;
	private String manufacturer;
	
	public BigInteger getBikeId() {
		return bikeId;
	}
	public void setBikeId(BigInteger bikeId) {
		this.bikeId = bikeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


}
