package edu.srh.bikehire.service;

import edu.srh.bikehire.dtointerface.BikeDTO;
import edu.srh.bikehire.dtointerface.BikeRentMappingDTO;
import edu.srh.bikehire.dtointerface.BikeStatusDTO;
import edu.srh.bikehire.dtointerface.BikeStockDTO;
import edu.srh.bikehire.dtointerface.BikeTypeDTO;
import edu.srh.bikehire.dtointerface.WareHouseDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;

public interface AssetManagementService {
	public String addNewBikeType(BikeTypeDTO pNewBikeType, BikeStockDTO pBikeStock, BikeRentMappingDTO pRentMapping) throws BikeHireSystemException;
	
	public String addNewBikeDetails(BikeDTO pNewBike, BikeStatusDTO pBikeStatus) throws BikeHireSystemException;
	
	public String addNewWarehouse(WareHouseDTO pNewWarehouse) throws BikeHireSystemException;
	
	public String deleteBikeDetails(BikeDTO pDeleteBike) throws BikeHireSystemException;
	
	public String updateWarehouse(WareHouseDTO pUpdatedWarehouse) throws BikeHireSystemException;
	
	public String updateBikeDetails(BikeDTO pUpdatedBike) throws BikeHireSystemException;
	
	public String updateBikeRent(BikeRentMappingDTO pUpdatedBikeRent) throws BikeHireSystemException;
	
	public String updateBikeStock(BikeStockDTO pUpdatedBikeStock) throws BikeHireSystemException;
	
	public String updateBikeStatus(BikeStatusDTO pUpdatedBikeStatus) throws BikeHireSystemException;

	
}
