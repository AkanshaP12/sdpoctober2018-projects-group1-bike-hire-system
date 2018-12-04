package edu.srh.bikehire.console;

import java.util.Scanner;

public class ForgotPasswordUI {
	private String emailAddress;
	
	public void startFPProcess()
	{
		Scanner sc = null;
		try
		{
			//STEP 1 : Get email address from user
			sc = new Scanner(System.in);
			System.out.println("Enter your email address to proceed : ");
			emailAddress = sc.nextLine();
			
			//STEP 2 : Send email security token 
			
			
			//STEP 3 : Verify security token from user.
			
			//STEP 4 : Change password (Ideally ask for new password and confirm password)
			
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
