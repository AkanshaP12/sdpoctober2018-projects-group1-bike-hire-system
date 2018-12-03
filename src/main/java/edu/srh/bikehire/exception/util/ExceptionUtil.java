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
		smapErrorCodesToMessages.put(10007L, new ErrorMessage("Entity information not provided.", "Please provide valid information for registration"));
		smapErrorCodesToMessages.put(10008L, new ErrorMessage("Entity first name is not provided.", "Please provide firstname for registration"));
		smapErrorCodesToMessages.put(10009L, new ErrorMessage("Entity last name is not provided.", "Please provide lastname for registration"));
		smapErrorCodesToMessages.put(10010L, new ErrorMessage("Entity email id is not provided.", "Please provide emailid for registration"));
		smapErrorCodesToMessages.put(10011L, new ErrorMessage("Entity email id {0} is not valid.", "Please provide valid emailid for registration"));
		smapErrorCodesToMessages.put(10012L, new ErrorMessage("Entity address is not provided.", "Please provide address for registration"));
		smapErrorCodesToMessages.put(10013L, new ErrorMessage("Entity gender is not provided.", "Please provide gender for registration"));
		smapErrorCodesToMessages.put(10014L, new ErrorMessage("Entity phone number is not provided.", "Please provide phone number for registration"));
		smapErrorCodesToMessages.put(10015L, new ErrorMessage("Entity Date of birth is not provided.", "Please provide date of birth for registration"));
		smapErrorCodesToMessages.put(10016L, new ErrorMessage("Entity phone number is invalid.", "Please provide valid phone number for registration"));
		smapErrorCodesToMessages.put(10017L, new ErrorMessage("Entity credentials not provided.", "Please provide valid username/password for registration"));
		smapErrorCodesToMessages.put(10018L, new ErrorMessage("Entity username is not provided.", "Please provide username for registration"));
		smapErrorCodesToMessages.put(10019L, new ErrorMessage("Entity new password is not provided.", "Please provide new password for registration"));
		smapErrorCodesToMessages.put(10020L, new ErrorMessage("Entity confirm password is not provided.", "Please provide confirm password for registration"));
		smapErrorCodesToMessages.put(10021L, new ErrorMessage("Password mismatch.", "New password and confirm password do not match."));
		smapErrorCodesToMessages.put(10022L, new ErrorMessage("Password does not match password criteria.", "Entered password does not match password criteria."));
		smapErrorCodesToMessages.put(10023L, new ErrorMessage("Invalid login credentials provided. Password hash matching failed.", "Invalid login credentials provided."));
		smapErrorCodesToMessages.put(10024L, new ErrorMessage("Invalid login credentials provided. Username doesn't exists. ", "Invalid login credentials provided."));
		smapErrorCodesToMessages.put(10025L, new ErrorMessage("Invalid email address provided for reset password. ", "Invalid email address provided for reset password."));
		smapErrorCodesToMessages.put(10026L, new ErrorMessage("Invalid email address {0} provided for reset password. ", "Account doesn't exist for email address {0}"));
		smapErrorCodesToMessages.put(10027L, new ErrorMessage("User with email address {0} already exists. ", "User account already exists with emaill address {0}") );
		smapErrorCodesToMessages.put(10028L, new ErrorMessage("User with username {0} already exists. ", "User account already exists with username {0}") );
		 
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
