package edu.srh.bikehire.dto;

import java.math.BigInteger;

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

	private BigInteger paymentReference;
	private BigInteger orderID;
	private int depositAmount;
	private int rentPerHour;
	private int rentPerDay;
	
	public BigInteger getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(BigInteger paymentReference) {
		this.paymentReference = paymentReference;
	}
	public BigInteger getOrderID() {
		return orderID;
	}
	public void setOrderID(BigInteger orderID) {
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
