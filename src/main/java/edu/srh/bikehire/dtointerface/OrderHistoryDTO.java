package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface OrderHistoryDTO {
	
	public String getOrderID();
	public String getInvoiceID();
	public String getUserID();
	public String getBikeID();
	public Calendar getBookingTimeStamp();
	public Calendar getPickupTimeStamp();
	public Calendar getReturnedTimeStamp();
	
}
