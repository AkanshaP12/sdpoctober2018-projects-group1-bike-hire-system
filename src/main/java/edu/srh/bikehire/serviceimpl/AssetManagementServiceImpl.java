package edu.srh.bikehire.serviceimpl;

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
import edu.srh.bikehire.dao.WarehouseDAO;
import edu.srh.bikehire.daoimpl.util.DAOFactory;
import edu.srh.bikehire.dtointerface.BikeDTO;
import edu.srh.bikehire.dtointerface.BikeRentMappingDTO;
import edu.srh.bikehire.dtointerface.BikeStatusDTO;
import edu.srh.bikehire.dtointerface.BikeStockDTO;
import edu.srh.bikehire.dtointerface.BikeTypeDTO;
import edu.srh.bikehire.dtointerface.WareHouseDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.AssetManagementService;

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
	
	public String addNewBikeType(BikeTypeDTO pNewBikeType, BikeStockDTO pBikeStock, BikeRentMappingDTO pRentMapping) throws BikeHireSystemException {
		BikeTypeValidator lBikeTypeValidator = new BikeTypeValidator(pNewBikeType);
		lBikeTypeValidator.validateAddBikeType();
		
		String bikeTypeId = bikeTypeDAO.saveBikeType(pNewBikeType);
		
		pBikeStock.setBikeTypeDTO(pNewBikeType);
		
		BikeStockValidator lBikeStockValidator = new BikeStockValidator(pBikeStock);
		lBikeStockValidator.validateAddBikeStock();
		
		bikeStockDAO.addBikeStock(pBikeStock);
		
		pRentMapping.setBikeType(pNewBikeType);
		BikeRentMappingValidator lBikeRentMappingValidator = new BikeRentMappingValidator(pRentMapping);
		lBikeRentMappingValidator.validateAddBikeRentDetails();
		
		bikeRentMappingDAO.addBikeRentMapping(pRentMapping);
		
		return bikeTypeId;
	}

	public String addNewBikeDetails(BikeDTO pNewBike, BikeStatusDTO pBikeStatus) throws BikeHireSystemException {
		BikeValidator lBikeValidator = new BikeValidator(pNewBike);
		lBikeValidator.validateAddBike();
		
		String lstrBikeId = bikeDAO.addBike(pNewBike);
		
		pBikeStatus.setBikeDTO(pNewBike);
		BikeStatusValidator lBikeStatusValidator = new BikeStatusValidator(pBikeStatus);
		lBikeStatusValidator.validateAddBikeStatus();
		
		bikeStatusDAO.addBikeStatus(pBikeStatus);
		
		return lstrBikeId;
	}

	public String addNewWarehouse(WareHouseDTO pNewWarehouse) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		
		WarehouseValidator lWarehouseValidator = new WarehouseValidator(pNewWarehouse);
		lWarehouseValidator.validateAddWarehouse();
		
		String lstrWarehouseId = warehouseDAO.addWarehouse(pNewWarehouse);
		
		return lstrWarehouseId;
		
		
	}

	public boolean deleteBikeDetails(BikeDTO pDeleteBike) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean updateWarehouse(WareHouseDTO pUpdatedWarehouse) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		WarehouseValidator lWarehouseValidator = new WarehouseValidator(pUpdatedWarehouse);
		lWarehouseValidator.validateUpdateWareHouse();
		
		boolean lWarehouseUpdateStatus = warehouseDAO.updateWarehouse(pUpdatedWarehouse);
		
		return lWarehouseUpdateStatus;
	}

	public boolean updateBikeDetails(BikeDTO pUpdatedBikeDetails) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		BikeValidator lBikeValidator = new BikeValidator(pUpdatedBikeDetails);
		lBikeValidator.validateUpdateBike();
		
		boolean lBikeUpdateStatus = bikeDAO.updateBike(pUpdatedBikeDetails);
		
		return lBikeUpdateStatus;
	
	}

	public boolean updateBikeRent(BikeRentMappingDTO pUpdatedBikeRent) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		BikeRentMappingValidator lRentMappingValidator = new BikeRentMappingValidator(pUpdatedBikeRent);
		lRentMappingValidator.validateUpdateBikeRentDetails();
		
		boolean lBikeRentMappingUpdateStatus = bikeRentMappingDAO.updateBikeRentMapping(pUpdatedBikeRent);
		
		return lBikeRentMappingUpdateStatus;
		
	}

	public boolean updateBikeStock(BikeStockDTO pUpdatedBikeStock, BikeTypeDTO pUpdatedBikeType) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		
		BikeStockValidator lBikeStockValidator = new BikeStockValidator(pUpdatedBikeStock);
		lBikeStockValidator.validateUpdateBikeStock();
		
		boolean lBikeStockUpdateStatus = bikeStockDAO.updateBikeStock(pUpdatedBikeStock, pUpdatedBikeType);
		
		return lBikeStockUpdateStatus;
		
	}

	public boolean updateBikeStatus(BikeStatusDTO pUpdatedBikeStatus) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		
		BikeStatusValidator lBikeStatusValidator = new BikeStatusValidator(pUpdatedBikeStatus);
		lBikeStatusValidator.validateUpdateBikeStatus();
		
		boolean lBikeUpdateStatus = bikeStatusDAO.updateBikeStatus(pUpdatedBikeStatus);
		
		return lBikeUpdateStatus;
	}

}
