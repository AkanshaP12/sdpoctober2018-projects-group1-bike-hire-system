package edu.srh.bikehire.login.core;

import java.util.Calendar;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.util.Util;

public class UserDetailsValidator {
	private Entity mEntity;
	
	public UserDetailsValidator(Entity pEntity)
	{
		mEntity = pEntity;
	}
	
	public void validateUserInformationForRegistartion() throws BikeHireSystemException
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
		
		if(!Util.isValidEmailAddress(mEntity.getEmailId()))
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
		
		if(mEntity.getPhoneNumber().length() <= 10)
		{
			//Error_Message: Entity phone number is invalid.
			throw new BikeHireSystemException(10016);
		}
		
		if(mEntity.getDOB() == null)
		{
			//Error_Message : Entity Date of birth is not provided.
			throw new BikeHireSystemException(10015);
		}
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int ageLimit = year - mEntity.getDOB().get(Calendar.YEAR);
		if (ageLimit < 95 && ageLimit > 7) {
			//TODO : Resolve later
			throw new BikeHireSystemException(-1);
		}
		
		if (mEntity.getPhoto() == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if (mEntity.getIdentityProof() == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(mEntity.getEntityAccount() == null) {
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		validateUserAccountInformation();
	}
	
	public void validateUserAccountInformation() throws BikeHireSystemException
	{
		if(Util.isEmptyOrNullString(mEntity.getEntityAccount().getUserName()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getEntityAccount().getUserRole()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		if(Util.isEmptyOrNullString(mEntity.getEntityAccount().getAccountStatus()))
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	}
	
	public void validateUserInformationForDeactiviation() throws BikeHireSystemException
	{
		if(mEntity == null)
		{
			//Error_Message : Entity information not provided.
			throw new BikeHireSystemException(10007);
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
	}
	
}
