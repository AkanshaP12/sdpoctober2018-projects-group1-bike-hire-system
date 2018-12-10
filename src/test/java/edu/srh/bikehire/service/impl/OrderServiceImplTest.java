package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;

import java.util.List;

import org.junit.Test;

import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dao.DAOFactoryType;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Invoice;
import edu.srh.bikehire.service.core.Order;
import edu.srh.bikehire.service.core.OrderHistory;
import edu.srh.bikehire.service.core.impl.OrderInfo;

public class OrderServiceImplTest {
	OrderServiceImpl orderService = new OrderServiceImpl();

	String invoiceID =  null;
	
	@Test
	public void testPlaceOrder() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(1);
		orderInfo.setBikeId(1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(Calendar.getInstance());
		orderInfo.setPickupTimestamp(Calendar.getInstance());
		orderInfo.setDropOffTimestamp(Calendar.getInstance());
		orderInfo.setActualDropoffTimestamp(Calendar.getInstance());
		int OrderId = orderService.placeOrder(orderInfo);
		assertTrue(OrderId > 0);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testPlaceOrderInvalidUserId() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(-1);
		orderInfo.setBikeId(1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(Calendar.getInstance());
		orderInfo.setPickupTimestamp(Calendar.getInstance());
		orderInfo.setDropOffTimestamp(Calendar.getInstance());
		orderInfo.setActualDropoffTimestamp(Calendar.getInstance());
		int OrderId = orderService.placeOrder(orderInfo);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testPlaceOrderInvalidBikeId() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(1);
		orderInfo.setBikeId(-1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(Calendar.getInstance());
		orderInfo.setPickupTimestamp(Calendar.getInstance());
		orderInfo.setDropOffTimestamp(Calendar.getInstance());
		orderInfo.setActualDropoffTimestamp(Calendar.getInstance());
		int OrderId = orderService.placeOrder(orderInfo);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testPlaceOrderInvalidBookingTimeStamp() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(1);
		orderInfo.setBikeId(1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(null);
		orderInfo.setPickupTimestamp(Calendar.getInstance());
		orderInfo.setDropOffTimestamp(Calendar.getInstance());
		orderInfo.setActualDropoffTimestamp(Calendar.getInstance());
		int OrderId = orderService.placeOrder(orderInfo);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testPlaceOrderInvalidpickUpTimeStamp() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(1);
		orderInfo.setBikeId(1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(Calendar.getInstance());
		orderInfo.setPickupTimestamp(null);
		orderInfo.setDropOffTimestamp(Calendar.getInstance());
		orderInfo.setActualDropoffTimestamp(Calendar.getInstance());
		int OrderId = orderService.placeOrder(orderInfo);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testPlaceOrderInvalidDropOffTimeStamp() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(1);
		orderInfo.setBikeId(1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(Calendar.getInstance());
		orderInfo.setPickupTimestamp(Calendar.getInstance());
		orderInfo.setDropOffTimestamp(null);
		orderInfo.setActualDropoffTimestamp(Calendar.getInstance());
		int OrderId = orderService.placeOrder(orderInfo);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testPlaceOrderInvalidActualDropOffTimeStamp() throws BikeHireSystemException  {
		OrderInfo orderInfo = new OrderInfo();
		//create user id and bike id
		orderInfo.setUserId(1);
		orderInfo.setBikeId(1);
		orderInfo.setOrderMode("online");
		orderInfo.setBookingTimestamp(Calendar.getInstance());
		orderInfo.setPickupTimestamp(Calendar.getInstance());
		orderInfo.setDropOffTimestamp(Calendar.getInstance());
		orderInfo.setActualDropoffTimestamp(null);
		int OrderId = orderService.placeOrder(orderInfo);	
	}

	@Test
	public void testGetOrderHistory() throws BikeHireSystemException {
		int userID = 1;

		List<OrderHistory> lReturnList  = orderService.getOrderHistory(userID);
		assertNotNull(lReturnList);
		assertTrue(lReturnList.size()>0);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testGetOrderHistoryInvalidUserId() throws BikeHireSystemException {
		int userID = -1;
		
		List<OrderHistory> lReturnList  = orderService.getOrderHistory(userID);
	}

	@Test
	public void testCancelOrder() throws BikeHireSystemException  {
		int orderID=1;
		
		orderService.cancelOrder(orderID);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testCancelOrderForCompletedOrder() throws BikeHireSystemException  {
		int orderID=1;
		
		orderService.cancelOrder(orderID);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testCancelOrderForInvalidOrderID() throws BikeHireSystemException  {
		int orderID=-1;
		
		orderService.cancelOrder(orderID);
	}

	@Test
	public void testGetOrder() throws BikeHireSystemException {
		int orderID = 1;
		
		Order lReturnOrder  = orderService.getOrder(orderID);
		assertNotNull(lReturnOrder);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testGetOrderInvalidOrderId() throws BikeHireSystemException {
		int orderID = -1;
		
		Order lReturnOrder  = orderService.getOrder(orderID);
		
	}
	
	
    @Test
	public void testGetCurrentOrdersForUser() throws BikeHireSystemException {
    	int userID = 1;

		List<Order> allOrders  = orderService.getCurrentOrdersForUser(userID);
		assertNotNull(allOrders);
		assertTrue(allOrders.size()>0);
	}
    
    @Test(expected = BikeHireSystemException.class)
	public void testGetCurrentOrdersForUserInvalidUserId() throws BikeHireSystemException {
    	int userID = -1;

		List<Order> allOrders  = orderService.getCurrentOrdersForUser(userID);
		
	}

	@Test
	public void testGenerateInvoice() throws BikeHireSystemException {
		//first add damage charges, warehouseId, payment reference and then return invoiceId
		int damagecharges= 12;
		int warehouseId	= 2;
		invoiceID = orderService.generateInvoice(damagecharges,warehouseId,1);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testGenerateInvoiceInvalidDamageCharge() throws BikeHireSystemException {
		int damagecharges= -12;
		int warehouseId	= 2;
		int orderId = 1;
		String invoiceID = orderService.generateInvoice(damagecharges,warehouseId,orderId);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testGenerateInvoiceInvalidWarehouseId() throws BikeHireSystemException {
		int damagecharges= 12;
		int warehouseId	= -2;
		int orderId = 1;
		String invoiceID = orderService.generateInvoice(damagecharges,warehouseId,orderId);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testGenerateInvoiceInvalidOrderId() throws BikeHireSystemException {
		int damagecharges= 12;
		int warehouseId	= 2;
		String invoiceID = orderService.generateInvoice(damagecharges,warehouseId,-1);
		
	}

	@Test
	public void testGetInvoice() throws BikeHireSystemException {
		//first add new invoice and then get invoice
		Invoice lReturnInvoice  = orderService.getInvoice(invoiceID);
		
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testGetInvoiceInvalidInvoiceID() throws BikeHireSystemException {
		String invoiceID = null;
		Invoice lReturnInvoice  = orderService.getInvoice(invoiceID);
		assertNotNull(orderService.getOrder(1));
	}

	@Test
	public void testGetCurrentOrderForUser() throws BikeHireSystemException {
		assertNotNull(orderService.getCurrentOrdersForUser(1));
	}
}
