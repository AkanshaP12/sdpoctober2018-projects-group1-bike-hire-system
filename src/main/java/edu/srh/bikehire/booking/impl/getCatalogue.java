package edu.srh.bikehire.booking.impl;

import edu.srh.bikehire.booking.DisplayCatalogue;

import java.util.List;

public class getCatalogue implements DisplayCatalogue {
	
	public List<Bike> getAvailability(String PickupTimeStamp, String ReturnedTimeStamp, Integer RentPerDay) {
		return null;
		// TODO Add PickupTimeStamp, ReturnedTimeStamp or RentPerday to api as params and query DB for 
		//availability. If none of the fields are added return all the available bikes.
		//If Pickup and DropOff Dates are added show accordingly.
		
	}

	public void selectBike(String BikeID) {
		// TODO Enter BikeID to book the bike and send it back to the DB and reduce the qty. 
		
	}

}