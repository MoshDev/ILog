package com.moshx.ilog;

import java.util.Locale;

import com.moshx.ilog.Settings.Level;
import com.moshx.ilog.console.ILogLogger;
import com.moshx.ilog.console.LoggerFactory;
import com.moshx.ilog.filelogger.FileLogger;
import com.moshx.ilog.filelogger.TextFileLogger;

public class ILog {

	private final Settings mSettings = new Settings();
	private ILogLogger mLogger = LoggerFactory.getNewLogger(mSettings);
	private FileLogger mFileLogger = new TextFileLogger();

	public static final ILog o = new ILog("ILog");

	private String mTag;

	/**
	 * Simple constructor to use, the tag value will be the name of the Class
	 * this constructor called from.
	 */
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

	/**
	 * Constructor to create {@link ILog} instance with specific tag.
	 * 
	 * @param tag
	 *            the tag value
	 */
	public ILog(String tag) {
		mTag = tag;
	}

	/**
	 * Set the enabled state logging.
	 * 
	 * @param enabled
	 *            True if logging is enabled, false otherwise.
	 */
	public ILog enableLogging(boolean enabled) {
		mSettings.enableLogging(enabled);
		return this;
	}

	/**
	 * Set the value of tag
	 * 
	 * @param tag
	 */
	public ILog setTag(String tag) {
		mTag = tag;
		return this;
	}

	/**
	 * Returns the {@link Settings} of this {@link ILog} instance
	 * 
	 * @return Settings
	 */
	public Settings getSettings() {
		return mSettings;
	}

	/**
	 * Logging
	 */

	/**
	 * Send a {@link #DEBUG} log message, the message will be created from
	 * current class and current method
	 */
	public ILog d() {
		return d(mTag, getCurrentStackLine(), null);
	}

	/**
	 * Send a {@link #DEBUG} log message.
	 * 
	 * @param msg
	 *            The object you would like logged.
	 */
	public ILog d(Object msg) {
		return d(mTag, msg, null);
	}

	/**
	 * Send a {@link #DEBUG} log message.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The object you would like logged.
	 */
	public ILog d(String tag, Object msg) {
		return d(tag, msg, null);
	}

	/**
	 * Send a {@link #DEBUG} log exception.
	 * 
	 * @param err
	 *            An exception to log
	 */
	public ILog d(Throwable err) {
		return d(mTag, null, err);
	}

	/**
	 * Send a {@link #DEBUG} log message and log the exception.
	 * 
	 * @param msg
	 *            The Object you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog d(Object msg, Throwable err) {
		return d(mTag, msg, err);
	}

	/**
	 * Send a {@link #DEBUG} log message and log the exception.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The Object you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog d(String tag, Object msg, Throwable err) {
		if (mSettings.enabled && mSettings.isDebugEnabled) {
			mLogger.d(tag, msg, err);
			if (mSettings.isFileLoggingEnabled) {
				mFileLogger.log(Level.DEBUG, tag, msg, err);
			}
		}
		return this;
	}

	/**
	 * Send a {@link #INFO} log message, the message will be created from
	 * current class and current method
	 */
	public ILog i() {
		return i(mTag, getCurrentStackLine(), null);
	}

	/**
	 * Send a {@link #INFO} log message.
	 * 
	 * @param msg
	 *            The Object you would like logged.
	 */
	public ILog i(String msg) {
		return i(mTag, msg, null);
	}

	/**
	 * Send a {@link #INFO} log message.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The Object you would like logged.
	 */
	public ILog i(String tag, String msg) {
		return i(tag, msg, null);
	}

	/**
	 * Send a {@link #INFO} log exception.
	 * 
	 * @param err
	 *            An exception to log
	 */
	public ILog i(Throwable err) {
		return i(mTag, null, err);
	}

	/**
	 * Send a {@link #INFO} log message and log the exception.
	 * 
	 * @param msg
	 *            The Object you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog i(String msg, Throwable err) {
		return i(mTag, msg, err);
	}

	/**
	 * Send a {@link #INFO} log message and log the exception.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The Object you would like logged.
	 * @param err
	 *            An exception to log
	 */
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

	/**
	 * Send a {@link #VERBOSE} log message, the message will be created from
	 * current class and current method.
	 */
	public ILog v() {
		return v(mTag, getCurrentStackLine(), null);
	}

	/**
	 * Send a {@link #VERBOSE} log message.
	 * 
	 * @param msg
	 *            The Object you would like logged.
	 */
	public ILog v(String msg) {
		return v(mTag, msg, null);
	}

	/**
	 * Send a {@link #VERBOSE} log message.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The Object you would like logged.
	 */
	public ILog v(String tag, String msg) {
		return v(tag, msg, null);
	}

	/**
	 * Send a {@link #VERBOSE} log the exception.
	 * 
	 * @param err
	 *            An exception to log
	 */
	public ILog v(Throwable err) {
		return v(mTag, null, err);
	}

	/**
	 * Send a {@link #VERBOSE} log message and log the exception.
	 * 
	 * @param msg
	 *            The Object you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog v(String msg, Throwable err) {
		return v(mTag, msg, err);
	}

	/**
	 * Send a {@link #VERBOSE} log message and log the exception.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The Object you would like logged.
	 * @param err
	 *            An exception to log
	 */
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

	/**
	 * Send a {@link #ERROR} log message, the message will be created from
	 * current class and current method.
	 */
	public ILog e() {
		return e(mTag, getCurrentStackLine(), null);
	}

	/**
	 * Send a {@link #ERROR} log message.
	 * 
	 * @param msg
	 *            The Object you would like logged.
	 */
	public ILog e(Object msg) {
		return e(mTag, msg, null);
	}

	/**
	 * Send a {@link #ERROR} log message.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The message you would like logged.
	 */
	public ILog e(String tag, Object msg) {
		return e(tag, msg, null);
	}

	/**
	 * Send a {@link #ERROR} log exception.
	 * 
	 * @param err
	 *            An exception to log
	 */
	public ILog e(Throwable err) {
		return e(mTag, null, err);
	}

	/**
	 * Send a {@link #ERROR} log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog e(Object msg, Throwable err) {
		return e(mTag, msg, err);
	}

	/**
	 * Send a {@link #ERROR} log message and log the exception.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The object you would like logged.
	 * @param err
	 *            An exception to log
	 */
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
	/**
	 * Send a {@link #WARN} log message, the message will be created from
	 * current class and current method.
	 */
	public ILog w() {
		return w(mTag, getCurrentStackLine(), null);
	}

	/**
	 * Send a {@link #WARN} log message.
	 * 
	 * @param msg
	 *            The object you would like logged.
	 */
	public ILog w(Object msg) {
		return w(mTag, msg, null);
	}

	/**
	 * Send a {@link #WARN} log message.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The message you would like logged.
	 */
	public ILog w(String tag, Object msg) {
		return w(tag, msg, null);
	}

	/**
	 * Send a {@link #WARN} log exception.
	 * 
	 * @param err
	 *            An exception to log
	 */
	public ILog w(Throwable err) {
		return w(mTag, null, err);
	}

	/**
	 * Send a {@link #WARN} log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog w(Object msg, Throwable err) {
		return w(mTag, msg, err);
	}

	/**
	 * Send a {@link #WARN} log message and log the exception.
	 * 
	 * @param tag
	 *            Used to identify the source of a log message. It usually
	 *            identifies the class or activity where the log call occurs.
	 * @param msg
	 *            The message you would like logged.
	 * @param err
	 *            An exception to log
	 */
	public ILog w(String tag, Object msg, Throwable err) {
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

	/**
	 * 
	 * @return current instance of {@link FileLogger}, the default value is
	 *         instance of {@link TextFileLogger}
	 */
	public FileLogger getFileLogger() {
		return mFileLogger;
	}

	/**
	 * associate an instance of {@link FileLogger}, if the instance is not
	 * <code>null</code>, file logging will be enabled
	 * 
	 * @param fileLogger
	 *            the instance of {@link FileLogger}
	 */
	public ILog setFileLogger(FileLogger fileLogger) {
		mSettings.setFileLogging(fileLogger != null);
		mFileLogger = fileLogger;
		return this;
	}

	/**
	 * Set the enabled state of the instance of {@link FileLogger} associated
	 * with current instance of {@link ILog}.
	 * 
	 * @param enabled
	 *            True if file logging is enabled, false otherwise.
	 */
	public ILog setFileLogging(boolean enabled) {
		mSettings.isFileLoggingEnabled = enabled;
		return this;
	}

}
