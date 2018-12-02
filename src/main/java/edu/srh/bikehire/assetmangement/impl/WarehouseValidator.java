package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dto.WareHouseDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class WarehouseValidator {
	private WareHouseDTOImpl mWarehouse;

	public WarehouseValidator(WareHouseDTOImpl pWarehouse) {
		mWarehouse = pWarehouse;
	}
	
	public void validateAddWarehouse() throws BikeHireSystemException
	{
		if(mWarehouse == null)
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		}
		
		validateWareHouse();
		
		if(Util.isEmptyOrNullString(mWarehouse.getWarehouseId()))
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mWarehouse.getName()))
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mWarehouse.getLocation()))
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		
		}
		//TODO:OTHER WAREHOUSE EXCEPTIONS
		
	
        }
	public void validateUpdateWareHouse() throws BikeHireSystemException
	{
		if(mWarehouse == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	
		validateWareHouse();
		
	}
	
	
	
	public void validateWareHouse() throws BikeHireSystemException
	{
		if(mWarehouse.getStorageCapacity()<=0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
	
	
}