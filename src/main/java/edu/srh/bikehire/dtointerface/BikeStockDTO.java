package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface BikeStockDTO {

	public String getBikeTypeId();
	public long getTotalQuantity();
	public Calendar getCreationTimeStamp();
	public Calendar getLastModifiedTimeStamp();
}
