package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.EntityLoginCredential;

public class LoginCredential implements EntityLoginCredential {

	private String mstrUserName;
	
	private String mstrPassword;
	
	public String getUserName() {
		return mstrUserName;
	}

	public String getPassword() {
		return mstrPassword;
	}

}
