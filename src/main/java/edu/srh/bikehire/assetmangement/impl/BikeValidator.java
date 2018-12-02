package edu.srh.bikehire.assetmangement.impl;

import java.util.Calendar;

import edu.srh.bikehire.assetmangement.Bike;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeValidator {
	private Bike mBike;

	public BikeValidator(Bike pBike) {
		mBike = pBike;
		
	}
	
	public void validateAddBike() throws BikeHireSystemException
	{
		if(mBike == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBike.getBikeTypeID()))
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		
		}
		
		validateBikeID();
		
		
		//TODO: Resolve
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if(mBike.getYearOfManufacture() <1960 && mBike.getYearOfManufacture() >year)
		{		
		throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBike.getBikeManufacturer()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBike.getBikeTitle()))
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		
		}
		//TODO:OTHER WAREHOUSE EXCEPTIONS
		validateDepositAmount();
		
		//TODO: Resolve
		if(Util.isEmptyOrNullString(mBike.getWareHouseId()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	
        }
	public void validateDeleteBike() throws BikeHireSystemException
	{
		if(mBike == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	
		validateBikeID();
		
	}
	
	public void validateUpdateBike() throws BikeHireSystemException
	{
		if(mBike == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	
		validateDepositAmount();
		
	}
	
	public void validateBikeID() throws BikeHireSystemException
	{
		if(Util.isEmptyOrNullString(mBike.getBikeID()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	public void validateDepositAmount() throws BikeHireSystemException
	{
		if(mBike.getBikeDepositAmount() <= 0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
}
