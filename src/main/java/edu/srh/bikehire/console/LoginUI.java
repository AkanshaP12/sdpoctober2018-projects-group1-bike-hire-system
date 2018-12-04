package edu.srh.bikehire.console;

import java.util.Scanner;

public class LoginUI {

	private String username ;
	
	private String password;
	
	public void login()
	{
		System.out.println("login");
		Scanner in = null;
		try
		{			
			in = new Scanner(System.in);
			readInputs(in);
			
			//Call Login API using username and password
			
		}
		catch(Exception exception)
		{
			//TODO: Handle exception and show message
		}
		finally
		{
			if(in != null)
			{
				in.close();
			}
		}
	}
	
	private void readInputs(Scanner in)
	{
		System.out.println("Enter UserName : ");
		username=in.nextLine();
		System.out.println("Enter password: ");
		password=in.nextLine();
	}

}
