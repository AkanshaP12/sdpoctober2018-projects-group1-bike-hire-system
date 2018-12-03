package edu.srh.bikehire.dao;

import edu.srh.bikehire.dao.impl.BikeDAOImpl;
import edu.srh.bikehire.dao.impl.BikeRentMappingDAOImpl;
import edu.srh.bikehire.dao.impl.BikeStatusDAOImpl;
import edu.srh.bikehire.dao.impl.BikeStockDAOImpl;
import edu.srh.bikehire.dao.impl.BikeTypeDAOImpl;
import edu.srh.bikehire.dao.impl.UserAccountDAOImpl;
import edu.srh.bikehire.dao.impl.UserCredentialDAOImpl;
import edu.srh.bikehire.dao.impl.UserDAOImpl;
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
	
	public static UserDAO getDefaultUserDAOImpl()
	{
		return new UserDAOImpl();
	}
	
	public static UserAccountDAO getDefaultUserAccountDAOImpl()
	{
		return new UserAccountDAOImpl();
	}
	
	public static UserCredentialDAO getDefualtUserCredentialDAOImpl()
	{
		return new UserCredentialDAOImpl();
	}
	
}
