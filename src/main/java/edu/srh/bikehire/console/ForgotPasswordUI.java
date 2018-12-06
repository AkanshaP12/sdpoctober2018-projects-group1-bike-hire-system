package edu.srh.bikehire.console;

import java.util.Scanner;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.ResetPasswordValidator;
import edu.srh.bikehire.service.core.EntityRegistrationCredential;
import edu.srh.bikehire.service.core.impl.CustomerRegistrationCredential;
import edu.srh.bikehire.service.impl.DBBasedLoginService;

public class ForgotPasswordUI {
	private String emailAddress;
	
	public void startFPProcess(Scanner sc) throws BikeHireSystemException 
	//Boolean 
	{
		System.out.println("Enter your email address to proceed : ");
		emailAddress = sc.nextLine();
		
		//STEP 2 : Send email security token 
		DBBasedLoginService loginService = new DBBasedLoginService();
		ResetPasswordValidator validator = loginService.sendSecurityTokenForResetPassword(emailAddress);
		
		
		//STEP 3 : Verify security token from user.
		sc = new Scanner(System.in);
		System.out.println("Enter Your Security Token : ");
		String securityToken = sc.nextLine();
		validator.validateToken(securityToken);
		
		//STEP 4 : Change password (Ideally ask for new password and confirm password)
		sc =new Scanner(System.in);
		System.out.println("Enter New Password: ");
		String password = sc.nextLine();
		System.out.println("Re-Enter Password: ");
		String resetpassword = sc.nextLine();
		EntityRegistrationCredential lCredential = new CustomerRegistrationCredential();
		loginService.resetPassword(lCredential);
	}
	
	
}
