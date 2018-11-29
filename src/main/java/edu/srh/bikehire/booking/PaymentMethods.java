package edu.srh.bikehire.booking;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface PaymentMethods {
	
	public void processPayment(Integer UserID, BigInteger BikeID, Timestamp PickupTimeStamp, Timestamp ReturnTimeStamp, Integer FinalAmount, Integer Deposit);
	
	public boolean paymentConfirmation(BigInteger PaymentReference);
	
	public boolean paymentRefund(Integer UserID, Integer FinalAmount, Integer Deposit, BigInteger OrderID);
}
