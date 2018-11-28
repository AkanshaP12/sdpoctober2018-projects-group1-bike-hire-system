package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface Invoice {

	public String getInvoiceID();
	public String getOrderID();
	public Calendar getCreationTimeStamp();
	public int getFinalAmount();
	public int getReturnDeposit();
	public int getDamageCharges();
	public String getWarehouseID();
	
}
