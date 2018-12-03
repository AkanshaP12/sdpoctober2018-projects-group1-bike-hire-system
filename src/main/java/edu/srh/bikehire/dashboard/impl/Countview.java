package edu.srh.bikehire.dashboard.impl;

import java.util.Calendar;
import java.util.List;

import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dashboard.Dashboardview;
import edu.srh.bikehire.dashboard.OrderAppointment;


//import bike interface here(if created)

public class Countview implements Dashboardview {

	public long countview(BikeStatusType pStatusType, String Biketype) {
		// TODO Fetch data from database.
		return 0;
	}

	public List<OrderAppointment> upcomingappointment(Calendar pQueryDate) {
		// TODO Fetch data from database
		return null;
	}
}

