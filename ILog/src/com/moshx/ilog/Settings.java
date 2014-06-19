package com.moshx.ilog;

import com.moshx.ilog.filelogger.FileLogger;

public class Settings {

	public enum Level {

		DEBUG(0x01), INFO(0x02), WARN(0x04), ERROR(0x08), VERBOSE(0x16);

		public final int value;

		Level(int value) {
			this.value = value;

		}
	}

	boolean enabled = true;
	/**
	 * Levels
	 */
	boolean isDebugEnabled = true;
	boolean isInfoEnabled = true;
	boolean isWarnEnabled = true;
	boolean isErrorEnabled = true;
	boolean isVerboseEnabled = true;
	boolean isFileLoggingEnabled = false;
	private boolean isWrapText = true;

	/**
	 * Sets the {@link Level}s that would be logged, only passed levels would be
	 * logged.
	 * 
	 * @param levels
	 *            to be logged
	 */
	public void setLevels(int levels) {

		isDebugEnabled = ((levels & Level.DEBUG.value) == Level.DEBUG.value);
		isInfoEnabled = ((levels & Level.INFO.value) == Level.INFO.value);
		isWarnEnabled = ((levels & Level.WARN.value) == Level.WARN.value);
		isErrorEnabled = ((levels & Level.ERROR.value) == Level.ERROR.value);
		isVerboseEnabled = ((levels & Level.VERBOSE.value) == Level.VERBOSE.value);
	}

	/**
	 * Sets the {@link Level}s that would be logged, only passed levels would be
	 * logged.
	 * 
	 * @param levels
	 *            to be logged
	 */
	public void setLevels(Level... levels) {
		int vals = 0;
		if (levels != null) {
			for (Level l : levels) {
				vals |= l.value;
			}
			setLevels(vals);
		}
	}

	/**
	 * Set the enabled state logging.
	 * 
	 * @param enabled
	 *            True if logging is enabled, false otherwise.
	 */
	public void enableLogging(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLoggingEnabled() {
		return enabled;
	}

	/**
	 * Set the enabled state of the instance of {@link FileLogger} associated
	 * with current instance of {@link ILog}.
	 * 
	 * @param enabled
	 *            True if file logging is enabled, false otherwise.
	 */
	public void setFileLogging(boolean enabled) {
		isFileLoggingEnabled = enabled;
	}

	public boolean isFileLogging() {
		return isFileLoggingEnabled;
	}

	/**
	 * formations
	 */

	private String outFormat = "%s   -%s   %s   %s";

	public void setOutFormat(String format) {
		outFormat = format;
	}

	public String formatOut(Object... in) {
		return String.format(outFormat, in);
	}

	public boolean isWrapText() {
		return isWrapText;
	}

	/**
	 * enabled text wrapping in Android LogCat, if the length of the message
	 * will be more than 4000 characters, it will be split into lines
	 * 
	 * @param isWrapText
	 *            if true text wrapping will be enabled, false otherwise
	 *            (default value is enabled)
	 */
	public void setWrapText(boolean isWrapText) {
		this.isWrapText = isWrapText;
	}
}
