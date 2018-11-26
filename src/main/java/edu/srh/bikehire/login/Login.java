package edu.srh.bikehire.login;

public interface Login {
	//Login
	//Forgot Password
	//Register
	//LogOut
	public Entity authenticate(EntityCredential pInputEntityCredentials);
	
	public void resetPassword(String pEmailAddress);
	
	
	
}
