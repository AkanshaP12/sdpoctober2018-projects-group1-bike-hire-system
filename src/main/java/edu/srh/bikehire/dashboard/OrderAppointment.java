package edu.srh.bikehire.dashboard;

import java.util.Calendar;

public interface OrderAppointment {
	public String getOrderId();
	
	public String getUserName();
	
	public String getBikeId();
	
	public String getBikeName();
	
	public Calendar getPickupTimestamp();
	
	public Calendar getDropoffTimestamp();
}
