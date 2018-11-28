package edu.srh.bikehire.util;

import edu.srh.bikehire.startup.AppInitializer;

public class LoggerUtil {
	
	public static void logInfo(String pMessage)
	{
		AppInitializer.getLoggerInterface().logInfo(pMessage);
	}
	
	public static void logDebug(String pMessage)
	{
		AppInitializer.getLoggerInterface().logDebug(pMessage);
	}
	
	public static void logException(String pMessage, Throwable pThrowable)
	{
		AppInitializer.getLoggerInterface().logException(pMessage, pThrowable);
	}
	
}
