package edu.srh.bikehire.exception.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import edu.srh.bikehire.exception.ErrorMessage;

public class ExceptionUtil {
	
	//Error Code Starts @ 10000
	public static Map<Long, ErrorMessage> smapErrorCodesToMessages = null;
	static
	{
		smapErrorCodesToMessages = new HashMap<Long, ErrorMessage>();
		
		smapErrorCodesToMessages.put(10001L, new ErrorMessage("Invalid token provided.", "Invalid security code provided."));
		smapErrorCodesToMessages.put(10002L, new ErrorMessage("Maximum allowed attempts reached.", "You have exceeded maximum allowed attempts. Please try after sometime."));
		smapErrorCodesToMessages.put(10003L, new ErrorMessage("Token has expired.", "Your security code has expired. Please request new security code."));
		smapErrorCodesToMessages.put(10004L, new ErrorMessage("Unable to generate password hash.", "Unexpected Error Occured!"));
		smapErrorCodesToMessages.put(10005L, new ErrorMessage("Login credentials not provided.", "Please enter valid login credentials."));
		smapErrorCodesToMessages.put(10006L, new ErrorMessage("Invalid login credentials provided.", "Please enter valid login credentials."));
		
	}
	
	public static String getErrorMessage(long pErrorCode, Object[] pPlaceHolderValues)
	{
		ErrorMessage lErrorMessage = smapErrorCodesToMessages.get(pErrorCode); 
		if(lErrorMessage != null)
		{
			if(pPlaceHolderValues == null)
			{
				return lErrorMessage.getErrorMessage();
			}
			MessageFormat lMessageFormat = new MessageFormat(lErrorMessage.getErrorMessage());
			
			return lMessageFormat.format(pPlaceHolderValues);
		}
		return "Unexpected Error Occured!";
	}
	
	public static String getDisplayMessage(long pErrorCode, Object[] pPlaceHolderValues)
	{
		ErrorMessage lErrorMessage = smapErrorCodesToMessages.get(pErrorCode); 
		if(lErrorMessage != null)
		{
			if(pPlaceHolderValues == null)
			{
				return lErrorMessage.getDisplayMessage();
			}
			MessageFormat lMessageFormat = new MessageFormat(lErrorMessage.getDisplayMessage());
			return lMessageFormat.format(pPlaceHolderValues);
		}
		return "Unexpected Error Occured!";
	}
}
