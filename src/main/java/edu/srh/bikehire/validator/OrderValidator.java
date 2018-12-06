package edu.srh.bikehire.validator;

import edu.srh.bikehire.dto.CurrentOrderDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Order;
import edu.srh.bikehire.util.Util;

public class OrderValidator {
	private Order currentOrderDTO;
	
	public OrderValidator(Order currentOrderDTO)
	{
		this.currentOrderDTO = currentOrderDTO;
	}
	
	public void validateForNewOrder() throws BikeHireSystemException
	{
		if(currentOrderDTO == null)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(currentOrderDTO.getBikeId() <= 0)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(currentOrderDTO.getUserId() <= 0)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(currentOrderDTO.getOrderMode()))
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(currentOrderDTO.getActualdropoffTimestamp() == null)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(currentOrderDTO.getBookingTimestamp() == null)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(currentOrderDTO.getDropoffTimestamp() == null)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(currentOrderDTO.getPickupTimestamp() == null)
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	}
}
