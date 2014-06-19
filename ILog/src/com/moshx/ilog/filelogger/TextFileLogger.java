package com.moshx.ilog.filelogger;

import java.util.Date;
import java.util.Locale;

import com.moshx.ilog.Settings.Level;

public class TextFileLogger extends FileLogger {

	String logFormat = "[%s]   -%s   %s   %s\n";

	@Override
	public boolean log(Level level, String tag, Object msg, Throwable err) {
		if (printStream == null) {
			return false;
		}

		if (!isStarted) {
			onStart();
		}

		String result = String.format(Locale.US, logFormat,
				TIME_FORMATTER.format(new Date()), level.toString(), tag,
				msg != null ? msg.toString() : "");
		printStream.append(result);
		if (err != null) {
			err.printStackTrace(printStream);
		}
		return true;
	}

}
