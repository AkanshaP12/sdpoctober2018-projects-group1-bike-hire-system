package edu.srh.bikehire.booking;

import java.sql.Date;

public interface BookingEntity {
	
	public long bookingId();
	
	public String customerName();
	
	public String emailId();
	
	public String phoneNumber();
	
	public String bikeName();
	
	public Date rentFrom();
	
	public Date rentTill();
	
	public Boolean paymentDone();
}
