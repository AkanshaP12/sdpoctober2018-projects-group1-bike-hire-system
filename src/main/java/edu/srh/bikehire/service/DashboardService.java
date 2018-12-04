package edu.srh.bikehire.service;

import java.util.Calendar;
import java.util.List;

import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.OrderAppointment;

public interface DashboardService{

	public long getBikeCount(BikeStatusType statusType,  int bikeTypeId );


    public List<OrderAppointment> getUpcomingAppointments(Calendar queryDate, boolean isPickUpAppointment) throws BikeHireSystemException;


}
