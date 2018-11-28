package edu.srh.bikehire.booking.impl;

import edu.srh.bikehire.booking.DisplayCatalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class getCatalogue implements DisplayCatalogue {
	
	public List<?> getAvailability(String PickupTimeStamp, String ReturnedTimeStamp, Integer RentPerDay) {
		return null;
		// TODO Add PickupTimeStamp, ReturnedTimeStamp or RentPerday to api as params and query DB for 
		//availability. If none of the fields are added return all the available bikes.
		//If Pickup and DropOff Dates are added show accordingly.
		
	}

}