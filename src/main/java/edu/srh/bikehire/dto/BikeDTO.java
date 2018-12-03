package edu.srh.bikehire.dto;

import java.util.Calendar;

public interface BikeDTO {
	
	public String getBikeId();
	public String getBikeTypeId();
	public String getManufacturer();
	public int getYearOfManufacture();
	public String getBikeTitle();
	public String getWareHouseID();
	public int getDepositAmount();
	public Calendar getCreationTimeStamp();
}
