package edu.srh.bikehire.dto;

import java.util.Calendar;

public interface OrderHistoryDTO {
	
	public int getOrderID();
	public String getInvoiceID();
	public int getUserID();
	public int getBikeID();
	public Calendar getBookingTimeStamp();
	public Calendar getPickupTimeStamp();
	public Calendar getReturnedTimeStamp();
	public void setInvoiceDTO(InvoiceDTO pInvoiceDTO);
	public void setUserDTO(UserDTO pUserDTO);
	public void setBikeDTO(BikeDTO pBikeDTO);
}
