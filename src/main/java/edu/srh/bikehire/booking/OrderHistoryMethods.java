package edu.srh.bikehire.booking;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface OrderHistoryMethods {
	
	public void showOrderHistory(BigInteger OrderID, BigInteger InvoiceID, BigInteger UserID, BigInteger BikeID, Timestamp BookingTimeStamp, Timestamp PickupTimeStamp, Timestamp ReturnedTimeStamp);
}
