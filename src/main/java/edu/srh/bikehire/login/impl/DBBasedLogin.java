package edu.srh.bikehire.login.impl;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.Entity;
import edu.srh.bikehire.login.EntityLoginCredential;
import edu.srh.bikehire.login.EntityRegistrationCredential;
import edu.srh.bikehire.login.Login;
import edu.srh.bikehire.login.ResetPasswordValidator;

public class DBBasedLogin implements Login {

	public Entity authenticate(EntityLoginCredential pInputEntityCredentials) throws BikeHireSystemException {
		
		CustomerCredentialValidator lLoginCredentialValidator = new CustomerCredentialValidator(pInputEntityCredentials);
		lLoginCredentialValidator.validateLoginCredentials();
		//If correct password, fetch entity object and return it
		//TODO: Fetch entity object and return
		
		// Client should maintain User Sessions
		return null;
	}

	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress) {
		// Validate whether user email address exists 
		// Initialize resetpassword validator
		//send email notification for security code
		//return ResetPasswordValidator
		return null;
	}

	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential) {
		//Validate entity details
		//Validate entity credentials
		//insert data into DB
		//Intialize resetpassword validator for email verification
		//send email notification for security code
		//return ResetPasswordValidator
		return null;
	}
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential)
	{
		//Check EntityRegistrationCredentials
		//validate 
	}
	
	public boolean logout(Entity pEntity) {
		// Ideally One who manages session should terminate session.
		return false;
	}

}
