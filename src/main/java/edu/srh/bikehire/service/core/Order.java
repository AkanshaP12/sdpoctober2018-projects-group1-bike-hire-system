package edu.srh.bikehire.service.core;
import java.util.Calendar;

public interface Order {
	
	public String getOderId();
	
	public String getUserId();
	
	public String getBikeId();
	
	public Calendar getBookingTimestamp();
	
	public Calendar getPickupTimestamp();
	
	public Calendar getDropoffTimestamp();
	
	public Calendar getActualdropoffTimestamp();
	
	 public String getOrderMode();
	 

}
