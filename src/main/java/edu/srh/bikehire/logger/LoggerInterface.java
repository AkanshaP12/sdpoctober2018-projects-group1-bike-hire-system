package edu.srh.bikehire.logger;

public interface LoggerInterface {
	public void logInfo(String pRequestId, String pMethodName, String pMessage);
	public void logDebug(String pRequestId, String pMethodName, String pMessage);
	public void logException(String pRequestId, String pMethodName, String pMessage, Throwable pThrowable);
}
