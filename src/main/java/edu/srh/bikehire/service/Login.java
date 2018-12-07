package edu.srh.bikehire.service;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.ResetPasswordValidator;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.EntityAccount;
import edu.srh.bikehire.service.core.EntityLoginCredential;
import edu.srh.bikehire.service.core.EntityRegistrationCredential;

public interface Login {
	//Login
	//Forgot Password
	//Register
	//LogOut
	public Entity authenticate(EntityLoginCredential pInputEntityCredentials) throws BikeHireSystemException;
	
	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress) throws BikeHireSystemException;
	
	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException;
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException;
	
	public void deactivateAccount(Entity pEntity) throws BikeHireSystemException;
	
	public EntityAccount getAccountInfo(int pUserId);
	
	public boolean markUserAccountAsActive(int pUserId);
}
