package edu.srh.bikehire.login;

import edu.srh.bikehire.exception.BikeHireSystemException;

public interface Login {
	//Login
	//Forgot Password
	//Register
	//LogOut
	public Entity authenticate(EntityLoginCredential pInputEntityCredentials) throws BikeHireSystemException;
	
	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress);
	
	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential);
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential);
	
	public boolean logout(Entity pEntity);
	
}
