package edu.srh.bikehire.exception;

public class BikeHireSystemException extends Exception {
	
	private long mlExceptionID;
	
	private long mlUserId;
	
	private String mstrDisplayMessage;
	
	private String mstrErrorMessage;
	
	public BikeHireSystemException(long pExceptionID)
	{
		mlExceptionID = pExceptionID;
	}
	
	public BikeHireSystemException(long pExceptionID, String pErrorMessage)
	{
		mlExceptionID = pExceptionID;
		mstrErrorMessage = pErrorMessage;
	}
	
	
}
