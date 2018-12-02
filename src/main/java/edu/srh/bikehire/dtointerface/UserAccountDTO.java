package edu.srh.bikehire.dtointerface;

import java.util.Calendar;

public interface UserAccountDTO {

	public String getId();
	public String getUserName();
	public String getRole();
	public String getAccountStatus();
	public Calendar getCreationTimeStamp();
	public Calendar getLastModifiedTimeStamp();
	public void setUserDTO(UserDTO pUserDTO);
}
