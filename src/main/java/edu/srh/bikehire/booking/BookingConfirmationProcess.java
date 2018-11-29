package edu.srh.bikehire.booking;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface BookingConfirmationProcess {

	public void bookingConfirmation(String BikeID, BigInteger OrderID, BigInteger UserID, Timestamp BookingTimeStamp, Timestamp PickupTimeStamp, String OrderMode );
	
	public void bookingCancel(BigInteger OrderID);
}
