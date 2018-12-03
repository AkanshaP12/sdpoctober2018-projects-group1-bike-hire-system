package edu.srh.bikehire.dto;

import java.util.Calendar;

public interface UserDTO {

	
	public String getId();
	public String getFirstName();
	public String getLastName();
	public String getGender();
	public Calendar getDOB();
	public String getAddress();
	public byte[] getPhoto();
	public String getEmailId();
	public String getPhoneNo();
	public byte[] getIdentityProof();

}
