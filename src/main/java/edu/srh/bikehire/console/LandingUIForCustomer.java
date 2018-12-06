package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Entity;

public class LandingUIForCustomer {
	
	private Entity loggedInEntity;
	
	public LandingUIForCustomer(Entity loggedInEntity)
	{
		this.loggedInEntity = loggedInEntity;
	}
	
	public void showMenu() throws BikeHireSystemException
	{
		System.out.println("1) View bike catalog \n2) Your Account \n 3) Your Orders \n4) Logout");
		System.out.println("Select option: ");
		Scanner sc = null;
		try
		{
			sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input)
			{
			case 1:
				callCatalogUI();
				showMenu();
				break;
			case 2:
				callAccountUI();
				showMenu();
				break;
			case 3:
				callOrdersUI();
				showMenu();
				break;
			case 4:
				HomePage homepage = new HomePage();
				homepage.display_menu();
				break;
			default:
				throw new BikeHireSystemException(-1);
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
	
	private void callCatalogUI() throws BikeHireSystemException
	{
		CatalogUI lCatalogUI = new CatalogUI(loggedInEntity);
		lCatalogUI.showCatalog();
	}
	
	private void callAccountUI() throws BikeHireSystemException
	{
		AccountUI lAccountUI = new AccountUI(loggedInEntity);
		lAccountUI.showAccountInfo();
	}
	
	private void callOrdersUI() throws BikeHireSystemException
	{
		OrdersUI lOrders = new OrdersUI(loggedInEntity);
		lOrders.showOrders();
		
	}
	
}
