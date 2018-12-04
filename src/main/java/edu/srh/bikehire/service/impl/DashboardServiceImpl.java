package edu.srh.bikehire.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.BikeStatusDAO;
import edu.srh.bikehire.dao.BikeTypeDAO;
import edu.srh.bikehire.dao.CurrentOrderDAO;
import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dao.UserDAO;
import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.CurrentOrderDTO;
import edu.srh.bikehire.dto.UserDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.DashboardService;
import edu.srh.bikehire.service.core.OrderAppointment;
import edu.srh.bikehire.service.core.impl.UpcomingAppointment;

//import bike interface here(if created)

public class DashboardServiceImpl implements DashboardService {

	private BikeDAO bikeDAO;

	private BikeStatusDAO bikeStatusDAO;

	private CurrentOrderDAO currentorderDAO;

	private UserDAO userDAO;

	public void initializeservice() {
		bikeDAO = DAOFactory.getDefualtBikeDAOImpl();
		bikeStatusDAO = DAOFactory.getDefaultBikeStatusDAOImpl();
		currentorderDAO = DAOFactory.getDefaultOrderDAOImpl();
		userDAO = DAOFactory.getDefaultUserDAOImpl();
	}

	public long getBikeCount(BikeStatusType statusType, int bikeTypeId) {
		return bikeStatusDAO.getBikeCount(statusType.getBikeStatus(), bikeTypeId);
	}

	
	public List<OrderAppointment> getUpcomingAppointments(Calendar queryDate, boolean isPickUpAppointment) throws BikeHireSystemException {
		if(queryDate.before(Calendar.getInstance()))
		{
			//TODO : Resolve later.
			throw new BikeHireSystemException(-1);
		}
		
		Calendar l5DayAfter = Calendar.getInstance();
		l5DayAfter.add(Calendar.DATE, 5);
		List<CurrentOrderDTO> lUpcomingOrders = null;
		if(isPickUpAppointment)
		{			
			lUpcomingOrders = currentorderDAO.getOrdersBasedOnPickUpDate(queryDate, l5DayAfter);
		}
		else
		{
			lUpcomingOrders = currentorderDAO.getOrdersBasedOnDropOffDate(queryDate, l5DayAfter);
		}
		
		if(lUpcomingOrders == null)
		{
			return new ArrayList<OrderAppointment>();
		}
		List<UpcomingAppointment> lReturnList = new ArrayList<UpcomingAppointment>();
		for(CurrentOrderDTO lCurrentOrderDTO : lUpcomingOrders)
		{
			UpcomingAppointment lUpcomingAppointment = new UpcomingAppointment();
			lUpcomingAppointment.setOrderId(lCurrentOrderDTO.getOrderID());
			lUpcomingAppointment.setPickupTimestamp(lCurrentOrderDTO.getPickupTimeStamp());
			lUpcomingAppointment.setDropoffTimestamp(lCurrentOrderDTO.getDropOffTimeStamp());
			
			UserDTO lUserDTO = userDAO.getUser(lCurrentOrderDTO.getUserID());
			lUpcomingAppointment.setName(lUserDTO.getFirstName() + " " + lUserDTO.getLastName());
			
			lUpcomingAppointment.setBikeId(lCurrentOrderDTO.getBikeID());
			
			BikeDTO lBikeDTO = bikeDAO.getBike(lCurrentOrderDTO.getBikeID());
			lUpcomingAppointment.setBikeName(lBikeDTO.getBikeTitle());
			
			lReturnList.add(lUpcomingAppointment);
		}
		
		return (List)lReturnList;
	}
}
