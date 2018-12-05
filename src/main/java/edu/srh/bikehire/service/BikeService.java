package edu.srh.bikehire.service;

import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;

public interface BikeService{

	public List<BikeDTO> getAllBikes(boolean sortPriceDescending);

	public BikeDTO getBikeByID(int id);

	public void updateBikeStatus(int id, BikeStatusType bikeStatusType) throws BikeHireSystemException;
	
	public List<BikeDTO> getAllBikesBasedOnType(int bikeTypeId, boolean sortPriceDescending) throws BikeHireSystemException;
	
	public List<BikeDTO> getAllBikesBasedOnWarehouse(int warehouseId, boolean sortPriceDescending) throws BikeHireSystemException;
	
	public BikeTypeDTO getBikeTypeInfo(int bikeTypeId);
	
	public List<BikeTypeDTO> getBikeTypes();
	
	public List<BikeDTO> getAllBikesBasedOnStatus(BikeStatusType bikeStatusType, boolean sortPriceDescending);
	
	public BikeRentMappingDTO getBikeRent(int bikeId);
	
	public List<WareHouseDTO> getAllWarehouses();
}
