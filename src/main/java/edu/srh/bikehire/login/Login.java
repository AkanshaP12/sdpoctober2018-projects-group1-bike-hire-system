package edu.srh.bikehire.login;

public interface Login {
	//Login
	//Forgot Password
	//Register
	//LogOut
	public Entity authenticate(EntityCredential pInputEntityCredentials);
	
	public ResetPasswordValidator resetPassword(String pEmailAddress);
	
	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityCredential pEntityCredential);
	
	public boolean logout(Entity pEntity);
	
}
