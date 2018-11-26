package edu.srh.bikehire.login;

import java.util.Calendar;

public interface EntityCredential {
	public String getUserName();
	
	public String getPasswordHash();
	
	public String getPasswordSalt();
	
	public Calendar getLastModifiedTimeStamp();
}
