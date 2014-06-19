package com.moshx.jvmsample;

import java.io.File;
import java.net.URL;

import com.moshx.ilog.ILog;
import com.moshx.ilog.filelogger.HtmlFileLogger;

public class LoggingTest {

	public static void main(String[] args) {

		ILog log = new ILog();
		log.d(); // will print current class + method
		log.i("am here"); // will print passed message
		log.e("erro :O");
		log.v();

		log.setFileLogger(new HtmlFileLogger()).getFileLogger()
				.createLogFile(getLoggingFile());
		log.d();
		log.d(1000);
		log.getFileLogger().onEnd();

		new AnotherTestClass().test();

	}

	private static File getLoggingFile() {
		URL location = LoggingTest.class.getProtectionDomain().getCodeSource()
				.getLocation();
		return new File(location.getFile()).getParentFile();
	}

	public static class AnotherTestClass {
		ILog log = new ILog();

		public void test() {

			log.d();
			log.d("here i'am");
		}
	}
}
