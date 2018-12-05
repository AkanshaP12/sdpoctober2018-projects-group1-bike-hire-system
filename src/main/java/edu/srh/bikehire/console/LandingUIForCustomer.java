package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;

public class LandingUIForCustomer {
	
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
				break;
			case 2:
				callAccountUI();
				break;
			case 3:
				callOrdersUI();
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
	
	private void callCatalogUI()
	{
		CatalogUI lCatalogUI = new CatalogUI();
		lCatalogUI.showCatalog();
	}
	
	private void callAccountUI()
	{
		AccountUI lAccountUI = new AccountUI();
		lAccountUI.showAccountInfo();
	}
	
	private void callOrdersUI()
	{
		OrdersUI lOrders = new OrdersUI();
		lOrders.showOrderHistory();
		
	}
	
}
