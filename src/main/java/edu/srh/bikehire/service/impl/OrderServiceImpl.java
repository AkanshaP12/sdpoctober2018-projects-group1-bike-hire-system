package edu.srh.bikehire.service.impl;

import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.CurrentOrderDAO;
import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dao.InvoiceDAO;
import edu.srh.bikehire.dao.OrderHistoryDAO;
import edu.srh.bikehire.dao.UserAccountDAO;
import edu.srh.bikehire.dao.impl.OrderHistoryDAOImpl;
import edu.srh.bikehire.dto.OrderHistoryDTO;
import edu.srh.bikehire.dto.UserAccountDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.LoginConstants;
import edu.srh.bikehire.service.OrderService;
import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.service.core.Order;

public class OrderServiceImpl implements OrderService {
	
	private BikeDAO bikeDAO;
	
	private UserAccountDAO userAccountDAO;
	
	private CurrentOrderDAO orderDAO;
	
	private InvoiceDAO invoiceDAO;
	
	private OrderHistoryDAO orderHistory;
	
	public void initializeService()
	{
		bikeDAO = DAOFactory.getDefualtBikeDAOImpl();
		userAccountDAO = DAOFactory.getDefaultUserAccountDAOImpl();
		orderDAO = DAOFactory.getDefaultOrderDAOImpl();
		invoiceDAO = DAOFactory.getDefaultInvoiceDAOImpl();
		orderHistory = DAOFactory.getDefaultOrderHistoryImpl();
		
	}

	public List<Order> getOrderHistory(String userID) throws BikeHireSystemException {
		UserAccountDTO lUserAccountDTO = userAccountDAO.getUserAccount(userID);
		if (lUserAccountDTO == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(!lUserAccountDTO.getAccountStatus().equals(LoginConstants.LOGIN_ACCOUNT_STATUS_ACTIVE))
		{
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		Order lOrder = new getOrderHistoryByUserId(userID);
		return null;
		
	}

	public String placeOrder(String userID, String bikeID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelOrder(String orderID) throws BikeHireSystemException {
		OrderHistoryDTO lOrderHistoryDTO = orderHistory.getOrderHistoryByOrderId(orderID);
		
		if (lOrderHistoryDTO == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	}

	public Order getOrder(String orderID) throws BikeHireSystemException {
		OrderHistoryDTO lOrderHistoryDTO = orderHistory.getOrderHistoryByOrderId(orderID);
		
		if (lOrderHistoryDTO == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		return null;
	}

	public String generateInvoice(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public Invoice getInvoice(String invoiceID) {
		
		return null;
	}
	
	

}
