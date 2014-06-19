package com.moshx.ilog;


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

	public void setLevels(int levels) {

		isDebugEnabled = ((levels & Level.DEBUG.value) == Level.DEBUG.value);
		isInfoEnabled = ((levels & Level.INFO.value) == Level.INFO.value);
		isWarnEnabled = ((levels & Level.WARN.value) == Level.WARN.value);
		isErrorEnabled = ((levels & Level.ERROR.value) == Level.ERROR.value);
		isVerboseEnabled = ((levels & Level.VERBOSE.value) == Level.VERBOSE.value);
	}

	public void setLevels(Level... levels) {
		int vals = 0;
		if (levels != null) {
			for (Level l : levels) {
				vals |= l.value;
			}
			setLevels(vals);
		}
	}

	public void enableLogging(boolean b) {
		enabled = b;
	}

	public boolean isLoggingEnabled() {
		return enabled;
	}

	public void setFileLogging(boolean b) {
		isFileLoggingEnabled = b;
	}

	public boolean isFileLogging() {
		return isFileLoggingEnabled;
	}

	/**
	 * formations
	 */

	private String outFormat = "-%s   %s   %s";

	public void setOutFormat(String format) {
		outFormat = format;
	}

	public String formatOut(Object... in) {
		return String.format(outFormat, in);
	}

	public boolean isWrapText() {
		return isWrapText;
	}

	public void setWrapText(boolean isWrapText) {
		this.isWrapText = isWrapText;
	}
}
