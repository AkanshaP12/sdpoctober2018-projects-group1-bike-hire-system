package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dto.BikeStatusDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeStatusValidator {
	private BikeStatusDTOImpl mBikeStatus;

	public BikeStatusValidator(BikeStatusDTOImpl pBikeStatus) {
		mBikeStatus = pBikeStatus;
		}
	
	public void validateAddBikeStatus() throws BikeHireSystemException
	{
		if(mBikeStatus == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBikeStatus.getBikeId()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
		
		validateBikeRentStatus();
		
		if(Util.isEmptyOrNullString(mBikeStatus.getManufacturer()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
		//TODO:OTHER BIKESTATUS EXCEPTIONS
		
	
        }
	
	public void validateUpdateBikeStatus() throws BikeHireSystemException
	{
		if(mBikeStatus == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		validateBikeRentStatus();
	}
	
	public void validateBikeRentStatus() throws BikeHireSystemException
	{
		if(Util.isEmptyOrNullString(mBikeStatus.getStatus()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	

}
