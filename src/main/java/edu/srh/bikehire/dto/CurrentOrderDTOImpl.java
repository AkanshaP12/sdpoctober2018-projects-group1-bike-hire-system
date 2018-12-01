package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentOrderDTOImpl {
	
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private String orderID;
	@Column(name = "UserID")
	private String userID;
	@Column(name = "BikeID")
	private String bikeID;
	@Column(name = "BookingTimeStamp")
	private Calendar bookingTimeStamp;
	@Column(name = "PickupTimeStamp")
	private Calendar pickupTimeStamp;
	@Column(name = "DropOffTimeStamp")
	private Calendar dropOffTimeStamp;
	@Column(name = "ActualDropOffTimeStamp")
	private Calendar actualDropOffTimeStamp;
	@Column(name = "UserID")
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
