package edu.srh.bikehire.login.util;

import java.util.UUID;

public class LoginUtil {
	
	public static String getNewUserID()
	{
		return UUID.randomUUID().toString().replace("-","");
	}
	
}
