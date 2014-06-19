package com.moshx.jvmsample;

import java.io.File;

import com.moshx.ilog.ILog;
import com.moshx.ilog.filelogger.TextFileLogger;

public class Main {

	public static void main(String[] args) {

		// HtmlFileLogger htmlFileLogger = new HtmlFileLogger();
		// htmlFileLogger.createLogFile(new File(
		// "/Users/appleapple/Documents/test/logging"));

		TextFileLogger logger = new TextFileLogger();
		logger.createLogFile(new File(
				"/Users/appleapple/Documents/test/logging"));

		ILog iLog = new ILog();
		iLog.setFileLogger(logger);

		iLog.getSettings().setFileLogging(true);

		iLog.i();
		iLog.v();
		iLog.w();
		StringBuilder b = new StringBuilder(5000);
		while (b.length() < 5000) {
			b.append("helllllllloooooooo helllllllloooooooo helllllllloooooooo helllllllloooooooo helllllllloooooooo\n");
		}

		iLog.e(b);

	}

}
