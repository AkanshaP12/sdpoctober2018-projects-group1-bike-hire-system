package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface CredentialsDTO {

	public String getUserID();
	public String getUserName();
	public String getPasswordSalt();
	public String getPasswordHash();
	public Calendar getLastModifiedTimeStamp();	

}
