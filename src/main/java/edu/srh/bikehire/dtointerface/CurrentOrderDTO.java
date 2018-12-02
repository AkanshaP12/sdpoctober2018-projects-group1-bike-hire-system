package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface CurrentOrderDTO {
	
	public String getOrderID();
	public String getUserID();
	public String getBikeID();
	public Calendar getBookingTimeStamp();
	public Calendar getPickupTimeStamp();
	public Calendar getDropOffTimeStamp();
	public Calendar getActualDropOffTimeStamp();
	public String getOrderMode();
	
}
