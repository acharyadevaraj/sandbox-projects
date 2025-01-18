package com.learning.customlogwriter.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LogWriter {

	private static String symbol = " @@ ";

	private static final Logger LOGGER = LogManager.getLogger(LogWriter.class);

	private LogWriter() {
	}

	public static void info(ModuleName moduleName, Object className, String message) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " INFO " + symbol + message;
		LOGGER.info(msg);
	}
	
	public static void info(ModuleName moduleName, Object className, Object message) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " INFO " + symbol + message;
		LOGGER.info(msg);
	}

	public static void error(ModuleName moduleName, Object className, String message) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " ERROR " + symbol + message;
		LOGGER.error(msg);
	}

	public static void error(ModuleName moduleName, Object className, Throwable exception) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " ERROR " + symbol
				+ exception.getMessage();
		LOGGER.error(msg);
	}

	public static void debug(ModuleName moduleName, Object className, String message) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " ERROR " + symbol + message;
		LOGGER.debug(msg);
	}

	public static void warn(ModuleName moduleName, Object className, String message) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " ERROR " + symbol + message;
		LOGGER.warn(msg);
	}

	public static void trace(ModuleName moduleName, Object className, String message) {
		String msg = moduleName + symbol + className.getClass().getName() + symbol + " ERROR " + symbol + message;
		LOGGER.trace(msg);
	}
}
