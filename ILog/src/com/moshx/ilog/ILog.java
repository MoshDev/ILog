package com.moshx.ilog;

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

	private static final String DEFAULT_TAG = "ILog";
	private final Settings mSettings = new Settings();
	private ILogLogger mLogger = LoggerFactory.getNewLogger(mSettings);

	private String mTag;

	private ILog(String tag) {
		mTag = tag;
	}

	public static ILog getInstance() {
		return new ILog(DEFAULT_TAG);
	}

	public static ILog getInstance(String tag) {
		return new ILog(tag);
	}

	public boolean isEnabled() {
		return mSettings.enabled;
	}

	public ILog setEnabled(boolean debug) {
		mSettings.enabled = debug;
		return this;
	}

	public ILog setLevels(int levels) {
		mSettings.setLevels(levels);
		return this;

	}

	public ILog setLevels(Level... levels) {
		mSettings.setLevels(levels);
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

	// /Debug
	public ILog d(String msg) {
		return d(mTag, msg, null);
	}

	public ILog d(String tag, String msg) {
		return d(tag, msg, null);
	}

	public ILog d(Throwable err) {
		return d(mTag, null, err);
	}

	public ILog d(String msg, Throwable err) {
		return d(mTag, msg, err);
	}

	public ILog d(String tag, String msg, Throwable err) {
		if (mSettings.enabled && mSettings.isDebugEnabled) {
			mLogger.d(tag, msg, err);
		}
		return this;
	}

	// Info

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
		}
		return this;
	}

	// Verbose

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
		}
		return this;
	}

	// Error

	public ILog e(String msg) {
		return e(mTag, msg, null);
	}

	public ILog e(String tag, String msg) {
		return e(tag, msg, null);
	}

	public ILog e(Throwable err) {
		return e(mTag, null, err);
	}

	public ILog e(String msg, Throwable err) {
		return e(mTag, msg, err);
	}

	public ILog e(String tag, String msg, Throwable err) {
		if (mSettings.enabled && mSettings.isErrorEnabled) {
			mLogger.e(tag, msg, err);
		}
		return this;
	}

	// Warn

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
		}
		return this;
	}

}
