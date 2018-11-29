package edu.srh.bikehire.booking.impl;

import java.math.BigInteger;
import java.sql.Timestamp;

import edu.srh.bikehire.booking.PaymentMethods;

public class makePayment implements PaymentMethods {
	
	public void processPayment(Integer UserID, BigInteger BikeID, Timestamp PickupTimeStamp, Timestamp ReturnTimeStamp, Integer FinalAmount, Integer Deposit) {
		// TODO 
		
	}
	
	public boolean paymentConfirmation(BigInteger PaymentReference) {
		// TODO Check if Payment reference is null or some id has been generated.
		return false;
	}

	public boolean paymentRefund(Integer UserID, Integer FinalAmount, Integer Deposit, BigInteger OrderID) {
		// TODO Check if the booking is cancelled, and then refund the deposit and final amount.
		return false;
	}

}
