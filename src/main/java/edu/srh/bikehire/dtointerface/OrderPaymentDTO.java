package edu.srh.bikehire.dtointerface;


public interface OrderPaymentDTO {

	public String getPaymentReference();
	public String getOrderID();
	public int getDepositAmount();
	public int getRentPerHour();
	public int getRentPerDay();
		
}
