package edu.srh.bikehire.booking.impl;

import java.math.BigInteger;
import java.sql.Timestamp;

import edu.srh.bikehire.booking.OrderHistoryMethods;

public class displayOrderHistory implements OrderHistoryMethods{

	public void showOrderHistory(BigInteger OrderID, BigInteger InvoiceID, BigInteger UserID, BigInteger BikeID,
			Timestamp BookingTimeStamp, Timestamp PickupTimeStamp, Timestamp ReturnedTimeStamp) {
		// TODO Display order history in JSON format
		
	}

}
