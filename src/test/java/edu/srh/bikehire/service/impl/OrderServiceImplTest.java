package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Order;

public class OrderServiceImplTest {

	OrderServiceImpl orderService;
	
	@Before
	public void setup() {
		orderService = new OrderServiceImpl();
	} 

	
	@Test
	public void testInitializeService() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrderHistory() throws BikeHireSystemException {
		assertNotNull(orderService.getOrderHistory(1));
	}

	@Test
	public void testPlaceOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrder() throws BikeHireSystemException {
		assertNotNull(orderService.getOrder(1));
	}

	@Test
	public void testGetCurrentOrderForUser() throws BikeHireSystemException {
		assertNotNull(orderService.getCurrentOrdersForUser(1));
	}

	@Test
	public void testGenerateInvoice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInvoice() {
		fail("Not yet implemented");
	}

}
