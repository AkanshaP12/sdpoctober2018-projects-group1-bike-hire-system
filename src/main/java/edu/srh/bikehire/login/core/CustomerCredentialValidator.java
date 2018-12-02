package edu.srh.bikehire.login.core;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.EntityLoginCredential;
import edu.srh.bikehire.login.util.PasswordHashGenerator;
import edu.srh.bikehire.util.Util;

public class CustomerCredentialValidator {
	
	//MEMBERS
	EntityLoginCredential mEntityLoginCredential = null;
	
	public CustomerCredentialValidator(EntityLoginCredential pEntityLoginCredential)
	{
		mEntityLoginCredential = pEntityLoginCredential;
	}
	
	public void validateLoginCredentials() throws BikeHireSystemException
	{
		//validate inputs
		validateLoginCredentials();
		//TODO: Call DAO to check whether login username exists in the system

		//If user exists, create hash using salt and validate with input password
		//TODO: Get user's password hash and password salt from database
		String lstrOriginPasswordHash = "";
		String lstrPasswordSalt = "";
		
		boolean lbIsValidPassword = PasswordHashGenerator.verifyPasswordHash(lstrOriginPasswordHash, mEntityLoginCredential.getPassword(), lstrPasswordSalt);
		
		if(lbIsValidPassword)
		{
			//ERROR_MESSAGE : Invalid login credentials provided. Password hash matching failed.
			throw new BikeHireSystemException(10023);
		}
		
	}
	
	private void validateLoginInputs() throws BikeHireSystemException
	{
		if(mEntityLoginCredential == null)
		{
			//Error_Message : Login credentials not provided.
			throw new BikeHireSystemException(10005);
		}
		
		if(Util.isEmptyOrNullString(mEntityLoginCredential.getUserName()) || Util.isEmptyOrNullString(mEntityLoginCredential.getPassword()))
		{
			//Error_Message : Invalid login credentials provided.
			throw new BikeHireSystemException(10006);
		}
	}
	
}
