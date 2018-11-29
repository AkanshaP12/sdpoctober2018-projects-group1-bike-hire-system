package edu.srh.bikehire.booking.impl;

import java.math.BigInteger;
import java.sql.Timestamp;

import edu.srh.bikehire.booking.BookingConfirmationProcess;

public class makeBooking implements BookingConfirmationProcess {

	public void bookingConfirmation(String BikeID, BigInteger OrderID, BigInteger UserID, Timestamp BookingTimeStamp,
			Timestamp PickupTimeStamp, String OrderMode) {
		// TODO Create an object with all the above values and add it to the database. 
		
	}
	
	public void bookingCancel(BigInteger OrderID) {
		// TODO Retrieve the OrderID from the DB and delete/change the status of the Bike.
		
	}


}
