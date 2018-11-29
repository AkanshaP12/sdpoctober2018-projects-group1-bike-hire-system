package edu.srh.bikehire.booking;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface BookingConfEntity {
	
	public Timestamp PickupTimeStamp();
	
	public Timestamp ReturnTimeStamp();
	
	public BigInteger BikeID();
	
	public BigInteger PaymentReference();
	
	public BigInteger UserID();
	
	public Integer FinalAmount();
	
	public Integer DepositAmount();
	
}
