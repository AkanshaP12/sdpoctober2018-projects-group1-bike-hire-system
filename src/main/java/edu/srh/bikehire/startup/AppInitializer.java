package edu.srh.bikehire.startup;

import edu.srh.bikehire.login.impl.ResetPasswordCache;
import edu.srh.bikehire.login.impl.ResetPasswordCacheCleanup;

public class AppInitializer {
	
	private static ResetPasswordCache sResetPasswordCache = null;
	ResetPasswordCacheCleanup mCacheCleanup = null;
	Thread mResetPasswordCacheCleanupThread = null;
	
	public void initializeApplication()
	{
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
	
	
}
