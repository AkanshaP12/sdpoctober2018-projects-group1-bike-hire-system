package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface CurrentOrderDTO {
	
	public String getOrderID();
	public String getUserID();
	public void setUserDTO(UserDTO pUserDTO);
	public String getBikeID();
	public void setBikeDTO(BikeDTO pBikeDTO);
	public Calendar getBookingTimeStamp();
	public Calendar getPickupTimeStamp();
	public Calendar getDropOffTimeStamp();
	public Calendar getActualDropOffTimeStamp();
	public String getOrderMode();
	
}
