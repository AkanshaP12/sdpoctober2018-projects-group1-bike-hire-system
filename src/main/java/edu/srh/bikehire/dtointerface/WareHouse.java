package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface WareHouse {
	
	public String getWareHouseID();
	public String getName();
	public String getLocation();
	public int getStorageCapacity();
	public Calendar getCreationTimeStamp();
	public Calendar getLastModifiedTimeStamp();

}
