package edu.srh.bikehire.serviceimpl;

import edu.srh.bikehire.assetmangement.impl.BikeStockValidator;
import edu.srh.bikehire.assetmangement.impl.BikeTypeValidator;
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
		
		bikeTypeDAO.saveBikeType(pNewBikeType);
		
		
		return null;
	}

	public String addNewBikeDetails(BikeDTO pNewBike, BikeStatusDTO pBikeStatus) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addNewWarehouse(WareHouseDTO pNewWarehouse) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteBikeDetails(BikeDTO pDeleteBike) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateWarehouse(WareHouseDTO pUpdatedWarehouse) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateBikeDetails(BikeDTO pUpdatedBike) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateBikeRent(BikeRentMappingDTO pUpdatedBikeRent) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateBikeStock(BikeStockDTO pUpdatedBikeStock) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateBikeStatus(BikeStatusDTO pUpdatedBikeStatus) throws BikeHireSystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
