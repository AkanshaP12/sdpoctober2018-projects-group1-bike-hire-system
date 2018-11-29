package edu.srh.bikehire.assetmangement;

import java.util.Calendar;

public class BikeStock {
	private String bikeTypeID;
	private int totalQuantity;
	private Calendar creationTimeStamp;
	private Calendar lastModifiedTimeStamp;
	
	
	public String getBikeTypeID() {
		return bikeTypeID;
	}
	public void setBikeTypeID(String bikeTypeID) {
		this.bikeTypeID = bikeTypeID;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
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
