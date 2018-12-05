package edu.srh.bikehire.service;

import java.util.List;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.service.core.Order;
import edu.srh.bikehire.service.core.OrderHistory;

public interface OrderService {

	public List<OrderHistory> getOrderHistory(int userID) throws BikeHireSystemException;
	
	public int placeOrder(Order order) throws BikeHireSystemException ;
	
	public void cancelOrder(int orderID) throws BikeHireSystemException;
	
	public Order getOrder(int orderID) throws BikeHireSystemException ;
	
	public String generateInvoice(int damageCharges, int warehouseId, String paymentReference) throws BikeHireSystemException ;
	
	public Invoice getInvoice(String invoiceID) throws BikeHireSystemException ;
}
