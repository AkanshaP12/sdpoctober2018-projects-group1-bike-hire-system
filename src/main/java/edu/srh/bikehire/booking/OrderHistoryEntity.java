package edu.srh.bikehire.booking;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface OrderHistoryEntity {
	
	public BigInteger OrderID();
	
	public BigInteger InvoiceID();
	
	public BigInteger UserID();
	
	public BigInteger BikeID();
	
	public Timestamp BookingTimeStamp();
	
	public Timestamp PickupTimeStamp();
	
	public Timestamp ReturnedTimeStamp();
}
