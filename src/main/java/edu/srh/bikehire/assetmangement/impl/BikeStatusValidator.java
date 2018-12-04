package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dto.BikeStatusDTO;
import edu.srh.bikehire.dto.impl.BikeStatusDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeStatusValidator {
	private BikeStatusDTO mBikeStatus;

	public BikeStatusValidator(BikeStatusDTO pBikeStatus) {
		mBikeStatus = pBikeStatus;
		}
	
	public void validateAddBikeStatus() throws BikeHireSystemException
	{
		if(mBikeStatus == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(mBikeStatus.getBikeId() <= 0)
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
