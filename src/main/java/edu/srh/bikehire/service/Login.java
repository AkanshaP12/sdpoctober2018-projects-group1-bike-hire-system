package edu.srh.bikehire.service;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.Entity;
import edu.srh.bikehire.login.EntityLoginCredential;
import edu.srh.bikehire.login.EntityRegistrationCredential;
import edu.srh.bikehire.login.ResetPasswordValidator;

public interface Login {
	//Login
	//Forgot Password
	//Register
	//LogOut
	public Entity authenticate(EntityLoginCredential pInputEntityCredentials) throws BikeHireSystemException;
	
	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress) throws BikeHireSystemException;
	
	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException;
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException;
	
	public boolean logout(Entity pEntity);
	
	public void deactivateAccount(Entity pEntity) throws BikeHireSystemException;
	
}
