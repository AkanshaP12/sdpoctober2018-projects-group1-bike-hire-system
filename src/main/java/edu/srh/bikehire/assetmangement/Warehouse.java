package edu.srh.bikehire.assetmangement;

import java.util.Calendar;

public class Warehouse {
	private String wareHouseID;
	private String wareHouseName;
	private String wareHouseLocation;
	private int wareHouseCapacity;
	private Calendar creationTimeStamp;
	private Calendar lastModifiedTimeStamp;
	
	
	public String getWareHouseID() {
		return wareHouseID;
	}
	public void setWareHouseID(String wareHouseID) {
		this.wareHouseID = wareHouseID;
	}
	public String getWareHouseName() {
		return wareHouseName;
	}
	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}
	public String getWareHouseLocation() {
		return wareHouseLocation;
	}
	public void setWareHouseLocation(String wareHouseLocation) {
		this.wareHouseLocation = wareHouseLocation;
	}
	public int getWareHouseCapacity() {
		return wareHouseCapacity;
	}
	public void setWareHouseCapacity(int wareHouseCapacity) {
		this.wareHouseCapacity = wareHouseCapacity;
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
