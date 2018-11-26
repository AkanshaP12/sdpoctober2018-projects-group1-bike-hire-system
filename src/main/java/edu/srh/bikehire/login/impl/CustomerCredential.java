package edu.srh.bikehire.login.impl;

import java.util.Calendar;

import edu.srh.bikehire.login.EntityCredential;

public class CustomerCredential implements EntityCredential {
	//MEMBERS
	private String mstrUserName;
	
	private String mstrPasswordHash;
	
	private String mstrPasswordSalt;
	
	private Calendar mLastModifiedTimeStamp;
	
	
	//GETTERS
	public String getUserName() {
		return mstrUserName;
	}

	public String getPasswordHash() {
		return mstrPasswordHash;
	}

	public String getPasswordSalt() {
		return mstrPasswordSalt;
	}

	public Calendar getLastModifiedTimeStamp() {
		return mLastModifiedTimeStamp;
	}
	
}
