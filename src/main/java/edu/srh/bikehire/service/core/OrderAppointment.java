package edu.srh.bikehire.service.core;

import java.util.Calendar;

public interface OrderAppointment {
	public String getOrderId();
	
	public String getName();
	
	public String getBikeId();
	
	public String getBikeName();
	
	public Calendar getPickupTimestamp();
	
	public Calendar getDropoffTimestamp();
}
