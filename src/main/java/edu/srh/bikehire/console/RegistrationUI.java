package edu.srh.bikehire.console;

import java.util.Scanner;

public class RegistrationUI {
	public void register()
	{
		System.out.println("Registration");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your First Name : ");
		String firstname=in.nextLine();
		System.out.println("Enter your Last Name : ");
		String lastname=in.nextLine();
		System.out.println("Enter your Gender : ");
		String gender=in.nextLine();
		System.out.println("Enter your age : ");
		String age=in.nextLine();
		System.out.println("Enter your Address : ");
    	String address=in.nextLine();
		System.out.println("Please Provide Image(file path): ");
		String pic=in.nextLine();
		System.out.println("Enter your EmailID: ");
		String mail=in.nextLine();
		System.out.println("Enter your Phone.no: ");
		String Phone=in.nextLine();
		System.out.println("Please Provide ID proof(file path): ");
		String IDproff=in.nextLine();
		System.out.println("User Successfully Registered");
		
	}
	

}
