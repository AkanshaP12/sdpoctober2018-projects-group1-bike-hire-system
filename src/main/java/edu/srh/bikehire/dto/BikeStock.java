package edu.srh.bikehire.dto;


public class BikeStock {

/* 
	CREATE TABLE `BikeStock` (
	`BikeTypeId` bigint NOT NULL,
	`TotalQuantity` bigint NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	);

 */
	private String bikeTypeId;
	private String totalQuantity;
	private String creationTimeStamp;
	private String lastModifiedTimeStamp;
	public String getBikeTypeId() {
		return bikeTypeId;
	}
	public void setBikeTypeId(String bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
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
		
	
}
