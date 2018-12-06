package edu.srh.bikehire.service;

import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.Order;

public interface NotificationService {

	//pType = 1 : For Registration
	//pType = 2 : For forgot password
	public void emailVerification(String emailId, String pSecurityCode, boolean isOnBoardingEmail) throws BikeHireSystemException;
	
	
	public void passwordResetSuccess(String emailId) throws BikeHireSystemException;
	
	public void bookingConfirmation(int orderId, String emailId) throws BikeHireSystemException;
	
	public void cancelBooking(int orderId, String emailId) throws BikeHireSystemException;
	
	public void orderInvoice(int orderId, String invoiceId, int finalAmount ,String emailId) throws BikeHireSystemException;
	
	
	
}
