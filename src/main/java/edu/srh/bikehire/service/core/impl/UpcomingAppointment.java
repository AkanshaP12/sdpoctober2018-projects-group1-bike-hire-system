package edu.srh.bikehire.service.core.impl;

import java.util.Calendar;

import edu.srh.bikehire.service.core.OrderAppointment;

public class UpcomingAppointment implements OrderAppointment {

	private String orderId;
	
	private String name;
	
	private String bikeId;
	
	private String bikeName;
	
	private Calendar pickupTimestamp;
	
	private Calendar dropoffTimestamp;
	
	public String getOrderId() {
		return orderId;
	}

	public String getName() {
		return name;
	}

	public String getBikeId() {
		return bikeId;
	}

	public String getBikeName() {
		return bikeName;
	}

	public Calendar getPickupTimestamp() {
		return pickupTimestamp;
	}

	public Calendar getDropoffTimestamp() {
		return dropoffTimestamp;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public void setPickupTimestamp(Calendar pickupTimestamp) {
		this.pickupTimestamp = pickupTimestamp;
	}

	public void setDropoffTimestamp(Calendar dropoffTimestamp) {
		this.dropoffTimestamp = dropoffTimestamp;
	}
	
}
