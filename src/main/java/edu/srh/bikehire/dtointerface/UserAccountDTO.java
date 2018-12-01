package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface UserAccountDTO {

	public String getiD();
	public String getUserName();
	public String getRole();
	public String getAccountStatus();
	public Calendar getCreationTimeStamp();
	public Calendar getLastModifiedTimeStamp();
	
	
	

}
