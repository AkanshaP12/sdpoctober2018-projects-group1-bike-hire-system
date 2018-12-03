package edu.srh.bikehire.service.impl;

import java.util.Calendar;

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
	private BikeTypeDAO bikeTypeDAO;
	
	private BikeStockDAO bikeStockDAO;
	
	private BikeRentMappingDAO bikeRentMappingDAO;
	
	private BikeDAO bikeDAO;
	
	private BikeStatusDAO bikeStatusDAO;
	
	private WarehouseDAO warehouseDAO;
	
	public void initializeService()
	{
		bikeTypeDAO = DAOFactory.getDefualtBikeTypeDAOImpl();
		bikeStockDAO = DAOFactory.getDefaultBikeStockDAOImpl();
		bikeRentMappingDAO = DAOFactory.getDefaultBikeRentMappingDAOImpl();
		bikeDAO = DAOFactory.getDefualtBikeDAOImpl();
		bikeStatusDAO = DAOFactory.getDefaultBikeStatusDAOImpl();
		warehouseDAO = DAOFactory.getDefaultWarehouseDAOImpl();
	}
	
	public String addNewBikeType(BikeType pNewBikeType, BikeStock pBikeStock, BikeRent pRentMapping) throws BikeHireSystemException {
		
		BikeTypeDTO lBikeTypeDTO = getBikeTypeDTOFromInputs(pNewBikeType);
		BikeStockDTO lBikeStockDTO = getBikeStockDTOFromInputs(pBikeStock, false);
		BikeRentMappingDTO lBikeRentMappingDTO = getBikeRentMappingDTOFromInputs(pRentMapping);
		
		BikeTypeValidator lBikeTypeValidator = new BikeTypeValidator(lBikeTypeDTO);
		lBikeTypeValidator.validateAddBikeType();
		
		String bikeTypeId = bikeTypeDAO.saveBikeType(lBikeTypeDTO);
		
		lBikeStockDTO.setBikeTypeDTO(lBikeTypeDTO);
		BikeStockValidator lBikeStockValidator = new BikeStockValidator(lBikeStockDTO);
		lBikeStockValidator.validateAddBikeStock();
		
		bikeStockDAO.addBikeStock(lBikeStockDTO);
		
		lBikeRentMappingDTO.setBikeType(lBikeTypeDTO);
		BikeRentMappingValidator lBikeRentMappingValidator = new BikeRentMappingValidator(lBikeRentMappingDTO);
		lBikeRentMappingValidator.validateAddBikeRentDetails();
		
		bikeRentMappingDAO.addBikeRentMapping(lBikeRentMappingDTO);
		
		return bikeTypeId;
	}

	public String addNewBikeDetails(Bike pNewBike, BikeStatus pBikeStatus) throws BikeHireSystemException {
		
		BikeDTO lBikeDTO = getBikeDTOFromInputs(pNewBike, false);
		BikeStatusDTO lBikeStatusDTO = getBikeStatusDTOFromInputs(pBikeStatus);
		
		BikeValidator lBikeValidator = new BikeValidator(lBikeDTO);
		lBikeValidator.validateAddBike();
		
		String lstrBikeId = bikeDAO.addBike(lBikeDTO);
		
		lBikeStatusDTO.setBikeDTO(lBikeDTO);
		BikeStatusValidator lBikeStatusValidator = new BikeStatusValidator(lBikeStatusDTO);
		lBikeStatusValidator.validateAddBikeStatus();
		
		bikeStatusDAO.addBikeStatus(lBikeStatusDTO);
		
		return lstrBikeId;
	}

	public String addNewWarehouse(Warehouse pNewWarehouse) throws BikeHireSystemException {
		WareHouseDTO lWareHouseDTO = getWarehouseDTOFromInputs(pNewWarehouse, false);
		
		WarehouseValidator lWarehouseValidator = new WarehouseValidator(lWareHouseDTO);
		lWarehouseValidator.validateAddWarehouse();
		
		String lstrWarehouseId = warehouseDAO.addWarehouse(lWareHouseDTO);
		
		return lstrWarehouseId;
	}

	public boolean deleteBikeDetails(Bike pDeleteBike) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean updateWarehouse(Warehouse pUpdatedWarehouse) throws BikeHireSystemException {
		WareHouseDTO lWareHouseDTO = getWarehouseDTOFromInputs(pUpdatedWarehouse, true);

		WarehouseValidator lWarehouseValidator = new WarehouseValidator(lWareHouseDTO);
		lWarehouseValidator.validateUpdateWareHouse();
		
		boolean lWarehouseUpdateStatus = warehouseDAO.updateWarehouse(lWareHouseDTO);
		
		return lWarehouseUpdateStatus;
	}

	public boolean updateBikeDetails(Bike pUpdatedBikeDetails) throws BikeHireSystemException {
		BikeDTO lBikeDTO = getBikeDTOFromInputs(pUpdatedBikeDetails, true);
		
		BikeValidator lBikeValidator = new BikeValidator(lBikeDTO);
		lBikeValidator.validateUpdateBike();
		
		boolean lBikeUpdateStatus = bikeDAO.updateBike(lBikeDTO);
		
		return lBikeUpdateStatus;
	}

	public boolean updateBikeRent(BikeRent pUpdatedBikeRent) throws BikeHireSystemException {
		BikeRentMappingDTO lBikeRentMappingDTO = getBikeRentMappingDTOFromInputs(pUpdatedBikeRent);

		BikeRentMappingValidator lRentMappingValidator = new BikeRentMappingValidator(lBikeRentMappingDTO);
		lRentMappingValidator.validateUpdateBikeRentDetails();
		
		boolean lBikeRentMappingUpdateStatus = bikeRentMappingDAO.updateBikeRentMapping(lBikeRentMappingDTO);
		
		return lBikeRentMappingUpdateStatus;
		
	}

	public boolean updateBikeStock(BikeStock pUpdatedBikeStock, BikeType pUpdatedBikeType) throws BikeHireSystemException {
		BikeStockDTO lBikeStockDTO = getBikeStockDTOFromInputs(pUpdatedBikeStock, true);
		BikeTypeDTO lBikeTypeDTO = getBikeTypeDTOFromInputs(pUpdatedBikeType);
		
		BikeStockValidator lBikeStockValidator = new BikeStockValidator(lBikeStockDTO);
		lBikeStockValidator.validateUpdateBikeStock();
		
		boolean lBikeStockUpdateStatus = bikeStockDAO.updateBikeStock(lBikeStockDTO, lBikeTypeDTO);
		
		return lBikeStockUpdateStatus;
	}

	public boolean updateBikeStatus(BikeStatus pUpdatedBikeStatus) throws BikeHireSystemException {
		BikeStatusDTO lBikeStatusDTO = getBikeStatusDTOFromInputs(pUpdatedBikeStatus);
		
		BikeStatusValidator lBikeStatusValidator = new BikeStatusValidator(lBikeStatusDTO);
		lBikeStatusValidator.validateUpdateBikeStatus();
		
		boolean lBikeUpdateStatus = bikeStatusDAO.updateBikeStatus(lBikeStatusDTO);
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
