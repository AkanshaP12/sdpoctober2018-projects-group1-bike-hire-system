package edu.srh.bikehire.dto;

import javax.persistence.Column;

public class OrderPaymentDTOImpl {
	
/*  
 	CREATE TABLE `OrderPayment` (
	`PaymentReference` bigint NOT NULL,
	`OrderID` bigint NOT NULL,
	`DepositAmount` int(10) NOT NULL,
	`RentPerHour` int(10) NOT NULL,
	`RentPerDay` int(10) NOT NULL,
	PRIMARY KEY (`PaymentReference`)
	);
 */

	@Column(name = "PaymentReference")
	private String paymentReference;
	@Column(name = "OrderID")
	private String orderID;
	@Column(name = "DepositAmount")
	private int depositAmount;
	@Column(name = "RentPerHour")
	private int rentPerHour;
	@Column(name = "RentPerDay")
	private int rentPerDay;
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	public int getRentPerHour() {
		return rentPerHour;
	}
	public void setRentPerHour(int rentPerHour) {
		this.rentPerHour = rentPerHour;
	}
	public int getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(int rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	

	
}
