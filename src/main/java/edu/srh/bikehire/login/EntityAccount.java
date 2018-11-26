package edu.srh.bikehire.login;

import java.util.Calendar;

public interface EntityAccount {
	public String getUserId();
	
	public String getUserName();
	
	public String getUserRole();
	
	public String getAccountStatus();
	
	public Calendar getCreationTimeStamp();
	
	public Calendar getLastModifiedTimeStamp();
	
}
