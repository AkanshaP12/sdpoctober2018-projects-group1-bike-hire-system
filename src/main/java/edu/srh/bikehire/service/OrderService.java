package edu.srh.bikehire.service;

import java.util.List;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.service.core.Order;

public interface OrderService {

	public List<Order> getOrderHistory(String userID) throws BikeHireSystemException;
	
	public String placeOrder(String userID, String bikeID);
	
	public void cancelOrder(String orderID) throws BikeHireSystemException;
	
	public Order getOrder(String orderID) throws BikeHireSystemException ;
	
	public String generateInvoice(String orderID);
	
	public Invoice getInvoice(String invoiceID);
}
