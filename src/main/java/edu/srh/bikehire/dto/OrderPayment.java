package edu.srh.bikehire.dto;


public class OrderPayment {
	
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

	private String paymentReference;
	private String orderID;
	private int depositAmount;
	private int rentPerHour;
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
