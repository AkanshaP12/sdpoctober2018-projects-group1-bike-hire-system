package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.EntityRegistrationCredential;

public class CustomerRegistrationCredential implements EntityRegistrationCredential {
	//MEMBERS

	private String mstrUserName;
	
	private String mstrNewPassword;
	
	private String mstrConfirmPassword;
	
	//GETTERS
	public String getUserName() {
		return mstrUserName;
	}

	public String getNewPassword() {
		return mstrNewPassword;
	}

	public String getConfirmPassword() {
		return mstrConfirmPassword;
	}
	
	
	
}
