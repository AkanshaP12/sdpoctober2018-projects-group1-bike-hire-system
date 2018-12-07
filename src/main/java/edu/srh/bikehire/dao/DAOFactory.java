package edu.srh.bikehire.dao;

import edu.srh.bikehire.dao.impl.BikeDAOImpl;
import edu.srh.bikehire.dao.impl.BikeRentMappingDAOImpl;
import edu.srh.bikehire.dao.impl.BikeStatusDAOImpl;
import edu.srh.bikehire.dao.impl.BikeStockDAOImpl;
import edu.srh.bikehire.dao.impl.BikeTypeDAOImpl;
import edu.srh.bikehire.dao.impl.CurrentOrderDAOImpl;
import edu.srh.bikehire.dao.impl.InvoiceDAOImpl;
import edu.srh.bikehire.dao.impl.OrderHistoryDAOImpl;
import edu.srh.bikehire.dao.impl.OrderPaymentDAOImpl;
import edu.srh.bikehire.dao.impl.UserAccountDAOImpl;
import edu.srh.bikehire.dao.impl.UserCredentialDAOImpl;
import edu.srh.bikehire.dao.impl.UserDAOImpl;
import edu.srh.bikehire.dao.impl.WarehouseDAOImpl;
import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.service.core.Order;
import edu.srh.bikehire.service.impl.OrderServiceImpl;

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
	
	public static BikeTypeDAO getDefaultBikeTypeDAOImpl()
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
	
	public static UserCredentialDAO getDefaultUserCredentialDAOImpl()
	{
		return new UserCredentialDAOImpl();
	}
	
	public static CurrentOrderDAO getDefaultOrderDAOImpl()
	{
		return new CurrentOrderDAOImpl();
	}
	
	public static InvoiceDAO getDefaultInvoiceDAOImpl()
	{
		return new InvoiceDAOImpl();
	}
	
	public static OrderHistoryDAO getDefaultOrderHistoryImpl() 
	{
		return new OrderHistoryDAOImpl();
	}
	
	public static OrderPaymentDAO getDefaultOrderPaymentImpl()
	{
		return new OrderPaymentDAOImpl();
	}
}
