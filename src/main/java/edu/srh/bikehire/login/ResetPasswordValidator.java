package edu.srh.bikehire.login;

import edu.srh.bikehire.exception.BikeHireSystemException;

public interface ResetPasswordValidator {
	public void validateToken(String pToken) throws BikeHireSystemException;
}
