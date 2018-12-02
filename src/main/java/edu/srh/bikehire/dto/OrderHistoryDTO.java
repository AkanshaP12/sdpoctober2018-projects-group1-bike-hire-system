package edu.srh.bikehire.dto;

import java.util.Calendar;

public interface OrderHistoryDTO {
	
	public String getOrderID();
	public String getInvoiceID();
	public String getUserID();
	public String getBikeID();
	public Calendar getBookingTimeStamp();
	public Calendar getPickupTimeStamp();
	public Calendar getReturnedTimeStamp();
	public void setInvoiceDTO(InvoiceDTO pInvoiceDTO);
	public void setUserDTO(UserDTO pUserDTO);
	public void setBikeDTO(BikeDTO pBikeDTO);
}
