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

	public void emailVerification(Entity pEntity, String pSecurityCode, int pType) throws BikeHireSystemException {
		MailSender lNewEmail = MailSender.getInstance();

		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());

		lNewEmail.sendEmail(pToEmailAddresses, EmailNotificationType.REGISTRATION_CONFIRMATION.getSubjectLine(),
				EmailNotificationType.REGISTRATION_CONFIRMATION.getBodyText());
	}

	public void passwordResetSuccess(Entity pEntity) throws BikeHireSystemException {
		MailSender lpasswordreset = MailSender.getInstance();

		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());
		lpasswordreset.sendEmail(pToEmailAddresses, EmailNotificationType.RESET_PASSWORD.getSubjectLine(),
				EmailNotificationType.RESET_PASSWORD.getBodyText());

	}

	public void bookingConfirmation(Order pOrder, Entity pEntity) throws BikeHireSystemException {

		MailSender lbookingconfirmed = MailSender.getInstance();

		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());

		lbookingconfirmed.sendEmail(pToEmailAddresses, EmailNotificationType.BOOKING_CONFIRMATION.getSubjectLine(),
				EmailNotificationType.BOOKING_CONFIRMATION.getBodyText());
	}

	public void cancelBooking(Order pOrder, Entity pEntity) throws BikeHireSystemException {

		MailSender lcancellation = MailSender.getInstance();
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());
		lcancellation.sendEmail(pToEmailAddresses, EmailNotificationType.BOOKING_CANCEL.getSubjectLine(),
				EmailNotificationType.BOOKING_CANCEL.getBodyText());

	}

	public void orderInvoice(Order pOrder, Invoice pInvoice, Entity pEntity) throws BikeHireSystemException {
		MailSender lInvoice = MailSender.getInstance();
		List<String> pToEmailAddresses = new ArrayList<String>();
		pToEmailAddresses.add(pEntity.getEmailId());
		lInvoice.sendEmail(pToEmailAddresses, EmailNotificationType.BOOKING_INVOICE.getSubjectLine(),
				EmailNotificationType.BOOKING_CONFIRMATION.getBodyText());
	}
	
}


