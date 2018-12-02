package edu.srh.bikehire.login.impl;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.Entity;
import edu.srh.bikehire.login.EntityRegistrationCredential;
import edu.srh.bikehire.login.util.LoginUtil;
import edu.srh.bikehire.util.Util;

public class AccountRegistrationValidator {

	private Entity mEntity;
	
	private EntityRegistrationCredential mEntityRegistrationCredential;
	
	public AccountRegistrationValidator(Entity pEntity, EntityRegistrationCredential pEntityCredential)
	{
		mEntity = pEntity;
		mEntityRegistrationCredential = pEntityCredential;
	}
	
	public void validateEntityInformation() throws BikeHireSystemException
	{
		if(mEntity == null)
		{
			//Error_Message : Entity information not provided.
			throw new BikeHireSystemException(10007);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getFirstName()))
		{
			//Error_Message : Entity first name is not provided.
			throw new BikeHireSystemException(10008);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getLastName()))
		{
			//Error_Message : Entity last name is not provided.
			throw new BikeHireSystemException(10009);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getEmailId()))
		{
			//Error_Message : Entity email id is not provided.
			throw new BikeHireSystemException(10010);
		}
		
		if(Util.isValidEmailAddress(mEntity.getEmailId()))
		{
			//Error_Message : Entity email id {0} is not valid.
			throw new BikeHireSystemException(10011, new Object[] {mEntity.getEmailId()});
		}
		
		if(Util.isEmptyOrNullString(mEntity.getAddress()))
		{
			//Error_Message : Entity address is not provided.
			throw new BikeHireSystemException(10012);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getGender()))
		{
			//Error_Message : Entity gender is not provided.
			throw new BikeHireSystemException(10013);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getPhoneNumber()))
		{
			//Error_Message : Entity phone number is not provided.
			throw new BikeHireSystemException(10014);
		}
		
		if(mEntity.getPhoneNumber().length() < 10)
		{
			//Error_Message: Entity phone number is invalid.
			throw new BikeHireSystemException(10016);
		}
		
		if(mEntity.getDOB() == null)
		{
			//Error_Message : Entity Date of birth is not provided.
			throw new BikeHireSystemException(10015);
		}
	}
	
	public void validateEntityCredentials() throws BikeHireSystemException
	{
		if(mEntityRegistrationCredential == null)
		{
			//Error_Message : Entity credentials not provided.
			throw new BikeHireSystemException(10017);
		}
		
		if(Util.isEmptyOrNullString(mEntityRegistrationCredential.getUserName()))
		{
			//Error_Message : Entity username is not provided.
			throw new BikeHireSystemException(10018);
		}
		
		if(Util.isEmptyOrNullString(mEntityRegistrationCredential.getNewPassword()))
		{
			//Error_Message : Entity new password is not provided.
			throw new BikeHireSystemException(10019);
		}
		
		if(Util.isEmptyOrNullString(mEntityRegistrationCredential.getConfirmPassword()))
		{
			//Error_Message : Entity confirm password is not provided.
			throw new BikeHireSystemException(10020);
		}
		
		if(!mEntityRegistrationCredential.getNewPassword().equals(mEntityRegistrationCredential.getConfirmPassword()))
		{
			//Error_Message : Password mismatch.
			throw new BikeHireSystemException(10021);
		}
		
		if(!LoginUtil.isValidPassword(mEntityRegistrationCredential.getNewPassword()))
		{
			//Error_Message : Password does not match password criteria.
			throw new BikeHireSystemException(10022);
		}
	}
}
