package edu.srh.bikehire.dashboard;

import java.util.Calendar;

public interface Invoice {

	public String InvoiceId();
	
	public String OrderId();
	
	public Calendar CreationTimestamp();
	
	public int FinalAmount();
	
	public int ReturnAmount();
	 
	public int DamagedCharges();
	
	public int WarehouseId();
	
	
	
}
