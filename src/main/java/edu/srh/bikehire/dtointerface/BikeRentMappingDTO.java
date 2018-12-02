package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface BikeRentMappingDTO {
	
	public String getBikeTypeId();
	public int getRentPerHour();
	public int getRentPerDay();
	public Calendar getLastModifiedTimeStamp();
}
