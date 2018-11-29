package edu.srh.bikehire.login.impl;

import java.util.Calendar;

import edu.srh.bikehire.login.Entity;
import edu.srh.bikehire.login.EntityAccount;

public class Customer implements Entity {
	
	//MEMBERS
	
	private String mstrUserId;
	
	private String mstrFirstName;
	
	private String mstrLastName;
	
	private String mstrGender;
	
	private String mstrAddress;
	
	private Calendar mDOB;
	
	private String mstrEmailID;
	
	private String mstrPhoneNumber;
	
	private EntityAccount mEntityAccount;
	
	//GETTER
	public String getUserId() {
		return mstrUserId;
	}

	public String getFirstName() {
		return mstrFirstName;
	}

	public String getLastName() {
		return mstrLastName;
	}

	public String getGender() {
		return mstrGender;
	}

	public String getAddress() {
		return mstrAddress;
	}

	public Calendar getDOB() {
		return mDOB;
	}

	public String getEmailId() {
		return mstrEmailID;
	}

	public String getPhoneNumber() {
		return mstrPhoneNumber;
	}

	public EntityAccount getEntityAccount() {
		return mEntityAccount;
	}
	
	
}
