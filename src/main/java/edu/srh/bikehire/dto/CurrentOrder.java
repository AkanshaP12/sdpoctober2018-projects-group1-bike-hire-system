package edu.srh.bikehire.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

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

	private BigInteger orderID;
	private String userID;
	private BigInteger bikeID;
	private Timestamp bookingTimeStamp;
	private Timestamp pickupTimeStamp;
	private Timestamp dropOffTimeStamp;
	private Timestamp actualDropOffTimeStamp;
	private String orderMode;
	
	public BigInteger getOrderID() {
		return orderID;
	}
	public void setOrderID(BigInteger orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public BigInteger getBikeID() {
		return bikeID;
	}
	public void setBikeID(BigInteger bikeID) {
		this.bikeID = bikeID;
	}
	public Timestamp getBookingTimeStamp() {
		return bookingTimeStamp;
	}
	public void setBookingTimeStamp(Timestamp bookingTimeStamp) {
		this.bookingTimeStamp = bookingTimeStamp;
	}
	public Timestamp getPickupTimeStamp() {
		return pickupTimeStamp;
	}
	public void setPickupTimeStamp(Timestamp pickupTimeStamp) {
		this.pickupTimeStamp = pickupTimeStamp;
	}
	public Timestamp getDropOffTimeStamp() {
		return dropOffTimeStamp;
	}
	public void setDropOffTimeStamp(Timestamp dropOffTimeStamp) {
		this.dropOffTimeStamp = dropOffTimeStamp;
	}
	public Timestamp getActualDropOffTimeStamp() {
		return actualDropOffTimeStamp;
	}
	public void setActualDropOffTimeStamp(Timestamp actualDropOffTimeStamp) {
		this.actualDropOffTimeStamp = actualDropOffTimeStamp;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	
	
}
