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

	public List<BikeDTO> getAllBikes(boolean sortPriceDescending) throws BikeHireSystemException;

	public BikeDTO getBikeByID(int id) throws BikeHireSystemException;

	public void updateBikeStatus(int id, BikeStatusType bikeStatusType) throws BikeHireSystemException;
	
	public List<BikeDTO> getAllBikesBasedOnType(int bikeTypeId, boolean sortPriceDescending) throws BikeHireSystemException;
	
	public List<BikeDTO> getAllBikesBasedOnWarehouse(int warehouseId, boolean sortPriceDescending) throws BikeHireSystemException;
	
	public BikeTypeDTO getBikeTypeInfo(int bikeTypeId) throws BikeHireSystemException;
	
	public List<BikeTypeDTO> getBikeTypes() throws BikeHireSystemException;
	
	public List<BikeDTO> getAllBikesBasedOnStatus(BikeStatusType bikeStatusType, boolean sortPriceDescending) throws BikeHireSystemException;
	
	public BikeRentMappingDTO getBikeRent(int bikeId) throws BikeHireSystemException;
	
	public List<WareHouseDTO> getAllWarehouses() throws BikeHireSystemException;
}
