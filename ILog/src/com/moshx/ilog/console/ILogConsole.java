package com.moshx.ilog.console;

public abstract class ILogConsole {

	public abstract void d(String tag, Object msg, Throwable err);

	public abstract void e(String tag, Object msg, Throwable err);

	public abstract void i(String tag, Object msg, Throwable err);

	public abstract void v(String tag, Object msg, Throwable err);

	public abstract void w(String tag, Object msg, Throwable err);

	protected static boolean isEmpty(Object s) {
		return s == null || s.toString().length() == 0;
	}

	protected static String[] splitStringByLimit(String s, int limit) {
		int length = s.length();
		int count = length / 4000 + (length % 4000 > 0 ? 1 : 0);
		String[] msgs = new String[count];
		int index = 0;
		for (int i = 0; i < msgs.length; i++) {
			int r = index + 4000;
			if (r > length) {
				r = length;
			}
			msgs[i] = s.substring(index, r);
			index += 4000;
		}

		return msgs;
	}
}
