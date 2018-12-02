package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface InvoiceDTO {

	public String getInvoiceID();
	public String getOrderID();
	public void setCurrentOrderDTO(CurrentOrderDTO pCurrentOrderDTO);
	public Calendar getCreationTimeStamp();
	public int getFinalAmount();
	public int getReturnDeposit();
	public int getDamageCharges();
	public String getWarehouseID();
	public void setWarehouseDTO(WareHouseDTO pWareHouseDTO);
}
