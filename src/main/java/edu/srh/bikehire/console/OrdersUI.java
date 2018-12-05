package edu.srh.bikehire.console;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.OrderService;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.Order;
import edu.srh.bikehire.service.core.OrderHistory;
import edu.srh.bikehire.service.impl.OrderServiceImpl;

public class OrdersUI {
	private Entity loggedInUser;
	
	public OrdersUI(Entity loggedInUser)
	{
		this.loggedInUser = loggedInUser;
	}
	
	public void showOrders() throws BikeHireSystemException
	{
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Order order = orderServiceImpl.getCurrentOrderForUser(loggedInUser.getUserId());
		
		Scanner sc = null;
		try
		{
			if(order == null)
			{			
				System.out.println("No current order for your account.");
			}
			else
			{			
				System.out.println("Current Order : ");
				System.out.println("Order Id : " + order.getOrderId());
				System.out.println("Bike Id : " + order.getBikeId());
				System.out.println("Order Mode : " + order.getOrderMode());
				System.out.println("Booking time : " + order.getBookingTimestamp());
				
				if(order.getPickupTimestamp().before(Calendar.getInstance()))
				{
					//Cancel order
					System.out.println("Do you want to cancel this order? (y/n)");
					String input = sc.nextLine(); 
					if(input.equalsIgnoreCase("y"))
					{
						orderServiceImpl.cancelOrder(order.getOrderId());
						System.out.println("Order cancelled successfully!");
					}
				}
			}
			
			sc = new Scanner(System.in);	
			
			System.out.println("Do you want to view previous order history? (y/n)");
			String input = sc.nextLine(); 
			if(input.equalsIgnoreCase("y"))
			{
				showOrderHistory(sc, orderServiceImpl);
			}
			else
			{
				LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInUser);
				landingUI.showMenu();
				return;
			}
					
		}
		finally
		{
			if(sc != null)
			{
				sc.close();
			}
		}
		
	}
	
	private void showOrderHistory(Scanner sc, OrderService orderServiceImpl) throws BikeHireSystemException
	{
		List<OrderHistory> orderHistories = orderServiceImpl.getOrderHistory(loggedInUser.getUserId());
		if(orderHistories == null || orderHistories.isEmpty())
		{
			System.out.println("No previous orders!");
			LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInUser);
			landingUI.showMenu();
			return;
		}
		
		System.out.println("Number of orders : " + orderHistories.size());
		System.out.println("-------------------------------------------------");
		for(OrderHistory orderHistory : orderHistories)
		{
			System.out.println("Order Id : " + orderHistory.getOrderId());
			System.out.println("Bike Id : " + orderHistory.getBikeId());
			System.out.println("Order Status : " + orderHistory.getOrderStatus());
			System.out.println("Booking time : " + orderHistory.getBookingTimeStamp());
			System.out.println("-------------------------------------------------");
		}
	}
}
