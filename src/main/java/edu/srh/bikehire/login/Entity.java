package edu.srh.bikehire.login;

import java.util.Calendar;

public interface Entity {
	
	public String getUserId();
	
	public String getFirstName();
	
	public String getLastName();
	
	public String getGender();
	
	public String getAddress();
	
	public Calendar getDOB();
	
	public String getEmailId();
	
	public String getPhoneNumber();
	
	public EntityAccount getEntityAccount();
	
}
