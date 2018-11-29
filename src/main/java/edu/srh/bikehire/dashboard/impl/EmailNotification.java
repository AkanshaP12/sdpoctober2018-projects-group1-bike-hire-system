package edu.srh.bikehire.dashboard.impl;

import java.util.ArrayList;
import java.util.List;

import edu.srh.bikehire.dashboard.EmailNotificationType;
import edu.srh.bikehire.dashboard.Invoice;
import edu.srh.bikehire.dashboard.Notification;
import edu.srh.bikehire.dashboard.Order;
import edu.srh.bikehire.dashboard.util.Sendemail;
import edu.srh.bikehire.login.Entity;

public class EmailNotification implements Notification {

	public void emailVerification(Entity pEntity, String pSecurityCode, int pType) {
		// TODO Auto-generated method stub
		Sendemail lNewEmail = new Sendemail();
		
		
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());
		
		//Create Subject for this email
		String lstrSubjectLine = "Confirm Emaid ID";
		//Create Email body text - Use pSecurityCode
		
		String lstrBodyLine = "Here is your SECURITY CODE";
		
		lNewEmail.sendEmail(pToEmailAddresses, lstrSubjectLine, lstrBodyLine);
		

	}

	public void passwordResetSuccess(Entity pEntity) {
		// TODO Auto-generated method stub
		Sendemail lpasswordreset = new Sendemail();
		
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());
		
		//Create Subject for this email
				String lstrSubjectLine = "Verify Password";
				//Create Email body text - Use pSecurityCode
				
				String lstrBodyLine = "Click Reset Password";
				
		lpasswordreset.sendEmail(pToEmailAddresses, lstrSubjectLine, lstrBodyLine);

	}

	public void bookingConfirmation(Order pOrder, Entity pEntity) {
		// TODO Auto-generated method stub
		
         Sendemail lbookingconfirmed = new Sendemail();
		
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());
		
		//Create Subject for this email
				String lstrSubjectLine = "Booking Confirmed";
				//Create Email body text - Use pSecurityCode
				
				String lstrBodyLine = "YAY! your booking is confirmed";
				
			lbookingconfirmed.sendEmail(pToEmailAddresses, lstrSubjectLine, lstrBodyLine);
		
		
	}

	public void cancelBooking(Order pOrder, Entity pEntity) {
		// TODO Auto-generated method stub
		
		  Sendemail lcancellation = new Sendemail();
			
			List<String> pToEmailAddresses = new ArrayList<String>();
			pToEmailAddresses.add(pEntity.getEmailId());
			
			//Create Subject for this email
					String lstrSubjectLine = "Cancellation Request";
					//Create Email body text - Use pSecurityCode
					
					String lstrBodyLine = "SORRY! your booking has been cancelled";
					
			lcancellation.sendEmail(pToEmailAddresses, lstrSubjectLine, lstrBodyLine);
		
	}

	public void orderInvoice(Order pOrder, Invoice pInvoice) {
		// TODO Auto-generated method stub
		
		 Sendemail lInvoice = new Sendemail();
			
			List<String> pToEmailAddresses = new ArrayList<String>();
			pToEmailAddresses.add(pEntity.getEmailId());
			
			//Create Subject for this email
					String lstrSubjectLine = "INVOICE";
					//Create Email body text - Use pSecurityCode
					
					String lstrBodyLine = "Here's your invoice";
					
		lInvoice.sendEmail(pToEmailAddresses, lstrSubjectLine, lstrBodyLine);
			
	
		
		
	}

}
