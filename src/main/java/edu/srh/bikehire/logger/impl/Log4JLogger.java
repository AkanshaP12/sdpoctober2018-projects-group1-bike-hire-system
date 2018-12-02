package edu.srh.bikehire.logger.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.srh.bikehire.logger.LoggerInterface;

public class Log4JLogger implements LoggerInterface {

	private static final Logger LOG = LogManager.getLogger(Log4JLogger.class);

	public void logInfo(String pRequestId, String pMethodName, String pMessage) {
		LOG.info(pRequestId + " :: " + pMethodName + " :: " + pMessage);
	} 

	public void logDebug(String pRequestId, String pMethodName, String pMessage) {
		LOG.debug(pRequestId + " :: " + pMethodName + " :: " + pMessage);
	}

	public void logException(String pRequestId, String pMethodName, String pMessage, Throwable pThrowable) {
		LOG.error(pRequestId + " :: " + pMethodName + " :: " + pMessage, pThrowable);
	}

}
