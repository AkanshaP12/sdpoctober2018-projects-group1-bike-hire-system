package edu.srh.bikehire.dashboard.impl;

import java.util.Calendar;

import edu.srh.bikehire.dashboard.OrderAppointment;

public class UpcomingAppointment implements OrderAppointment {

	private String OrderId;
	
	private String UserName;
	
	private String BikeId;
	
	private String BikeName;
	
	private Calendar PickupTimestamp;
	
	private Calendar DropoffTimestamp;
	
	
	
	
	public String getOrderId() {
		return OrderId;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return UserName;
	}

	public String getBikeId() {
		// TODO Auto-generated method stub
		return BikeId;
	}

	public String getBikeName() {
		// TODO Auto-generated method stub
		return BikeName;
	}

	public Calendar getPickupTimestamp() {
		// TODO Auto-generated method stub
		return PickupTimestamp;
	}

	public Calendar getDropoffTimestamp() {
		// TODO Auto-generated method stub
		return DropoffTimestamp;
	}

}
