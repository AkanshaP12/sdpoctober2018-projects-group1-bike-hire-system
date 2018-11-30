package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WareHouseID")
	private String wareHouseID;
	@Column(name = "Name")
	private String name;
	@Column(name = "Location")
	private String location;
	@Column(name = "StorageCapacity")
	private int storageCapacity;
	@Column(name = "CreationTimeStamp")
	private Calendar creationTimeStamp;
	@Column(name = "LastModifiedTimeStamp")
	private Calendar lastModifiedTimeStamp;
	public String getWareHouseID() {
		return wareHouseID;
	}
	public void setWareHouseID(String wareHouseID) {
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
	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	public Calendar getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Calendar lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	

}
