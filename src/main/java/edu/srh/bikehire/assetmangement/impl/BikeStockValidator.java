package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.assetmangement.BikeStock;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeStockValidator {
	private BikeStock mBikeStock;

	public BikeStockValidator(BikeStock pBikeStock) {
		mBikeStock = pBikeStock;
	}
	
	public void validateAddBikeStock() throws BikeHireSystemException
	{
		if(mBikeStock == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBikeStock.getBikeTypeID()))
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		
		}
		
		validateBikeQuantity();
		
		}
	
	public void validateUpdateBikeStock() throws BikeHireSystemException
	{
		if(mBikeStock == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		validateBikeQuantity();
	}
	
	public void validateBikeQuantity() throws BikeHireSystemException
	{
		if(Util.isEmptyOrNullString(mBikeStock.getBikeQuantity()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	

}
	


