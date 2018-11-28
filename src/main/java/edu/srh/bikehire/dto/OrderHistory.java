package edu.srh.bikehire.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

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
	
	private BigInteger orderID;
	private BigInteger invoiceID;
	private String userID;
	private BigInteger bikeID;
	private Timestamp bookingTimeStamp;
	private Timestamp pickupTimeStamp;
	private Timestamp returnedTimeStamp;
	
	
	public BigInteger getOrderID() {
		return orderID;
	}
	public void setOrderID(BigInteger orderID) {
		this.orderID = orderID;
	}
	public BigInteger getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(BigInteger invoiceID) {
		this.invoiceID = invoiceID;
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
	public Timestamp getReturnedTimeStamp() {
		return returnedTimeStamp;
	}
	public void setReturnedTimeStamp(Timestamp returnedTimeStamp) {
		this.returnedTimeStamp = returnedTimeStamp;
	}
	
		
}
