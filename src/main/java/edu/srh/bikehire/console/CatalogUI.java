package edu.srh.bikehire.console;

import java.util.List;
import java.util.Scanner;

import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.service.impl.BikeServiceImpl;

public class CatalogUI {

	public void showCatalog()
	{
		//STEP 1 : Get bike information from database
		
		BikeServiceImpl catalog = new BikeServiceImpl();
		List<BikeDTO> listOfBikes = catalog.getAllBikes(false);
		
	    //STEP 2 : Display catalog.
		//STEP 3:  get user input.
		
		Scanner in = null;
		try
		{			
			in = new Scanner(System.in);
			readInputs(in);
		}
		finally
		{
			
		}
	}
		private void readInputs(Scanner in)
		{
			System.out.println("Enter UserName : ");
			
		}
}
