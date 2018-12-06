package edu.srh.bikehire.validator;

import java.util.Calendar;

import edu.srh.bikehire.dto.UserDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class UserValidator {

	private UserDTO mUser;

	public UserValidator(UserDTO pUser) {
		mUser = pUser;

	}

	public void validateAddUser() throws BikeHireSystemException {
		
		if (mUser == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mUser.getFirstName())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);

		}

		if (Util.isEmptyOrNullString(mUser.getLastName())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);

		}

		if (Util.isEmptyOrNullString(mUser.getGender())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);

		}

		validateUserID();
		
		// TODO: Resolve
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int ageLimit = year - mUser.getDob().YEAR;
		if (ageLimit < 95 && ageLimit > 7) {
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mUser.getAddress())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);

		}

		if (Util.isValidEmailAddress(mUser.getEmailId())) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);

		}

		if (Util.isEmptyOrNullString(mUser.getPhoneNo())) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}

		
	}
	
	
	public void validateUserID() throws BikeHireSystemException{
		if(mUser.getId() <= 0)
		{
			//TODO: Resolve
			throw new BikeHireSystemException(-1);
		
		}
	}
}
