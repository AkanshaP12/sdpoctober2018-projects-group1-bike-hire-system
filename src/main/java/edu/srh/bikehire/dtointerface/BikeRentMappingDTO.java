package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface BikeRentMappingDTO {
	
	public String getBikeTypeId();
	public void setBikeType(BikeTypeDTO pBikeTypeDTO);
	public int getRentPerHour();
	public int getRentPerDay();
	public Calendar getLastModifiedTimeStamp();
}
