package com.moshx.jvmsample;

import java.io.File;
import java.net.URL;

import com.moshx.ilog.ILog;

public class Main {

	public static void main(String[] args) {
		
		URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(new File(location.getFile()).getParent());

		// HtmlFileLogger htmlFileLogger = new HtmlFileLogger();
		// htmlFileLogger.createLogFile(new File(
		// "/Users/appleapple/Documents/test/logging"));

//		ILog.o.getFileLogger().createLogFile(new File("/Users/appleapple/Documents/test/logging/mm"));
//
//		ILog.o.setFileLogger(fileLogger)
	}

}
