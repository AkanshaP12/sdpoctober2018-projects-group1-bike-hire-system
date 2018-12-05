package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.impl.OrderServiceImpl;

public class LandingUIForStaff {
	private Entity loggedInEntity;
	
	public LandingUIForStaff(Entity loggedInEntity)
	{
		this.loggedInEntity = loggedInEntity;
	}
	public void showMenu() throws BikeHireSystemException
	{
		System.out.println("1) Dashboard \n2) Asset management \n3) Place order \n4)Generate invoice \n5) Logout");
		System.out.println("Select option: ");
		Scanner sc = null;
		try
		{
			sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input)
			{
			case 1:
				callDashboardUI();
				showMenu();
				break;
			case 2:
				callAssetManagementUI();
				showMenu();
				break;
			case 3:
				callPlaceOrderUI(sc);
				showMenu();
				break;
			case 4:
				callGenerateInvoice(sc);
				showMenu();
				break;
			case 5:
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
	
	private void callDashboardUI() throws BikeHireSystemException
	{
		DashboardUI dashboardUI = new DashboardUI(loggedInEntity);
		dashboardUI.showDashboard();
	}
	
	private void callAssetManagementUI() throws BikeHireSystemException
	{
		AssetManagementUI assetManagementUI = new AssetManagementUI(loggedInEntity);
		assetManagementUI.manageAssets();
	}
	
	private void callPlaceOrderUI(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("Enter Bike Id : ");
		int bikeId = sc.nextInt();
		System.out.println("Enter User Id : ");
		int userId = sc.nextInt();
		PlaceOrderUI placeOrderUI = new PlaceOrderUI(loggedInEntity, bikeId);
		boolean status = placeOrderUI.processOrder(false, userId);
	}
	
	private void callGenerateInvoice(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("Enter damage charges if any : ");
		int damageCharges = sc.nextInt();
		System.out.println("Enter warehouse id : ");
		int warehouseId = sc.nextInt();
		System.out.println("Enter payment reference : ");
		String paymentReference = sc.nextLine();
		OrderServiceImpl orderService = new OrderServiceImpl();
		String invoiceId = orderService.generateInvoice(damageCharges, warehouseId, paymentReference);
		System.out.println("Invoice generated successfully! Invoice id : " + invoiceId);
	}
}
