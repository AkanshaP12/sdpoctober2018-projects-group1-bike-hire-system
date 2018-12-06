package edu.srh.bikehire.console;

import java.io.IOException;
import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.LoginConstants;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.EntityAccount;
import edu.srh.bikehire.service.impl.DBBasedLoginService;
import edu.srh.bikehire.startup.AppInitializer;

public class HomePage {
	private Scanner sc = null;
	public void display_menu() {
		try {
			String leftAlignFormat = "| %-4d | %-20s |%n";

			System.out.format("+-------+---------------------+%n");
			System.out.format("| ID    | Task Name           |%n");
			System.out.format("+-------+---------------------+%n");
			System.out.format(leftAlignFormat, 1, "Register");
			System.out.format(leftAlignFormat, 2, "Login");
			System.out.format(leftAlignFormat, 3, "Forgot Password?");
			System.out.format("+-------+---------------------+%n");
			//System.out.println("1) Register \n2) Login \n 3) Forgot Password? \n");
			System.out.println("Select option: ");
			sc = new Scanner(System.in);
			ConsoleUtil.clearConsole();
			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				this.callRegistrationUI();
				break;
			case 2:
				Entity loggedInUser = this.callLoginUI();
				if(loggedInUser == null)
				{
					System.out.println("Invalid username/password. Please try again with valid credentials.");
					this.display_menu();
					return;
				}
				else {
					this.processLoggedInUser(loggedInUser);
				}
				break;
			case 3:
				
				this.callForgotPasswordUI();
				break;
			default:
				// DONE: Throw new exception as it is invalid input
				throw new BikeHireSystemException(-1);
			}
		} catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

	public static void main(String[] args) throws IOException {
		AppInitializer initializer = new AppInitializer();
		initializer.initializeApplication();
		HomePage homepage = new HomePage();
		homepage.display_menu();
	}

	private void callRegistrationUI() throws BikeHireSystemException {
		RegistrationUI registrationUI = new RegistrationUI();
		registrationUI.register(sc);
	}

	private Entity callLoginUI() {
		LoginUI loginUI = new LoginUI();
		return loginUI.login(sc);
	}

	private void callForgotPasswordUI() throws BikeHireSystemException {
		ForgotPasswordUI forgotPasswordUI = new ForgotPasswordUI();
		forgotPasswordUI.startFPProcess(sc);
	}

	private void processLoggedInUser(Entity entity) throws BikeHireSystemException
	{
		DBBasedLoginService lDbBasedLoginService = new DBBasedLoginService();
		EntityAccount userAccount = lDbBasedLoginService.getAccountInfo(entity.getUserId());
		if(LoginConstants.LOGIN_ACCOUNT_STATUS_INACTIVE.equals(userAccount.getAccountStatus()))
		{
			//TODO:
			throw new BikeHireSystemException(-1);
		}
		
		if(LoginConstants.LOGIN_ACCOUNT_STATUS_UNVERIFIED.equals(userAccount.getAccountStatus()))
		{
			System.out.println("Please verify your account!");
			return;
		}
		
		if(LoginConstants.LOGIN_ACCOUNT_ROLE_CUSTOMER.equals(userAccount.getUserRole()))
		{
			LandingUIForCustomer landingUIForCustomer = new LandingUIForCustomer(entity);
			landingUIForCustomer.showMenu(sc);
		}
		else
		{
			LandingUIForStaff landingUIForStaff = new LandingUIForStaff(entity);
			landingUIForStaff.showMenu(sc);
		}
	}
}
