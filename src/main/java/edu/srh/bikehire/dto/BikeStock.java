package edu.srh.bikehire.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BikeStock {

/* 
	CREATE TABLE `BikeStock` (
	`BikeTypeId` bigint NOT NULL,
	`TotalQuantity` bigint NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	);

 */
	@Column(name = "BikeTypeId")
	private String bikeTypeId;
	@Column(name = "TotalQuantity")
	private String totalQuantity;
	@Column(name = "CreationTimeStamp")
	private String creationTimeStamp;
	@Column(name = "LastModifiedTimeStamp")
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
