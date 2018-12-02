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

	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress) throws BikeHireSystemException {
		//TODO: Validate whether user with pEmailAddress Exists
		
		// Initialize resetpassword validator
		DBBasedResetPasswordValidator lResetPasswordValidator = new DBBasedResetPasswordValidator(pEmailAddress);
		lResetPasswordValidator.generateToken();

		//send email notification for security code
		lResetPasswordValidator.sendNotfificationForSecurityCode();
		
		return lResetPasswordValidator;
	}

	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException {
		//Validate entity details
		AccountRegistrationValidator lValidator = new AccountRegistrationValidator(pEntity, pEntityCredential);
		lValidator.validateEntityInformation();
		lValidator.validateEntityCredentials();
		
		//TODO: Validate whether username exist in system or not. USERNAME SHOULD NOT EXIST
		
		DBBasedResetPasswordValidator lResetPasswordValidator = new DBBasedResetPasswordValidator(pEntity.getEmailId());
		lResetPasswordValidator.generateToken();

		//send email notification for security code
		lResetPasswordValidator.sendNotfificationForSecurityCode();
		return lResetPasswordValidator;
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
	
	public void deactivateAccount(Entity pEntity) {
		
	}

}
