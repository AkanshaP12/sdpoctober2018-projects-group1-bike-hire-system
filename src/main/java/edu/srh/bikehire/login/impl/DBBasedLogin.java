package edu.srh.bikehire.login.impl;

import edu.srh.bikehire.login.Entity;
import edu.srh.bikehire.login.EntityCredential;
import edu.srh.bikehire.login.Login;
import edu.srh.bikehire.login.ResetPasswordValidator;

public class DBBasedLogin implements Login {

	public Entity authenticate(EntityCredential pInputEntityCredentials) {
		// Validate User Credentials
		// Return Entity Object from DB
		// Client should maintain User Sessions
		return null;
	}

	public ResetPasswordValidator resetPassword(String pEmailAddress) {
		// Validate whether user email address exists 
		// Initialize resetpassword validator
		//send email notification for security code
		//return ResetPasswordValidator
		return null;
	}

	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityCredential pEntityCredential) {
		//Validate entity details
		//Validate entity credentials
		//insert data into DB
		//Intialize resetpassword validator for email verification
		//send email notification for security code
		//return ResetPasswordValidator
		return null;
	}

	public boolean logout(Entity pEntity) {
		// Ideally One who manages session should terminate session.
		return false;
	}

}
