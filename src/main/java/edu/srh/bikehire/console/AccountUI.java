package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.Login;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.EntityRegistrationCredential;
import edu.srh.bikehire.service.core.impl.CustomerRegistrationCredential;
import edu.srh.bikehire.service.impl.DBBasedLoginService;

public class AccountUI {
	private Entity loggedInUser;
	
	public AccountUI(Entity loggedInUser)
	{
		this.loggedInUser = loggedInUser;
	}
	
	public void showAccountInfo() throws BikeHireSystemException
	{
		System.out.println("Name : " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
		System.out.println("Email address : " + loggedInUser.getEmailId());
		System.out.println("Gender : " + loggedInUser.getGender());
		System.out.println("1) Change password\n 2) Deactivate account\n 3) Back");
		System.out.println("Select option: ");
		Scanner sc = null;
		try
		{
			sc = new Scanner(System.in);
			int input = sc.nextInt();
			DBBasedLoginService loginService = new DBBasedLoginService();
			switch(input) {
			case 1 :
				changePassword(sc, loginService);
				break;
			case 2:
				boolean status = deactivateAccount(sc, loginService);
				if(status)
				{
					return;
				}
				showAccountInfo();
				break;
			case 3:
				LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInUser);
				landingUI.showMenu();
				return;
			default:
				//TODO:
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
	
	private void changePassword(Scanner sc, Login loginService) throws BikeHireSystemException
	{
		
		System.out.println("Enter New Password: ");
		String password = sc.nextLine();
		System.out.println("Re-Enter Password: ");
		String resetpassword = sc.nextLine();
		EntityRegistrationCredential lCredential = new CustomerRegistrationCredential();
		loginService.resetPassword(lCredential);
		System.out.println("Your password has been changed!");
	}
	
	private boolean deactivateAccount(Scanner sc, Login loginService) throws BikeHireSystemException
	{
		System.out.println("Do you want to deactivate account? (y/n)");
		String input = sc.nextLine();
		if(input.equalsIgnoreCase("y"))
		{
			loginService.deactivateAccount(loggedInUser);
			System.out.println("Your account has been deactivated!");
			HomePage homePage = new HomePage();
			homePage.display_menu();
			return true;
		}
		return false;
	}
}
