package edu.srh.bikehire.booking;

import java.math.BigInteger;

public interface PaymentEntity {
	
	public BigInteger PaymentReference();
	
	public Integer DepositAmount();
	
	public Integer RentPerDay();
	
	public Integer RentPerHour();
	
	public Integer FinalAmount();
	
}
