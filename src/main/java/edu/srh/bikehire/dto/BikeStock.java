package edu.srh.bikehire.dto;

import java.math.BigInteger;

public class BikeStock {

/* 
	CREATE TABLE `BikeStock` (
	`BikeTypeId` bigint NOT NULL,
	`TotalQuantity` bigint NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	);

 */
	private BigInteger bikeTypeId;
	private BigInteger totalQuantity;
	private String creationTimeStamp;
	private String lastModifiedTimeStamp;
	
	public BigInteger getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(BigInteger totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(String creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	public String getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(String lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	public BigInteger getBikeTypeId() {
		return bikeTypeId;
	}
	public void setBikeTypeId(BigInteger bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}


}
