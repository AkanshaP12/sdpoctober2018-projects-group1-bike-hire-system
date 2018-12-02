package edu.srh.bikehire.validator;

import edu.srh.bikehire.dto.UserCredentialDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class CredentialValidator {

	private UserCredentialDTO mUserCredentail;

	public CredentialValidator(UserCredentialDTO pUserCredentail) {
		mUserCredentail = pUserCredentail;
	}

	public void validateCredential() throws BikeHireSystemException {

		if (mUserCredentail == null) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mUserCredentail.getUserID())) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
		
		validateUserName();

		if (Util.isEmptyOrNullString(mUserCredentail.getPasswordHash())) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mUserCredentail.getPasswordSalt())) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}

	}

	public void validateUserName() throws BikeHireSystemException {
		if (Util.isEmptyOrNullString(mUserCredentail.getUserName())) {
			// TODO: Resolve
			throw new BikeHireSystemException(-1);
		}
	}

}
