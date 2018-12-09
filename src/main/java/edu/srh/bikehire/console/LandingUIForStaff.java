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
	public void showMenu(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("1) Dashboard \n2) Asset management \n3) Place order \n4) Generate invoice \n5) Logout");
		System.out.println("Select option: ");
		int input = sc.nextInt();
		sc.nextLine();
		switch(input)
		{
		case 1:
			callDashboardUI(sc);
			showMenu(sc);
			break;
		case 2:
			callAssetManagementUI(sc);
			showMenu(sc);
			break;
		case 3:
			callPlaceOrderUI(sc);
			showMenu(sc);
			break;
		case 4:
			callGenerateInvoice(sc);
			showMenu(sc);
			break;
		case 5:
			HomePage homepage = new HomePage();
			homepage.display_menu();
			break;
		default:
			throw new BikeHireSystemException(-1);
		}
	}
	
	private void callDashboardUI(Scanner sc) throws BikeHireSystemException
	{
		DashboardUI dashboardUI = new DashboardUI(loggedInEntity);
		dashboardUI.showDashboard(sc);
	}
	
	private void callAssetManagementUI(Scanner sc) throws BikeHireSystemException
	{
		AssetManagementUI assetManagementUI = new AssetManagementUI(loggedInEntity);
		assetManagementUI.manageAssets(sc);
	}
	
	private void callPlaceOrderUI(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("Enter Bike Id : ");
		int bikeId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter User Id : ");
		int userId = sc.nextInt();
		sc.nextLine();
		PlaceOrderUI placeOrderUI = new PlaceOrderUI(loggedInEntity, bikeId);
		boolean status = placeOrderUI.processOrder(sc, false, userId);
	}
	
	private void callGenerateInvoice(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("Enter damage charges if any : ");
		int damageCharges = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter warehouse id : ");
		int warehouseId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter payment reference : ");
		String paymentReference = sc.nextLine();
		OrderServiceImpl orderService = new OrderServiceImpl();
		String invoiceId = orderService.generateInvoice( damageCharges, warehouseId, paymentReference);
		System.out.println("Invoice generated successfully! Invoice id : " + invoiceId);
	}
}