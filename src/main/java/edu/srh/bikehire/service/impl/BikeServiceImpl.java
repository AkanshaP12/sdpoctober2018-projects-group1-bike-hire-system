package edu.srh.bikehire.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	private static final Logger LOG = LogManager.getLogger(BikeServiceImpl.class);
	
	private BikeDAO bikeDAO;
	
	private BikeStatusDAO bikeStatusDAO;
	
	private BikeTypeDAO bikeTypeDAO;
	
	private WarehouseDAO warehouseDAO;
	
	private BikeRentMappingDAO bikeRentMappingDAO;
	
	public BikeServiceImpl()
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

	public BikeDTO getBikeByID(int id) {
		
		return bikeDAO.getBike(id);
	}

	public void updateBikeStatus(int id, BikeStatusType bikeStatusType) throws BikeHireSystemException {
		LOG.info("updateBikeStatus : Start");
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
		LOG.info("updateBikeStatus : bike status updated successfully.");
		LOG.info("updateBikeStatus : End");
	}

	public List<BikeDTO> getAllBikesBasedOnType(int bikeTypeId, boolean sortPriceDescending) throws BikeHireSystemException
	{
		LOG.info("getAllBikesBasedOnType : Start");
		BikeTypeDTO bikeTypeDTO = bikeTypeDAO.getBikeType(bikeTypeId);
		if(bikeTypeDTO == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		List<BikeDTO> allBikes = bikeDAO.getBikeForBikeType(bikeTypeId, sortPriceDescending);
		LOG.info("getAllBikesBasedOnType : End");
		return allBikes;
	}
	
	public List<BikeDTO> getAllBikesBasedOnWarehouse(int warehouseId, boolean sortPriceDescending) throws BikeHireSystemException
	{
		LOG.info("getAllBikesBasedOnWarehouse : Start");
		WareHouseDTO warehouseDTO = warehouseDAO.getWarehouse(warehouseId);
		if(warehouseDTO == null)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		List<BikeDTO> allBikes = bikeDAO.getBikeForWarehouseId(warehouseId, sortPriceDescending);
		LOG.info("getAllBikesBasedOnWarehouse : End");
		return allBikes;
	}
	
	public BikeTypeDTO getBikeTypeInfo(int bikeTypeId) {
		LOG.info("getBikeTypeInfo : Start");
		BikeTypeDTO bikeTypeDTO = bikeTypeDAO.getBikeType(bikeTypeId);
		LOG.info("getBikeTypeInfo : End");
		return bikeTypeDTO;
	}
	
	public List<BikeTypeDTO> getBikeTypes()
	{
		LOG.info("getBikeTypes : Start");
		List<BikeTypeDTO> allBikeTypes = bikeTypeDAO.getBikeTypes();
		LOG.info("getBikeTypes : End");
		return allBikeTypes;
	}
	
	public List<BikeDTO> getAllBikesBasedOnStatus(BikeStatusType bikeStatusType, boolean sortPriceDescending)
	{
		LOG.info("getAllBikesBasedOnStatus : Start");
		List<BikeDTO> allBikes = bikeStatusDAO.getAllBikesBasedOnStatus(bikeStatusType.getBikeStatus(), sortPriceDescending); 
		LOG.info("getAllBikesBasedOnStatus : End");
		return allBikes;
	}
	
	public BikeRentMappingDTO getBikeRent(int bikeId){
		LOG.info("getBikeRent : Start");
		BikeRentMappingDTO bikeRentMappingDTO = bikeRentMappingDAO.getBikeRentMapping(bikeId);
		LOG.info("getBikeRent : End");
		return bikeRentMappingDTO;
	}
	
	public List<WareHouseDTO> getAllWarehouses(){
		LOG.info("getAllWarehouses : Start");
		List<WareHouseDTO> warehouses = warehouseDAO.getAllWarehouses();
		LOG.info("getAllWarehouses : End");
		return warehouses;
	}
	
}
