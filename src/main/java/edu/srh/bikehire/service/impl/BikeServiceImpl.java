package edu.srh.bikehire.service.impl;

import java.util.Calendar;
import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.BikeRentMappingDAO;
import edu.srh.bikehire.dao.BikeStatusDAO;
import edu.srh.bikehire.dao.BikeTypeDAO;
import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dao.WarehouseDAO;
import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.BikeStatusDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.dto.impl.BikeStatusDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.BikeService;

public class BikeServiceImpl implements BikeService {

	private BikeDAO bikeDAO;
	
	private BikeStatusDAO bikeStatusDAO;
	
	private BikeTypeDAO bikeTypeDAO;
	
	private WarehouseDAO warehouseDAO;
	
	private BikeRentMappingDAO bikeRentMappingDAO;
	
	public void initializeService()
	{
		bikeDAO = DAOFactory.getDefualtBikeDAOImpl();
		bikeTypeDAO = DAOFactory.getDefaultBikeTypeDAOImpl();
		bikeStatusDAO = DAOFactory.getDefaultBikeStatusDAOImpl();
		warehouseDAO = DAOFactory.getDefaultWarehouseDAOImpl();
		bikeRentMappingDAO = DAOFactory.getDefaultBikeRentMappingDAOImpl();
	}

	public List<BikeDTO> getAllBikes(boolean sortPriceDescending) {
		return bikeDAO.getAllBikes(sortPriceDescending);
	}

	public BikeDTO getBikeByID(int id)
	{
		
		return bikeDAO.getBike(id);
	}

	public void updateBikeStatus(int id, BikeStatusType bikeStatusType) throws BikeHireSystemException {
		BikeDTO bikeDTO = bikeDAO.getBike(id);
		if(bikeDTO == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		BikeStatusDTOImpl bikeStatusDTOImpl = new BikeStatusDTOImpl();
		bikeStatusDTOImpl.setBikeDTO(bikeDTO);
		if(BikeStatusType.UNDERMAINTAINCE_BIKE == bikeStatusType)
		{
			bikeStatusDTOImpl.setLastServiceDate(Calendar.getInstance());
		}
		bikeStatusDTOImpl.setStatus(bikeStatusType.getBikeStatus());
		
		bikeStatusDAO.updateBikeStatus(bikeStatusDTOImpl);
	}

	public List<BikeDTO> getAllBikesBasedOnType(int bikeTypeId, boolean sortPriceDescending) throws BikeHireSystemException
	{
		BikeTypeDTO bikeTypeDTO = bikeTypeDAO.getBikeType(bikeTypeId);
		if(bikeTypeDTO == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		return bikeDAO.getBikeForBikeType(bikeTypeId, sortPriceDescending);
		
	}
	
	public List<BikeDTO> getAllBikesBasedOnWarehouse(int warehouseId, boolean sortPriceDescending) throws BikeHireSystemException
	{
		WareHouseDTO warehouseDTO = warehouseDAO.getWarehouse(warehouseId);
		if(warehouseDTO == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		return bikeDAO.getBikeForWarehouseId(warehouseId, sortPriceDescending);
	}
	
	public BikeTypeDTO getBikeTypeInfo(int bikeTypeId) {
		return bikeTypeDAO.getBikeType(bikeTypeId);
	}
	
	public List<BikeTypeDTO> getBikeTypes()
	{
		return bikeTypeDAO.getBikeTypes();
	}
	
	public List<BikeDTO> getAllBikesBasedOnStatus(BikeStatusType bikeStatusType, boolean sortPriceDescending)
	{
		return bikeStatusDAO.getAllBikesBasedOnStatus(bikeStatusType.getBikeStatus(), sortPriceDescending);
	}
	
	public BikeRentMappingDTO getBikeRent(int bikeId){
		return bikeRentMappingDAO.getBikeRentMapping(bikeId);
	}
	
	public List<WareHouseDTO> getAllWarehouses(){
		return warehouseDAO.getAllWarehouses();
	}
	
}
