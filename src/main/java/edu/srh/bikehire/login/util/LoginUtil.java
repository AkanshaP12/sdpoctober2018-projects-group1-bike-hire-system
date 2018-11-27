package edu.srh.bikehire.login.util;

import java.util.Random;
import java.util.UUID;

public class LoginUtil {
	
	public static String getNewUserID()
	{
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static String getResetPasswordToken()
	{
		int leftLimitCharacter = 65; // letter 'A'
	    int rightLimitCharacter = 90; // letter 'Z'
	    int leftLimitNumber =  49; //Number 49
	    int rightLimitNumber = 57; //Number 57
	    int targetStringLength = 6;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	    	float lRandomFloat = random.nextFloat();
	    	int randomLimitedInt = 65;
	    	if(lRandomFloat < 0.5f)
	    	{	    		
	    		randomLimitedInt = leftLimitCharacter + (int) 
	    				( lRandomFloat * (rightLimitCharacter - leftLimitCharacter + 1));
	    	}
	    	else
	    	{
	    		randomLimitedInt = leftLimitNumber + (int) 
	    				( lRandomFloat * (rightLimitNumber - leftLimitNumber + 1));
	    	}
	    	
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
	}
	
}
