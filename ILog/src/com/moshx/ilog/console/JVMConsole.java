package com.moshx.ilog.console;

import java.io.PrintStream;

import com.moshx.ilog.Settings;
import com.moshx.ilog.utils.Utility;

class JVMConsole extends ILogConsole {

	private static final String DEBUG_STR = "Debug  ";
	private static final String ERROR_STR = "Error  ";
	private static final String INFO_STR = "Info   ";
	private static final String VERBOSE_STR = "Verbose";
	private static final String WARN_STR = "Warning";

	private Settings mSettings;

	public JVMConsole(Settings sts) {
		mSettings = sts;
	}

	@Override
	public void d(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(Utility.getFormattedDate(),
				DEBUG_STR, tag, msg != null ? msg : ""));
		printThrowable(err, System.out);
	}

	@Override
	public void e(String tag, Object msg, Throwable err) {
		System.err.println(mSettings.formatOut(Utility.getFormattedDate(),
				ERROR_STR, tag, msg != null ? msg : ""));
		printThrowable(err, System.err);

	}

	@Override
	public void i(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(Utility.getFormattedDate(),
				INFO_STR, tag, msg != null ? msg : ""));
		printThrowable(err, System.out);
	}

	@Override
	public void v(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(Utility.getFormattedDate(),
				VERBOSE_STR, tag, msg != null ? msg : ""));
		printThrowable(err, System.out);
	}

	@Override
	public void w(String tag, Object msg, Throwable err) {
		System.out.println(mSettings.formatOut(Utility.getFormattedDate(),
				WARN_STR, tag, msg != null ? msg : ""));
		printThrowable(err, System.out);
	}

	private void printThrowable(Throwable err, PrintStream out) {
		if (err != null && out != null) {
			err.printStackTrace(out);
		}
	}
}
