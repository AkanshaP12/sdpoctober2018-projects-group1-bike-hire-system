package edu.srh.bikehire.login.impl;

import java.util.Calendar;

import edu.srh.bikehire.login.ResetPasswordValidator;

public class DBBasedResetPasswordValidator implements ResetPasswordValidator {
	
	private static final int MAXIMUM_ALLOWED_ATTEMPTS = 5;
	
	private static final int MAXIMUM_ALLOWED_DURATION_IN_SEC = 15*60*60;
	
	private int miAttemptCount = 0;
	
	private String mstrToken;
	
	private Calendar mGenerationTime;
	
	public boolean isValidToken(String pToken) {
		
		
		return false;
	}
	
	public void generateToken()
	{
		mGenerationTime = Calendar.getInstance();
	}
}
