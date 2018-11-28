package edu.srh.bikehire.login;

public interface Login {
	//Login
	//Forgot Password
	//Register
	//LogOut
	public Entity authenticate(EntityLoginCredential pInputEntityCredentials);
	
	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress);
	
	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential);
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential);
	
	public boolean logout(Entity pEntity);
	
}
