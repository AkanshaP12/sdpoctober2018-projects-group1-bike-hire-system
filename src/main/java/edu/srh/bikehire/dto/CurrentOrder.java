package edu.srh.bikehire.dto;

import java.util.Calendar;

public class CurrentOrder {
	
	/*
	 CREATE TABLE `CurrentOrder` (
	`OrderID` bigint NOT NULL AUTO_INCREMENT,
	`UserID` varchar(100) NOT NULL,
	`BikeID` bigint NOT NULL,
	`BookingTimeStamp` TIMESTAMP NOT NULL,
	`PickupTimeStamp` TIMESTAMP NOT NULL,
	`DropOffTimeStamp` TIMESTAMP NOT NULL,
	`ActualDropOffTimeStamp` TIMESTAMP NOT NULL,
	`OrderMode` varchar(20) NOT NULL,
	PRIMARY KEY (`OrderID`)
	);
	 */

	private String orderID;
	private String userID;
	private String bikeID;
	private Calendar bookingTimeStamp;
	private Calendar pickupTimeStamp;
	private Calendar dropOffTimeStamp;
	private Calendar actualDropOffTimeStamp;
	private String orderMode;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBikeID() {
		return bikeID;
	}
	public void setBikeID(String bikeID) {
		this.bikeID = bikeID;
	}
	public Calendar getBookingTimeStamp() {
		return bookingTimeStamp;
	}
	public void setBookingTimeStamp(Calendar bookingTimeStamp) {
		this.bookingTimeStamp = bookingTimeStamp;
	}
	public Calendar getPickupTimeStamp() {
		return pickupTimeStamp;
	}
	public void setPickupTimeStamp(Calendar pickupTimeStamp) {
		this.pickupTimeStamp = pickupTimeStamp;
	}
	public Calendar getDropOffTimeStamp() {
		return dropOffTimeStamp;
	}
	public void setDropOffTimeStamp(Calendar dropOffTimeStamp) {
		this.dropOffTimeStamp = dropOffTimeStamp;
	}
	public Calendar getActualDropOffTimeStamp() {
		return actualDropOffTimeStamp;
	}
	public void setActualDropOffTimeStamp(Calendar actualDropOffTimeStamp) {
		this.actualDropOffTimeStamp = actualDropOffTimeStamp;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	
	
	
	
	
	
}
