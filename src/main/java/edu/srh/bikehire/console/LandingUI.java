package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;

public class LandingUI {
	
	public void showMenu() throws BikeHireSystemException
	{
		System.out.println("1) Show bike catalog \n2) Your Account \n 3) Your Orders \n");
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
	
	public void callCatalogUI()
	{
		CatalogUI lCatalogUI = new CatalogUI();
		lCatalogUI.showCatalog();
	}
	
	public void callAccountUI()
	{
		AccountUI lAccountUI = new AccountUI();
		lAccountUI.showAccountInfo();
	}
	
	public void callOrdersUI()
	{
		OrdersUI lOrders = new OrdersUI();
		lOrders.showOrderHistory();
		
	}
	
}
