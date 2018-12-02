package edu.srh.bikehire.login;

import edu.srh.bikehire.exception.BikeHireSystemException;

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
