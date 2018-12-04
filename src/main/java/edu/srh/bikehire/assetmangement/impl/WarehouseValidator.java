package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.dto.impl.WareHouseDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class WarehouseValidator {
	private WareHouseDTO mWarehouse;

	public WarehouseValidator(WareHouseDTO pWarehouse) {
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
		
		if(mWarehouse.getWarehouseId() <= 0)
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