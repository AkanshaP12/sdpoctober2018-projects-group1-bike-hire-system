package edu.srh.bikehire.service;

import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.Order;

public interface NotificationService {

	//pType = 1 : For Registration
	//pType = 2 : For forgot password
	public void emailVerification(Entity pEntity, String pSecurityCode, int pType) throws BikeHireSystemException;
	
	
	public void passwordResetSuccess(Entity pEntity) throws BikeHireSystemException;
	
	public void bookingConfirmation(Order pOrder, Entity pEntity) throws BikeHireSystemException;
	
	public void cancelBooking(Order pOrder, Entity pEntity) throws BikeHireSystemException;
	
	public void orderInvoice(Order pOrder, Invoice pInvoice, Entity pEntity) throws BikeHireSystemException;
	
	
	
}
