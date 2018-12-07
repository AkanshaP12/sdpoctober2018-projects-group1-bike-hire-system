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
	
	public void showMenu(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("1) View bike catalog \n2) Your Account \n3) Your Orders \n4) Logout");
		System.out.println("Select option: ");
		int input = sc.nextInt();
		sc.nextLine();
		switch(input)
		{
		case 1:
			callCatalogUI(sc);
			showMenu(sc);
			break;
		case 2:
			callAccountUI(sc);
			showMenu(sc);
			break;
		case 3:
			callOrdersUI(sc);
			showMenu(sc);
			break;
		case 4:
			HomePage homepage = new HomePage();
			homepage.display_menu();
			break;
		default:
			throw new BikeHireSystemException(-1);
		}
	}
	
	private void callCatalogUI(Scanner sc) throws BikeHireSystemException
	{
		CatalogUI lCatalogUI = new CatalogUI(loggedInEntity);
		lCatalogUI.showCatalog(sc);
	}
	
	private void callAccountUI(Scanner sc) throws BikeHireSystemException
	{
		AccountUI lAccountUI = new AccountUI(loggedInEntity);
		lAccountUI.showAccountInfo(sc);
	}
	
	private void callOrdersUI(Scanner sc) throws BikeHireSystemException
	{
		OrdersUI lOrders = new OrdersUI(loggedInEntity);
		lOrders.showOrders(sc);
		
	}
	
}
