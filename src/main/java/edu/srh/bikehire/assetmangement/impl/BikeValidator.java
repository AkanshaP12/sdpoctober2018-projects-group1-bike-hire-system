package edu.srh.bikehire.assetmangement.impl;

import java.util.Calendar;

import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.impl.BikeDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeValidator {
	private BikeDTO mBike;

	public BikeValidator(BikeDTO pBike) {
		mBike = pBike;
		
	}
	
	public void validateAddBike() throws BikeHireSystemException
	{
		if(mBike == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBike.getBikeTypeId()))
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
		
		if(Util.isEmptyOrNullString(mBike.getManufacturer()))
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
		if(Util.isEmptyOrNullString(mBike.getWareHouseID()))
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
		if(Util.isEmptyOrNullString(mBike.getBikeId()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	public void validateDepositAmount() throws BikeHireSystemException
	{
		if(mBike.getDepositAmount() <= 0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
}
