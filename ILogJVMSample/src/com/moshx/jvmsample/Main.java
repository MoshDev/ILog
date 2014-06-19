package com.moshx.jvmsample;

import com.moshx.ilog.ILog;
import com.moshx.ilog.ILog.Level;

public class Main {

	public static void main(String[] args) {

		ILog iLog = new ILog();
		
		iLog.getFileLogger().createLogFile("");

		iLog.getSettings().setFileLogging(true);
		iLog.getSettings().setLevels(Level.ERROR, Level.INFO);

		iLog.i();
		iLog.v();
		iLog.w();
		StringBuilder b = new StringBuilder(5000);
		while (b.length() < 5000) {
			b.append("helllllllloooooooohelllllllloooooooohelllllllloooooooohelllllllloooooooohelllllllloooooooo");
		}
		
		iLog.e(b);
	}

}
