package edu.srh.bikehire.logger.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.srh.bikehire.logger.LoggerInterface;

public class Log4JLogger implements LoggerInterface {

	private static final Logger LOG = LogManager.getLogger(Log4JLogger.class);

	public void logInfo(String pMessage) {
		LOG.info(pMessage);
	}

	public void logDebug(String pMessage) {
		LOG.debug(pMessage);
	}

	public void logException(String pMessage, Throwable pThrowable) {
		LOG.error(pMessage, pThrowable);
	}

}
