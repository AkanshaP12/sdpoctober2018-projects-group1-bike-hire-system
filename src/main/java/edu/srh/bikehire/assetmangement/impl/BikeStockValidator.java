package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dto.BikeStockDTOImpl;
import edu.srh.bikehire.dtointerface.BikeStockDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeStockValidator {
	private BikeStockDTO mBikeStock;

	public BikeStockValidator(BikeStockDTO pBikeStock) {
		mBikeStock = pBikeStock;
	}
	
	public void validateAddBikeStock() throws BikeHireSystemException
	{
		if(mBikeStock == null)
		{
			//TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mBikeStock.getBikeTypeId()))
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
		if(mBikeStock.getTotalQuantity()<=0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	

}
	


