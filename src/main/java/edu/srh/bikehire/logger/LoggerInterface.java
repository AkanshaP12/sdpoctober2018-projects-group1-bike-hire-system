package edu.srh.bikehire.logger;

public interface LoggerInterface {
	public void logInfo(String pMessage);
	public void logDebug(String pMessage);
	public void logException(String pMessage, Throwable pThrowable);
}
