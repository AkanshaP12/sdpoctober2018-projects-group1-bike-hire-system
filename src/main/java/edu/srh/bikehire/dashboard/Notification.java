package edu.srh.bikehire.dashboard;

import edu.srh.bikehire.login.Entity;

public interface Notification {

	//pType = 1 : For Registration
	//pType = 2 : For forgot password
	public void emailVerification(Entity pEntity, String pSecurityCode, int pType);
	
	public void passwordResetSuccess(Entity pEntity);
	
	public void bookingConfirmation(Order pOrder, Entity pEntity);
	
	public void cancelBooking(Order pOrder, Entity pEntity);
	
	public void orderInvoice(Order pOrder, Invoice pInvoice);
	
}
