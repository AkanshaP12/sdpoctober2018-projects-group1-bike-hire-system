package edu.srh.bikehire.service.impl;

import java.math.BigInteger;
import java.sql.Timestamp;

import edu.srh.bikehire.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	
	public void processDepositPayment(Integer UserID, BigInteger BikeID, Timestamp PickupTimeStamp, Timestamp ReturnTimeStamp, Integer FinalAmount, Integer Deposit) {
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

	public String processDepositPayment(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String processInvoicePayment(String invoiceId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean paymentRefund(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
