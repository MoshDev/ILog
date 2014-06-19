package com.moshx.ilog.loggers;

import java.io.PrintStream;

import com.moshx.ilog.Settings;

class JVMLogger extends ILogLogger {

	private static final String DEBUG_STR = "Debug";
	private static final String ERROR_STR = "Error";
	private static final String INFO_STR = "Info";
	private static final String VERBOSE_STR = "Verbose";
	private static final String WARN_STR = "Warning";

	private Settings mSettings;

	public JVMLogger(Settings sts) {
		mSettings = sts;
	}

	@Override
	public void d(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(DEBUG_STR, tag, msg!=null?msg:""));
		printThrowable(err, System.out);
	}

	@Override
	public void e(String tag, Object msg, Throwable err) {
		System.err.println(mSettings.formatOut(ERROR_STR, tag, msg!=null?msg:""));
		printThrowable(err, System.err);

	}

	@Override
	public void i(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(INFO_STR, tag, msg!=null?msg:""));
		printThrowable(err, System.out);
	}

	@Override
	public void v(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(VERBOSE_STR, tag, msg!=null?msg:""));
		printThrowable(err, System.out);
	}

	@Override
	public void w(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(WARN_STR, tag, msg != null ? msg
				: ""));
		printThrowable(err, System.out);
	}

	private void printThrowable(Throwable err, PrintStream out) {
		if (err != null && out != null) {
			err.printStackTrace(out);
		}
	}
}
