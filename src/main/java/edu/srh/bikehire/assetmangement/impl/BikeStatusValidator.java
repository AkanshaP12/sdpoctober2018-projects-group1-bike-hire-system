package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.assetmangement.BikeStatus;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeStatusValidator {
	private BikeStatus mBikeStatus;

	public BikeStatusValidator(BikeStatus pBikeStatus) {
		mBikeStatus = pBikeStatus;
		}
	
	public void validateAddBikeStatus() throws BikeHireSystemException
	{
		if(mBikeStatus == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBikeStatus.getBikeID()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
		
		validateBikeRentStatus();
		
		if(Util.isEmptyOrNullString(mBikeStatus.getBikeManufacturer()))
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
		if(Util.isEmptyOrNullString(mBikeStatus.getBikeRentStatus()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	

}
