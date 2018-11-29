package edu.srh.bikehire.login.impl;

import java.util.Calendar;

import edu.srh.bikehire.login.EntityAccount;

public class CustomerAccount implements EntityAccount {
	//MEMBERS
	
	private String mstrUserId;
	
	private String mstrUserName;
	
	private String mstrUserRole;
	
	private String mstrAccountStatus;
	
	private Calendar mCreationTimeStamp;
	
	private Calendar mLastModifiedTimeStamp;
	
	//GETTER
	
	public String getUserId() {
		return mstrUserId;
	}

	public String getUserName() {
		return mstrUserName;
	}

	public String getUserRole() {
		return mstrUserRole;
	}

	public String getAccountStatus() {
		return mstrAccountStatus;
	}

	public Calendar getCreationTimeStamp() {
		return mCreationTimeStamp;
	}

	public Calendar getLastModifiedTimeStamp() {
		return mLastModifiedTimeStamp;
	}

}
