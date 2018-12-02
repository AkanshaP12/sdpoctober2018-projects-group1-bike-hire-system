package edu.srh.bikehire.daoimpl.util;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.BikeRentMappingDAO;
import edu.srh.bikehire.dao.BikeStatusDAO;
import edu.srh.bikehire.dao.BikeStockDAO;
import edu.srh.bikehire.dao.BikeTypeDAO;
import edu.srh.bikehire.dao.WarehouseDAO;
import edu.srh.bikehire.dao.impl.BikeDAOImpl;
import edu.srh.bikehire.dao.impl.BikeRentMappingDAOImpl;
import edu.srh.bikehire.dao.impl.BikeStatusDAOImpl;
import edu.srh.bikehire.dao.impl.BikeStockDAOImpl;
import edu.srh.bikehire.dao.impl.BikeTypeDAOImpl;
import edu.srh.bikehire.dao.impl.WarehouseDAOImpl;

public class DAOFactory {
	
	public static BikeDAO getDefualtBikeDAOImpl()
	{
		return new BikeDAOImpl();
	}
	
	public static BikeStatusDAO getDefaultBikeStatusDAOImpl()
	{
		return new BikeStatusDAOImpl();
	}
	
	public static BikeStockDAO getDefaultBikeStockDAOImpl()
	{
		return new BikeStockDAOImpl();
	}
	
	public static BikeTypeDAO getDefualtBikeTypeDAOImpl()
	{
		return new BikeTypeDAOImpl();
	}
	
	public static BikeRentMappingDAO getDefaultBikeRentMappingDAOImpl()
	{
		return new BikeRentMappingDAOImpl();
	}
	
	public static WarehouseDAO getDefaultWarehouseDAOImpl()
	{
		return new WarehouseDAOImpl();
	}
	
}
