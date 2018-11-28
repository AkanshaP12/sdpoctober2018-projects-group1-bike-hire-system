package edu.srh.bikehire.dto;

import java.util.Calendar;

public class OrderHistory {

	/*
	 CREATE TABLE `OrderHistory` (
	`OrderID` bigint NOT NULL,
	`InvoiceID` bigint NOT NULL,
	`UserID` varchar(100) NOT NULL,
	`BikeID` bigint NOT NULL,
	`BookingTimeStamp` TIMESTAMP NOT NULL,
	`PickupTimeStamp` TIMESTAMP NOT NULL,
	`ReturnedTimeStamp` TIMESTAMP NOT NULL
	);
	 */
	
	private String orderID;
	private String invoiceID;
	private String userID;
	private String bikeID;
	private Calendar bookingTimeStamp;
	private Calendar pickupTimeStamp;
	private Calendar returnedTimeStamp;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
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
	public Calendar getReturnedTimeStamp() {
		return returnedTimeStamp;
	}
	public void setReturnedTimeStamp(Calendar returnedTimeStamp) {
		this.returnedTimeStamp = returnedTimeStamp;
	}
	
	
	
	
}
