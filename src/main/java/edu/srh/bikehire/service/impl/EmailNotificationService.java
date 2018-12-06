package edu.srh.bikehire.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.srh.bikehire.dashboard.EmailNotificationType;
import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.dashboard.util.MailSender;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.NotificationService;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.Order;

public class EmailNotificationService implements NotificationService {

	public void emailVerification(String emailId, String pSecurityCode, boolean isOnboardingEmail) throws BikeHireSystemException {
		MailSender lNewEmail = MailSender.getInstance();

		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(emailId);

		String bodyTextLine = null;
		String subjectLine = null;
		if(isOnboardingEmail)
		{
			bodyTextLine = EmailNotificationType.REGISTRATION_CONFIRMATION.getBodyText();			
			bodyTextLine = bodyTextLine.replace("$SECURITY_CODE$", pSecurityCode);
			subjectLine = EmailNotificationType.REGISTRATION_CONFIRMATION.getSubjectLine();
		}
		else
		{
			bodyTextLine = EmailNotificationType.RESET_PASSWORD.getBodyText();			
			bodyTextLine = bodyTextLine.replace("$SECURITY_CODE$", pSecurityCode);
			subjectLine = EmailNotificationType.RESET_PASSWORD.getSubjectLine();
		}
		
		lNewEmail.sendEmail(pToEmailAddresses,subjectLine,
				bodyTextLine);
	}

	public void passwordResetSuccess(String emailId) throws BikeHireSystemException {
		MailSender lpasswordreset = MailSender.getInstance();

		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(emailId);
		lpasswordreset.sendEmail(pToEmailAddresses, EmailNotificationType.RESET_PASSWORD_SUCCESS.getSubjectLine(),
				EmailNotificationType.RESET_PASSWORD_SUCCESS.getBodyText());

	}

	public void bookingConfirmation(int orderId, String emailId) throws BikeHireSystemException {

		MailSender lbookingconfirmed = MailSender.getInstance();

		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(emailId);
		String bodyTextLine = EmailNotificationType.BOOKING_CONFIRMATION.getBodyText().replace("$ORDER_ID$", String.valueOf(orderId));
		String subjectLine = EmailNotificationType.BOOKING_CONFIRMATION.getSubjectLine();

		lbookingconfirmed.sendEmail(pToEmailAddresses, subjectLine, bodyTextLine);
	}

	public void cancelBooking(int orderId, String emailId) throws BikeHireSystemException {

		MailSender lcancellation = MailSender.getInstance();
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(emailId);
		String bodyTextLine = EmailNotificationType.BOOKING_CANCEL.getBodyText().replace("$ORDER_ID$", String.valueOf(orderId));
		String subjectLine = EmailNotificationType.BOOKING_CANCEL.getSubjectLine();
		lcancellation.sendEmail(pToEmailAddresses, subjectLine, bodyTextLine);

	}

	public void orderInvoice(int orderId, String invoiceId, int finalAmount, String emailId) throws BikeHireSystemException {
		MailSender lInvoice = MailSender.getInstance();
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(emailId);
		String bodyTextLine = EmailNotificationType.BOOKING_INVOICE.getBodyText().replace("$ORDER_ID$", String.valueOf(orderId));
		bodyTextLine = bodyTextLine.replace("$INVOICE_ID$", invoiceId);
		bodyTextLine = bodyTextLine.replace("$AMOUNT$", String.valueOf(finalAmount));
		String subjectLine = EmailNotificationType.BOOKING_INVOICE.getSubjectLine();
		lInvoice.sendEmail(pToEmailAddresses, subjectLine,bodyTextLine);
	}
	
}


