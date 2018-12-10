package edu.srh.bikehire.console;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.BikeService;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.impl.BikeServiceImpl;

public class CatalogUI {

	private Entity loggedInEntity;
	
	public CatalogUI(Entity loggedInEntity)
	{
		this.loggedInEntity = loggedInEntity;
	}
	
	public void showCatalog(Scanner sc) throws BikeHireSystemException
	{
		
		BikeServiceImpl bikeService = new BikeServiceImpl();
		List<BikeDTO> listOfBikes = bikeService.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, false);
		
		if(listOfBikes == null || listOfBikes.isEmpty())
		{
			System.out.println("Sorry no bikes available for now. Please try after some time.");
			LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInEntity);
			landingUI.showMenu(sc);
			return;
		}
		
		nextInput(sc, listOfBikes, bikeService);
		
	}
	
	private void displayBikes(List<BikeDTO> listOfBikes, BikeService bikeService) throws BikeHireSystemException
	{
		System.out.println("Total bikes : " + listOfBikes.size());
		System.out.println("-----------------------------------------------");
		for(BikeDTO bikeDTO : listOfBikes)
		{
			System.out.println("Bike Id : " + bikeDTO.getBikeId());
			BikeTypeDTO bikeTypeDTO = bikeService.getBikeTypeInfo(bikeDTO.getBikeTypeId());
			System.out.println("Bike Type : " + bikeTypeDTO.getBikeType());
			System.out.println("Bike Title : " + bikeDTO.getBikeTitle());
			System.out.println("Bike Deposit Amount : " + bikeDTO.getDepositAmount());
			BikeRentMappingDTO bikeRent = bikeService.getBikeRent(bikeDTO.getBikeTypeId());
			System.out.println("Bike rent per hour : " + bikeRent.getRentPerHour());
			System.out.println("Bike rent per day : " + bikeRent.getRentPerDay());
			System.out.println("-----------------------------------------------");
		}
	}
	
	private void nextInput(Scanner sc, List<BikeDTO> listOfBikes, BikeService bikeService) throws BikeHireSystemException
	{
		if(listOfBikes != null)
		{			
			displayBikes(listOfBikes, bikeService);
		}
		
		System.out.println("1) Select bike \n2) Sort bike by deposit amount \n3) View bikes by type \n4) View bike by warehouse\n5) Group Booking \n6) Back");
		System.out.println("Select option: ");
		int input = sc.nextInt();
		sc.nextLine();
		switch(input)
		{
		case 1:
			boolean orderStatus = placeBikeOrderUI(sc);
			if(!orderStatus)
			{
				this.showCatalog(sc);
				return;
			}
			
			LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInEntity);
			landingUI.showMenu(sc);
			return;
		case 2:
			sortByDeposit(sc, bikeService);
			break;
		case 3:
			viewBikeByTypes(sc, bikeService);
			break;
		case 4:
			viewBikeByWarehouse(sc, bikeService);
			break;
		case 5:
			groupBookingOption(sc, bikeService);
			break;
		case 6:
			LandingUIForCustomer customerLandingUi = new LandingUIForCustomer(loggedInEntity);
			customerLandingUi.showMenu(sc);
			break;
		default:
			throw new BikeHireSystemException(-1);
		}

	}
	
	private boolean placeBikeOrderUI(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("Please enter bike id to select bike for booking : ");
		int bikeId = sc.nextInt();
		sc.nextLine();
		PlaceOrderUI placeOrder = new PlaceOrderUI(loggedInEntity, bikeId);
		return placeOrder.processOrder(sc, true, loggedInEntity.getUserId());
	}
	
	private void sortByDeposit(Scanner sc, BikeService bikeService) throws BikeHireSystemException
	{
		List<BikeDTO> listOfBikes = bikeService.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, true);
		
		if(listOfBikes == null || listOfBikes.isEmpty())
		{
			System.out.println("Sorry no bikes available for now. Please try after some time.");
			LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInEntity);
			landingUI.showMenu(sc);
			return;
		}
		
		nextInput(sc, listOfBikes, bikeService);
	}
	
	private void viewBikeByTypes(Scanner sc, BikeService bikeService) throws BikeHireSystemException
	{
		List<BikeTypeDTO> bikeTypes = bikeService.getBikeTypes();
		System.out.println("Following bike types are available : ");
		for(BikeTypeDTO bikeTypeDTO : bikeTypes)
		{
			System.out.println("Bike Type Id : " + bikeTypeDTO.getBikeTypeId());
			System.out.println("Bike Type : " + bikeTypeDTO.getBikeType());
		}
		
		System.out.println("Select option: ");
		int bikeTypeId = sc.nextInt();
		sc.nextLine();
		boolean isCorrectInput = false;
		int order = 1;
		do
		{			
			System.out.println("Sort by\n 1) Ascending order of deposit amount\n 2) Descending order of deposit amount");
			System.out.println("Select option: ");
			order = sc.nextInt();
			sc.nextLine();
			if(order != 1 && order!= 2)
			{
				isCorrectInput = false;
			}
			isCorrectInput = true;
		}
		while(!isCorrectInput);
		
		boolean isSortDescending = false;
		if(order == 2)
		{
			isSortDescending = true;
		}
		
		List<BikeDTO> lAllBikesForType = bikeService.getAllBikesBasedOnType(bikeTypeId, isSortDescending);
		nextInput(sc, lAllBikesForType, bikeService);
	}
	
	private void viewBikeByWarehouse(Scanner sc, BikeService bikeService) throws BikeHireSystemException
	{
		List<WareHouseDTO> warehouses = bikeService.getAllWarehouses();
		System.out.println("Following warehouses are available : ");
		for(WareHouseDTO warehouseDTO : warehouses)
		{
			System.out.println("Warehouse Id : " + warehouseDTO.getWarehouseId());
			System.out.println("Warehouse Name : " + warehouseDTO.getName());
			System.out.println("Warehouse Location : " + warehouseDTO.getLocation());
		}
		
		System.out.println("Select option: ");
		int warehouseId = sc.nextInt();
		sc.nextLine();
		boolean isCorrectInput = false;
		int order = 1;
		do
		{			
			System.out.println("Sort by\n 1) Ascending order of deposit amount\n 2) Descending order of deposit amount");
			System.out.println("Select option: ");
			order = sc.nextInt();
			sc.nextLine();
			if(order != 1 && order!= 2)
			{
				isCorrectInput = false;
			}
			isCorrectInput = true;
		}
		while(!isCorrectInput);

		boolean isSortDescending = false;
		if(order == 2)
		{
			isSortDescending = true;
		}
		
		List<BikeDTO> lAllBikesForType = bikeService.getAllBikesBasedOnWarehouse(warehouseId, isSortDescending);
		nextInput(sc, lAllBikesForType, bikeService);
	}
	
	private void groupBookingOption(Scanner sc, BikeService bikeService) throws BikeHireSystemException
	{
		GroupBookingUI groupBookingUi = new GroupBookingUI(loggedInEntity, true);
		groupBookingUi.processGroupBooking(sc);
		LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInEntity);
		landingUI.showMenu(sc);
		return;
	}
}
