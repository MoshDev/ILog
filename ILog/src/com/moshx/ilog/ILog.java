package com.moshx.ilog;

import java.util.Locale;

import com.moshx.ilog.filelogger.FileLogger;
import com.moshx.ilog.filelogger.TextFileLogger;
import com.moshx.ilog.loggers.ILogLogger;
import com.moshx.ilog.loggers.LoggerFactory;

public class ILog {

	public enum Level {

		DEBUG(0x01), INFO(0x02), WARN(0x04), ERROR(0x08), VERBOSE(0x16);

		public final int value;

		Level(int value) {
			this.value = value;

		}
	}

	private final Settings mSettings = new Settings();
	private ILogLogger mLogger = LoggerFactory.getNewLogger(mSettings);
	private FileLogger mFileLogger = new TextFileLogger();

	private String mTag;

	public ILog() {
		this(getCurrentClassName());
	}

	private static String getCurrentClassName() {
		String className = new Exception().getStackTrace()[2].getClassName();
		if (className.contains(".")) {
			className = className.substring(className.lastIndexOf(".") + 1);
		}
		return className;
	}

	public ILog(Object currentClass) {
		this(currentClass.getClass().getSimpleName());
	}

	public ILog(Class<?> c) {
		this(c.getSimpleName());
	}

	public ILog(String tag) {
		mTag = tag;
	}

	public ILog setEnabled(boolean debug) {
		mSettings.enabled = debug;
		return this;
	}

	public ILog setTag(String tag) {
		mTag = tag;
		return this;
	}

	public Settings getSettings() {
		return mSettings;
	}

	/**
	 * Logging
	 */

	public ILog d() {
		return d(mTag, getCurrentStackLine(), null);
	}

	// /Debug
	public ILog d(Object msg) {
		return d(mTag, msg, null);
	}

	public ILog d(String tag, Object msg) {
		return d(tag, msg, null);
	}

	public ILog d(Throwable err) {
		return d(mTag, null, err);
	}

	public ILog d(Object msg, Throwable err) {
		return d(mTag, msg, err);
	}

	public ILog d(String tag, Object msg, Throwable err) {
		if (mSettings.enabled && mSettings.isDebugEnabled) {
			mLogger.d(tag, msg, err);
			if (mSettings.isFileLoggingEnabled) {
				mFileLogger.log(Level.DEBUG, tag, msg, err);
			}
		}
		return this;
	}

	// Info

	public ILog i() {
		return i(mTag, getCurrentStackLine(), null);
	}

	public ILog i(String msg) {
		return i(mTag, msg, null);
	}

	public ILog i(String tag, String msg) {
		return i(tag, msg, null);
	}

	public ILog i(Throwable err) {
		return i(mTag, null, err);
	}

	public ILog i(String msg, Throwable err) {
		return i(mTag, msg, err);
	}

	public ILog i(String tag, String msg, Throwable err) {
		if (mSettings.enabled && mSettings.isInfoEnabled) {
			mLogger.i(tag, msg, err);
			if (mSettings.isFileLoggingEnabled) {
				mFileLogger.log(Level.INFO, tag, msg, err);
			}
		}
		return this;
	}

	// Verbose

	public ILog v() {
		return v(mTag, getCurrentStackLine(), null);
	}

	public ILog v(String msg) {
		return v(mTag, msg, null);
	}

	public ILog v(String tag, String msg) {
		return v(tag, msg, null);
	}

	public ILog v(Throwable err) {
		return v(mTag, null, err);
	}

	public ILog v(String msg, Throwable err) {
		return v(mTag, msg, err);
	}

	public ILog v(String tag, String msg, Throwable err) {
		if (mSettings.enabled && mSettings.isVerboseEnabled) {
			mLogger.v(tag, msg, err);
			if (mSettings.isFileLoggingEnabled) {
				mFileLogger.log(Level.VERBOSE, tag, msg, err);
			}
		}
		return this;
	}

	// Error

	public ILog e() {
		return e(mTag, getCurrentStackLine(), null);
	}

	public ILog e(Object msg) {
		return e(mTag, msg, null);
	}

	public ILog e(String tag, Object msg) {
		return e(tag, msg, null);
	}

	public ILog e(Throwable err) {
		return e(mTag, null, err);
	}

	public ILog e(Object msg, Throwable err) {
		return e(mTag, msg, err);
	}

	public ILog e(String tag, Object msg, Throwable err) {
		if (mSettings.enabled && mSettings.isErrorEnabled) {
			mLogger.e(tag, msg, err);
			if (mSettings.isFileLoggingEnabled) {
				mFileLogger.log(Level.ERROR, tag, msg, err);
			}
		}
		return this;
	}

	// Warn

	public ILog w() {
		return w(mTag, getCurrentStackLine(), null);
	}

	public ILog w(String msg) {
		return w(mTag, msg, null);
	}

	public ILog w(String tag, String msg) {
		return w(tag, msg, null);
	}

	public ILog w(Throwable err) {
		return w(mTag, null, err);
	}

	public ILog w(String msg, Throwable err) {
		return w(mTag, msg, err);
	}

	public ILog w(String tag, String msg, Throwable err) {
		if (mSettings.enabled && mSettings.isWarnEnabled) {
			mLogger.w(tag, msg, err);
			if (mSettings.isFileLoggingEnabled) {
				mFileLogger.log(Level.WARN, tag, msg, err);
			}
		}
		return this;
	}

	private String getCurrentStackLine() {

		StackTraceElement target = new Exception().getStackTrace()[2];

		String msg = String.format(Locale.US, "[%d:%s] %s()",
				target.getLineNumber(), target.getClassName(),
				target.getMethodName());
		return msg;

	}

	public FileLogger getFileLogger() {
		return mFileLogger;
	}

	public ILog setFileLogger(FileLogger fileLogger) {
		if (fileLogger != null) {
			mSettings.setFileLogging(true);
		}
		mFileLogger = fileLogger;
		return this;
	}

	public ILog setFileLogging(boolean b) {
		mSettings.isFileLoggingEnabled = b;
		return this;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("ILog.finalize()");
		;
		super.finalize();
	}

}
