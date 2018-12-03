package edu.srh.bikehire.service;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Bike;
import edu.srh.bikehire.service.core.BikeRent;
import edu.srh.bikehire.service.core.BikeStatus;
import edu.srh.bikehire.service.core.BikeStock;
import edu.srh.bikehire.service.core.BikeType;
import edu.srh.bikehire.service.core.Warehouse;

public interface AssetManagementService {
	public String addNewBikeType(BikeType pNewBikeType, BikeStock pBikeStock, BikeRent pRentMapping) throws BikeHireSystemException;
	
	public String addNewBikeDetails(Bike pNewBike, BikeStatus pBikeStatus) throws BikeHireSystemException;
	
	public String addNewWarehouse(Warehouse pNewWarehouse) throws BikeHireSystemException;
	
	public boolean deleteBikeDetails(Bike pDeleteBike) throws BikeHireSystemException;
	
	public boolean updateWarehouse(Warehouse pUpdatedWarehouse) throws BikeHireSystemException;
	
	public boolean updateBikeDetails(Bike pUpdatedBike) throws BikeHireSystemException;
	
	public boolean updateBikeRent(BikeRent pUpdatedBikeRent) throws BikeHireSystemException;
	
	public boolean updateBikeStock(BikeStock pUpdatedBikeStock, BikeType pUpdatedBikeType) throws BikeHireSystemException;
	
	public boolean updateBikeStatus(BikeStatus pUpdatedBikeStatus) throws BikeHireSystemException;

	
}
