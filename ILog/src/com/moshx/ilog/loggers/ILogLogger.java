package com.moshx.ilog.loggers;

public abstract class ILogLogger {

	public abstract void d(String tag, Object msg, Throwable err);

	public abstract void e(String tag, Object msg, Throwable err);

	public abstract void i(String tag, Object msg, Throwable err);

	public abstract void v(String tag, Object msg, Throwable err);
	
	public abstract void w(String tag, Object msg, Throwable err);

	public static boolean isNull(Object s) {
		return s == null || s.toString().length() == 0;
	}
}
