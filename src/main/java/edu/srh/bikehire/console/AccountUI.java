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
	
	public void showAccountInfo(Scanner sc) throws BikeHireSystemException
	{
		System.out.println("Name : " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
		System.out.println("Email address : " + loggedInUser.getEmailId());
		System.out.println("Gender : " + loggedInUser.getGender());
		System.out.println("1) Change password\n2) Deactivate account\n3) Back");
		System.out.println("Select option: ");
		
		int input = sc.nextInt();
		sc.nextLine();
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
			showAccountInfo(sc);
			break;
		case 3:
			LandingUIForCustomer landingUI = new LandingUIForCustomer(loggedInUser);
			landingUI.showMenu(sc);
			return;
		default:
			//ERROR MESSAGE: Invalid option is selected
			throw new BikeHireSystemException(10060);
		}
	}
	
	private void changePassword(Scanner sc, Login loginService) throws BikeHireSystemException
	{
		
		System.out.println("Enter New Password: ");
		String password = sc.nextLine();
		System.out.println("Re-Enter Password: ");
		String confirmPassword = sc.nextLine();
		CustomerRegistrationCredential lCredential = new CustomerRegistrationCredential();
		lCredential.setUserName(loggedInUser.getEntityAccount().getUserName());
		lCredential.setNewPassword(password);
		lCredential.setConfirmPassword(confirmPassword);
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
