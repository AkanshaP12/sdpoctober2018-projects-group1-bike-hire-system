package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;

public class LandingUIForStaff {
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
				// call dashboard ui
				break;
			case 2:
				// call asset management
				break;
			case 3:
				// call place holder
				break;
			case 4:
				// call generate invoice
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
}
