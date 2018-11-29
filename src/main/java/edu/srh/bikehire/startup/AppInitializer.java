package edu.srh.bikehire.startup;

import edu.srh.bikehire.logger.LoggerInterface;
import edu.srh.bikehire.logger.impl.Log4JLogger;
import edu.srh.bikehire.login.impl.ResetPasswordCache;
import edu.srh.bikehire.login.impl.ResetPasswordCacheCleanup;

public class AppInitializer {
	
	private static ResetPasswordCache sResetPasswordCache = null;
	private static LoggerInterface sLoggerInterface = null;
	private ResetPasswordCacheCleanup mCacheCleanup = null;
	private Thread mResetPasswordCacheCleanupThread = null;
	
	public void initializeApplication()
	{
		sLoggerInterface = new Log4JLogger();
		
		sResetPasswordCache = new ResetPasswordCache();
		sResetPasswordCache.initialize();
		
		mCacheCleanup = new ResetPasswordCacheCleanup(sResetPasswordCache);
		mResetPasswordCacheCleanupThread = new Thread(mCacheCleanup);
		
		
	}
	
	
	public void terminateApplication() throws InterruptedException
	{
		if(mResetPasswordCacheCleanupThread != null && mCacheCleanup != null)
		{
			mCacheCleanup.stopThread();
			mResetPasswordCacheCleanupThread.join();
		}
	}


	public static ResetPasswordCache getResetPasswordCache() {
		return sResetPasswordCache;
	}

	public static LoggerInterface getLoggerInterface() {
		return sLoggerInterface;
	}

	public static void setsLoggerInterface(LoggerInterface sLoggerInterface) {
		AppInitializer.sLoggerInterface = sLoggerInterface;
	}
	
}
