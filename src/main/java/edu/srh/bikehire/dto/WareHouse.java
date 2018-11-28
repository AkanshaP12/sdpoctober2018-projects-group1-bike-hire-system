package edu.srh.bikehire.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class WareHouse {
	
	/*
	 CREATE TABLE `WareHouse` (
	`WareHouseID` bigint NOT NULL,
	`Name` varchar(200) NOT NULL,
	`Location` varchar(200) NOT NULL,
	`StorageCapacity` int(8) NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL,
	PRIMARY KEY (`WareHouseID`)
	);
	 */

	private BigInteger wareHouseID;
	private String name;
	private String location;
	private int storageCapacity;
	private Timestamp creationTimeStamp;
	private Timestamp lastModifiedTimeStamp;
	
	public BigInteger getWareHouseID() {
		return wareHouseID;
	}
	public void setWareHouseID(BigInteger wareHouseID) {
		this.wareHouseID = wareHouseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public Timestamp getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Timestamp creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	public Timestamp getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Timestamp lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	
}
