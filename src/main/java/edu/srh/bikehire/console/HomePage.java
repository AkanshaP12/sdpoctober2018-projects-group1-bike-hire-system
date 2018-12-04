package edu.srh.bikehire.console;

import java.util.Scanner;

public class HomePage {
	
	public void display_menu() {
		System.out.println("1) Register \n2) Login \n 3) Forgot Password? \n");
		System.out.println("Select option: ");

	}

	public static void main(String[] args) {
		
		Scanner in = null;
		try
		{
			in = new Scanner(System.in);			
			HomePage homepage = new HomePage();
			homepage.display_menu();
			switch (in.nextInt()) {
			case 1:
				homepage.callRegistrationUI();
				break;
			case 2:
				homepage.callLoginUI();
				break;
			case 3:
				homepage.callForgotPasswordUI();
				break;
			default:
				//TODO: Throw new exception as it is invalid input
			}
		}
		catch(Exception exception)
		{
			//TODO: handle exception
		}
		finally
		{
			if(in != null)
			{
				in.close();
			}
		}
	}
	
	private void callRegistrationUI()
	{
		RegistrationUI registrationUI = new RegistrationUI();
		registrationUI.register();
	}
	
	private void callLoginUI()
	{
		LoginUI loginUI = new LoginUI();
		loginUI.login();
	}
	
	private void callForgotPasswordUI()
	{
		ForgotPasswordUI forgotPasswordUI = new ForgotPasswordUI();
		forgotPasswordUI.startFPProcess();
	}

}
