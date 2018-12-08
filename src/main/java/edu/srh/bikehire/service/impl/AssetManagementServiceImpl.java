package edu.srh.bikehire.service.impl;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.srh.bikehire.assetmangement.impl.BikeRentMappingValidator;
import edu.srh.bikehire.assetmangement.impl.BikeStatusValidator;
import edu.srh.bikehire.assetmangement.impl.BikeStockValidator;
import edu.srh.bikehire.assetmangement.impl.BikeTypeValidator;
import edu.srh.bikehire.assetmangement.impl.BikeValidator;
import edu.srh.bikehire.assetmangement.impl.WarehouseValidator;
import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.BikeRentMappingDAO;
import edu.srh.bikehire.dao.BikeStatusDAO;
import edu.srh.bikehire.dao.BikeStockDAO;
import edu.srh.bikehire.dao.BikeTypeDAO;
import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dao.WarehouseDAO;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.BikeStatusDTO;
import edu.srh.bikehire.dto.BikeStockDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.dto.impl.BikeDTOImpl;
import edu.srh.bikehire.dto.impl.BikeRentMappingDTOImpl;
import edu.srh.bikehire.dto.impl.BikeStatusDTOImpl;
import edu.srh.bikehire.dto.impl.BikeStockDTOImpl;
import edu.srh.bikehire.dto.impl.BikeTypeDTOImpl;
import edu.srh.bikehire.dto.impl.WareHouseDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.AssetManagementService;
import edu.srh.bikehire.service.core.Bike;
import edu.srh.bikehire.service.core.BikeRent;
import edu.srh.bikehire.service.core.BikeStatus;
import edu.srh.bikehire.service.core.BikeStock;
import edu.srh.bikehire.service.core.BikeType;
import edu.srh.bikehire.service.core.Warehouse;

public class AssetManagementServiceImpl implements AssetManagementService {
	private static final Logger LOG = LogManager.getLogger(AssetManagementServiceImpl.class);
	
	private BikeTypeDAO bikeTypeDAO;
	
	private BikeStockDAO bikeStockDAO;
	
	private BikeRentMappingDAO bikeRentMappingDAO;
	
	private BikeDAO bikeDAO;
	
	private BikeStatusDAO bikeStatusDAO;
	
	private WarehouseDAO warehouseDAO;
	
	public AssetManagementServiceImpl()
	{
		bikeTypeDAO = DAOFactory.getDefaultBikeTypeDAOImpl();
		bikeStockDAO = DAOFactory.getDefaultBikeStockDAOImpl();
		bikeRentMappingDAO = DAOFactory.getDefaultBikeRentMappingDAOImpl();
		bikeDAO = DAOFactory.getDefualtBikeDAOImpl();
		bikeStatusDAO = DAOFactory.getDefaultBikeStatusDAOImpl();
		warehouseDAO = DAOFactory.getDefaultWarehouseDAOImpl();
	}
	
	public int addNewBikeType(BikeType pNewBikeType, BikeStock pBikeStock, BikeRent pRentMapping) throws BikeHireSystemException {
		LOG.info("addNewBikeType : Start");
		BikeTypeDTO lBikeTypeDTO = getBikeTypeDTOFromInputs(pNewBikeType);
		BikeStockDTO lBikeStockDTO = getBikeStockDTOFromInputs(pBikeStock, false);
		BikeRentMappingDTO lBikeRentMappingDTO = getBikeRentMappingDTOFromInputs(pRentMapping);
		
		BikeTypeValidator lBikeTypeValidator = new BikeTypeValidator(lBikeTypeDTO);
		lBikeTypeValidator.validateAddBikeType();
		
		int bikeTypeId = bikeTypeDAO.saveBikeType(lBikeTypeDTO);
		LOG.info("addNewBikeType : new bike type added successfully.");
		lBikeStockDTO.setBikeTypeDTO(lBikeTypeDTO);
		BikeStockValidator lBikeStockValidator = new BikeStockValidator(lBikeStockDTO);
		lBikeStockValidator.validateAddBikeStock();
		
		bikeStockDAO.addBikeStock(lBikeStockDTO);
		LOG.info("addNewBikeType : bike stock added successfully.");
		lBikeRentMappingDTO.setBikeType(lBikeTypeDTO);
		BikeRentMappingValidator lBikeRentMappingValidator = new BikeRentMappingValidator(lBikeRentMappingDTO);
		lBikeRentMappingValidator.validateAddBikeRentDetails();
		
		bikeRentMappingDAO.addBikeRentMapping(lBikeRentMappingDTO);
		LOG.info("addNewBikeType : bike rent mapping added successfully.");
		LOG.info("addNewBikeType : End");
		return bikeTypeId;
	}

	public int addNewBikeDetails(Bike pNewBike, BikeStatus pBikeStatus) throws BikeHireSystemException {
		LOG.info("addNewBikeDetails : Start");
		BikeDTO lBikeDTO = getBikeDTOFromInputs(pNewBike, false);
		BikeStatusDTO lBikeStatusDTO = getBikeStatusDTOFromInputs(pBikeStatus);
		
		BikeValidator lBikeValidator = new BikeValidator(lBikeDTO);
		lBikeValidator.validateAddBike();
		
		int bikeId = bikeDAO.addBike(lBikeDTO);
		LOG.info("addNewBikeDetails : new bike added successfully.");
		
		lBikeStatusDTO.setBikeDTO(lBikeDTO);
		BikeStatusValidator lBikeStatusValidator = new BikeStatusValidator(lBikeStatusDTO);
		lBikeStatusValidator.validateAddBikeStatus();
		
		bikeStatusDAO.addBikeStatus(lBikeStatusDTO);
		LOG.info("addNewBikeDetails : bike status added successfully.");
		LOG.info("addNewBikeDetails : End");
		return bikeId;
	}

	public int addNewWarehouse(Warehouse pNewWarehouse) throws BikeHireSystemException {
		LOG.info("addNewWarehouse : Start");
		WareHouseDTO lWareHouseDTO = getWarehouseDTOFromInputs(pNewWarehouse, false);
		
		WarehouseValidator lWarehouseValidator = new WarehouseValidator(lWareHouseDTO);
		lWarehouseValidator.validateAddWarehouse();
		LOG.info("addNewWarehouse : warehouse details validated");
		
		int warehouseId = warehouseDAO.addWarehouse(lWareHouseDTO);
		LOG.info("addNewWarehouse : new warehouse added successfully.");
		LOG.info("addNewWarehouse : End");
		return warehouseId;
	}

	public boolean updateWarehouse(Warehouse pUpdatedWarehouse) throws BikeHireSystemException {
		LOG.info("updateWarehouse : Start");
		WareHouseDTO lWareHouseDTO = getWarehouseDTOFromInputs(pUpdatedWarehouse, true);

		WarehouseValidator lWarehouseValidator = new WarehouseValidator(lWareHouseDTO);
		lWarehouseValidator.validateUpdateWareHouse();
		LOG.info("updateWarehouse : warehouse updated successfully.");
		
		boolean lWarehouseUpdateStatus = warehouseDAO.updateWarehouse(lWareHouseDTO);
		LOG.info("updateWarehouse : End");
		return lWarehouseUpdateStatus;
	}

	public boolean updateBikeDetails(Bike pUpdatedBikeDetails) throws BikeHireSystemException {
		LOG.info("updateBikeDetails : Start");
		BikeDTO lBikeDTO = getBikeDTOFromInputs(pUpdatedBikeDetails, true);
		
		BikeValidator lBikeValidator = new BikeValidator(lBikeDTO);
		lBikeValidator.validateUpdateBike();
		
		boolean lBikeUpdateStatus = bikeDAO.updateBike(lBikeDTO);
		LOG.info("updateBikeDetails : Bike details updated successfully.");
		
		LOG.info("updateBikeDetails : End");
		return lBikeUpdateStatus;
	}

	public boolean updateBikeRent(BikeRent pUpdatedBikeRent) throws BikeHireSystemException {
		LOG.info("updateBikeRent : Start");
		BikeRentMappingDTO lBikeRentMappingDTO = getBikeRentMappingDTOFromInputs(pUpdatedBikeRent);

		BikeRentMappingValidator lRentMappingValidator = new BikeRentMappingValidator(lBikeRentMappingDTO);
		lRentMappingValidator.validateUpdateBikeRentDetails();
		
		boolean lBikeRentMappingUpdateStatus = bikeRentMappingDAO.updateBikeRentMapping(lBikeRentMappingDTO);
		LOG.info("updateBikeRent : bike rent updated successfully.");
		LOG.info("updateBikeRent : End");
		return lBikeRentMappingUpdateStatus;
		
	}

	public boolean updateBikeStock(BikeStock pUpdatedBikeStock, BikeType pUpdatedBikeType) throws BikeHireSystemException {
		LOG.info("updateBikeStock : Start");
		BikeStockDTO lBikeStockDTO = getBikeStockDTOFromInputs(pUpdatedBikeStock, true);
		BikeTypeDTO lBikeTypeDTO = getBikeTypeDTOFromInputs(pUpdatedBikeType);
		
		BikeStockValidator lBikeStockValidator = new BikeStockValidator(lBikeStockDTO);
		lBikeStockValidator.validateUpdateBikeStock();
		
		boolean lBikeStockUpdateStatus = bikeStockDAO.updateBikeStock(lBikeStockDTO, lBikeTypeDTO);
		LOG.info("updateBikeStock : bike stock updated successfully.");
		
		LOG.info("updateBikeStock : End");
		return lBikeStockUpdateStatus;
	}

	public boolean updateBikeStatus(BikeStatus pUpdatedBikeStatus) throws BikeHireSystemException {
		LOG.info("updateBikeStatus : Start");
		BikeStatusDTO lBikeStatusDTO = getBikeStatusDTOFromInputs(pUpdatedBikeStatus);
		
		BikeStatusValidator lBikeStatusValidator = new BikeStatusValidator(lBikeStatusDTO);
		lBikeStatusValidator.validateUpdateBikeStatus();
		
		boolean lBikeUpdateStatus = bikeStatusDAO.updateBikeStatus(lBikeStatusDTO);
		LOG.info("updateBikeStatus : bike status changed successfully.");
		
		LOG.info("updateBikeStatus : End");
		return lBikeUpdateStatus;
	}

	private BikeTypeDTO getBikeTypeDTOFromInputs(BikeType pBikeType)
	{
		BikeTypeDTOImpl lBikeTypeDTOImpl = new BikeTypeDTOImpl();
		lBikeTypeDTOImpl.setAgeCategory(pBikeType.getAgeCategory());
		lBikeTypeDTOImpl.setBikeType(pBikeType.getBikeType());
		lBikeTypeDTOImpl.setBikeTypeId(pBikeType.getBikeTypeId());
		lBikeTypeDTOImpl.setCreationTimeStamp(Calendar.getInstance());
		return lBikeTypeDTOImpl;
		
	}
	
	private BikeStockDTO getBikeStockDTOFromInputs(BikeStock pBikeStock, boolean isUpdate)
	{
		BikeStockDTOImpl lBikeStockDTOImpl = new BikeStockDTOImpl();
		lBikeStockDTOImpl.setTotalQuantity(pBikeStock.getTotalQuantity());
		
		BikeTypeDTOImpl lBikeTypeDTOImpl = new BikeTypeDTOImpl();
		lBikeTypeDTOImpl.setBikeTypeId(pBikeStock.getBikeTypeId());
		
		lBikeStockDTOImpl.setBikeTypeDTO(lBikeTypeDTOImpl);
		lBikeStockDTOImpl.setLastModifiedTimeStamp(Calendar.getInstance());
		if(!isUpdate)
		{			
			lBikeStockDTOImpl.setCreationTimeStamp(Calendar.getInstance());
		}
		return lBikeStockDTOImpl;
	}
	
	private BikeRentMappingDTO getBikeRentMappingDTOFromInputs(BikeRent pBikeRent)
	{
		BikeRentMappingDTOImpl lBikeRentDTOImpl = new BikeRentMappingDTOImpl();
		lBikeRentDTOImpl.setLastModifiedTimeStamp(Calendar.getInstance());
		lBikeRentDTOImpl.setRentPerDay(pBikeRent.getRentPerDay());
		lBikeRentDTOImpl.setRentPerHour(pBikeRent.getRentPerHour());
		
		BikeTypeDTOImpl lBikeTypeDTOImpl = new BikeTypeDTOImpl();
		lBikeTypeDTOImpl.setBikeTypeId(pBikeRent.getBikeTypeId());
		
		lBikeRentDTOImpl.setBikeType(lBikeTypeDTOImpl);
		return lBikeRentDTOImpl;
	}
	
	private BikeDTO getBikeDTOFromInputs(Bike pBike, boolean isUpdate)
	{
		BikeDTOImpl lBikeDTOImpl = new BikeDTOImpl();
		lBikeDTOImpl.setBikeId(pBike.getBikeId());
		lBikeDTOImpl.setBikeTitle(pBike.getBikeTitle());
		if(!isUpdate)
		{			
			lBikeDTOImpl.setCreationTimeStamp(Calendar.getInstance());
		}
		lBikeDTOImpl.setDepositAmount(pBike.getDepositAmount());
		lBikeDTOImpl.setManufacturer(pBike.getManufacturer());
		lBikeDTOImpl.setYearOfManufacture(pBike.getYearOfManufacture());
		
		BikeTypeDTOImpl lBikeTypeDTOImpl = new BikeTypeDTOImpl();
		lBikeTypeDTOImpl.setBikeTypeId(pBike.getBikeTypeId());
		
		WareHouseDTOImpl lWareHouseDTOImpl = new WareHouseDTOImpl();
		lWareHouseDTOImpl.setWarehouseId(pBike.getWareHouseID());
		
		lBikeDTOImpl.setBikeType(lBikeTypeDTOImpl);
		lBikeDTOImpl.setWarehouse(lWareHouseDTOImpl);
		
		return lBikeDTOImpl;
	}
	
	private BikeStatusDTO getBikeStatusDTOFromInputs(BikeStatus pBikeStatus)
	{
		BikeStatusDTOImpl lBikeStatusDTOImpl = new BikeStatusDTOImpl();
		lBikeStatusDTOImpl.setLastModifiedDate(Calendar.getInstance());
		lBikeStatusDTOImpl.setLastServiceDate(pBikeStatus.getLastServiceDate());
		lBikeStatusDTOImpl.setManufacturer(pBikeStatus.getManufacturer());
		lBikeStatusDTOImpl.setStatus(pBikeStatus.getStatus());
		
		BikeDTOImpl lBikeDTOImpl = new BikeDTOImpl();
		lBikeDTOImpl.setBikeId(pBikeStatus.getBikeId());
		
		lBikeStatusDTOImpl.setBikeDTO(lBikeDTOImpl);
		
		return lBikeStatusDTOImpl;
	}
	
	private WareHouseDTO getWarehouseDTOFromInputs(Warehouse pWarehouse, boolean isUpdate)
	{
		WareHouseDTOImpl lWarehouseDTOImpl = new WareHouseDTOImpl();
		if(!isUpdate)
		{			
			lWarehouseDTOImpl.setCreationTimeStamp(Calendar.getInstance());
		}
		lWarehouseDTOImpl.setLastmodifiedTimeStamp(Calendar.getInstance());
		lWarehouseDTOImpl.setLocation(pWarehouse.getLocation());
		lWarehouseDTOImpl.setName(pWarehouse.getName());
		lWarehouseDTOImpl.setStorageCapacity(pWarehouse.getStorageCapacity());
		lWarehouseDTOImpl.setWarehouseId(pWarehouse.getWarehouseId());
		
		return lWarehouseDTOImpl;
	}
	
}
