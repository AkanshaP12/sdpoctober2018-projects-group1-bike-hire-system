package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface BikeStatusDTO {

	public String getBikeId();
	public String getStatus();
	public Calendar getLastServiceDate();
	public Calendar getLastModifiedDate();
	public String getManufacturer();
	
}
