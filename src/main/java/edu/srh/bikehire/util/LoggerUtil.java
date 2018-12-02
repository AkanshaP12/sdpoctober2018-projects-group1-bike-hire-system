package edu.srh.bikehire.util;

import edu.srh.bikehire.startup.AppInitializer;

public class LoggerUtil {
	
	public static void logInfo(String pRequestId, String pMethodName, String pMessage)
	{
		AppInitializer.getLoggerInterface().logInfo(pRequestId,pMethodName, pMessage);
	}
	
	public static void logDebug(String pRequestId, String pMethodName, String pMessage)
	{
		AppInitializer.getLoggerInterface().logDebug(pRequestId,pMethodName,pMessage);
	}
	
	public static void logException(String pRequestId, String pMethodName, String pMessage, Throwable pThrowable)
	{
		AppInitializer.getLoggerInterface().logException(pRequestId, pMethodName, pMessage, pThrowable);
	}
	
}
