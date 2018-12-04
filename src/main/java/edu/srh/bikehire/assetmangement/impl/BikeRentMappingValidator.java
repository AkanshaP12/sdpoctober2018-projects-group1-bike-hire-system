package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.impl.BikeRentMappingDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeRentMappingValidator {
	private BikeRentMappingDTO mBikeRentDetails;

	public BikeRentMappingValidator(BikeRentMappingDTO pBikeRentDetails) {
		mBikeRentDetails = pBikeRentDetails;
	}
	
	public void validateAddBikeRentDetails() throws BikeHireSystemException
	{
		if(mBikeRentDetails == null)
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		}
		
		
		if(mBikeRentDetails.getBikeTypeId() <= 0)
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		}
		
		validateRentPerHour();
		validateRentPerDay();
		
		
        }
	public void validateUpdateBikeRentDetails() throws BikeHireSystemException
	{
		if(mBikeRentDetails == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	
		validateRentPerHour();
		validateRentPerDay();
		
	}
	
	
	
	public void validateRentPerHour() throws BikeHireSystemException
	{
		if(mBikeRentDetails.getRentPerHour()<=0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	public void validateRentPerDay() throws BikeHireSystemException
	{
		if(mBikeRentDetails.getRentPerDay()<=0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	
	
	
}
	


