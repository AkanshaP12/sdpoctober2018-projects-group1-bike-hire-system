package edu.srh.bikehire.service.core;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface Order {
	
	public BigInteger OrderID();
	
	public BigInteger InvoiceID();
	
	public BigInteger UserID();
	
	public BigInteger BikeID();
	
	public Timestamp BookingTimeStamp();
	
	public Timestamp PickupTimeStamp();
	
	public Timestamp ReturnedTimeStamp();
}
