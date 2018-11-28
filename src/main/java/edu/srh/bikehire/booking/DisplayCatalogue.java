package edu.srh.bikehire.booking;

import java.util.List;

public interface DisplayCatalogue {
	
	//Get available bikes
	//Filter according to date
	//Sort according to price
	
	public List<?> getAvailability(String PickupTimeStamp, String ReturnedTimeStamp, Integer RentPerDay);

}
