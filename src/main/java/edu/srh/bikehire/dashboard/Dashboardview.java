package edu.srh.bikehire.dashboard;

import java.util.Calendar;
import java.util.List;

public interface Dashboardview{
	
	
	
	
	public long countview(BikeStatusType pStatusType,  String Biketype );


    public List<OrderAppointment> upcomingappointment(Calendar pQueryDate);


}
