package edu.srh.bikehire.console;

import java.util.List;
import java.util.Scanner;

import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.BikeService;
import edu.srh.bikehire.service.impl.BikeServiceImpl;

public class CatalogUI {

	public void showCatalog()
	{
		//STEP 1 : Get bike information from database
		
		BikeServiceImpl bikeService = new BikeServiceImpl();
		List<BikeDTO> listOfBikes = bikeService.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, false);
		
		if(listOfBikes == null || listOfBikes.isEmpty())
		{
			System.out.println("Sorry no bikes available for now. Please try after some time.");
			LandingUIForCustomer landingUI = new LandingUIForCustomer();
			landingUI.showMenu();
			return;
		}
		
		nextInput(listOfBikes, bikeService);
		
		//STEP 3:  get user input.
	}
	
	private void displayBikes(List<BikeDTO> listOfBikes, BikeService bikeService)
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
			BikeRentMappingDTO bikeRent = bikeService.getBikeRent(bikeDTO.getBikeId());
			System.out.println("Bike rent per hour : " + bikeRent.getRentPerHour());
			System.out.println("Bike rent per day : " + bikeRent.getRentPerDay());
			System.out.println("-----------------------------------------------");
		}
	}
	
	private void nextInput(List<BikeDTO> listOfBikes, BikeService bikeService) throws BikeHireSystemException
	{
		//STEP 2 : Display catalog.
		displayBikes(listOfBikes, bikeService);
		
		System.out.println("1) Select bike \n2) Sort bike by deposit amount \n 3) View bikes by type \n 4) View bike by warehouse\n 5) Logout");
		System.out.println("Select option: ");
		Scanner sc = null;
		try
		{
			sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input)
			{
			case 1:
				selectBikeUI(sc);
				break;
			case 2:
				sortByDeposit(bikeService);
				break;
			case 3:
				viewBikeByTypes(sc, bikeService);
				break;
			case 4:
				viewBikeByWarehouse(sc, bikeService);
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
	
	private void selectBikeUI(Scanner sc)
	{
		System.out.println("Please enter bike id to select bike for booking : ");
		int bikeId = sc.nextInt();
		
		
	}
	
	private void sortByDeposit(BikeService bikeService)
	{
		List<BikeDTO> listOfBikes = bikeService.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, true);
		
		if(listOfBikes == null || listOfBikes.isEmpty())
		{
			System.out.println("Sorry no bikes available for now. Please try after some time.");
			LandingUIForCustomer landingUI = new LandingUIForCustomer();
			landingUI.showMenu();
			return;
		}
		
		nextInput(listOfBikes, bikeService);
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
		boolean isCorrectInput = false;
		int order = 1;
		do
		{			
			System.out.println("Sort by\n 1) Ascending order of deposit amount\n 2) Descending order of deposit amount");
			System.out.println("Select option: ");
			order = sc.nextInt();
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
		nextInput(lAllBikesForType, bikeService);
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
		boolean isCorrectInput = false;
		int order = 1;
		do
		{			
			System.out.println("Sort by\n 1) Ascending order of deposit amount\n 2) Descending order of deposit amount");
			System.out.println("Select option: ");
			order = sc.nextInt();
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
		nextInput(lAllBikesForType, bikeService);
	}
}
