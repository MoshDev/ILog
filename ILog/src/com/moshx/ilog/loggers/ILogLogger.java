package com.moshx.ilog.loggers;

public abstract class ILogLogger {

	public abstract void d(String tag, String msg, Throwable err);

	public abstract void e(String tag, String msg, Throwable err);

	public abstract void i(String tag, String msg, Throwable err);

	public abstract void v(String tag, String msg, Throwable err);
	
	public abstract void w(String tag, String msg, Throwable err);

	public static boolean isEmptyText(String s) {
		return s == null || s.length() == 0;
	}
}
