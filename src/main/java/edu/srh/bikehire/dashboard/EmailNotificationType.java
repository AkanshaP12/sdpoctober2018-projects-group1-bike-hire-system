package edu.srh.bikehire.dashboard;

public enum EmailNotificationType {
	
	REGISTRATION_CONFIRMATION(1, "Confirm Emaid ID" ,"Here is your SECURITY CODE"),
	RESET_PASSWORD(2, "Verify Password", "Click Reset Password"),
	BOOKING_CONFIRMATION(3, "Booking Confirmed" , "YAY! your booking is confirmed"),
	BOOKING_CANCEL(4, "Cancellation Request" ,"SORRY! your booking has been cancelled"),
	BOOKING_INVOICE(5, "INVOICE", "Here's your invoice");
	
	private int lNotificationType;
	
	private String lSubjectLine;
	
	private String lSubjectBodyText;
	
	private EmailNotificationType(int pType, String pSubjectLine, String pBodyText) {
		lNotificationType = pType;
		lSubjectLine = pSubjectLine;
		lSubjectBodyText = pBodyText;
	}
	

	public int getNotificationType() {
		return lNotificationType;
	}

	public String getSubjectLine() {
		return lSubjectLine;
	}

	public String getSubjectBodyText() {
		return lSubjectBodyText;
	}
	
}
