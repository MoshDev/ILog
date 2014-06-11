package com.moshx.ilog.loggers;

import com.moshx.ilog.Settings;

class JVMLogger extends ILogLogger {

	private Settings mSettings;

	public JVMLogger(Settings sts) {
		mSettings = sts;
	}

	@Override
	public void d(String tag, String msg, Throwable err) {
		System.out.println(mSettings.formatOut("debug", tag, msg, ""));
	}

	@Override
	public void e(String tag, String msg, Throwable err) {
		// TODO Auto-generated method stub

	}

	@Override
	public void i(String tag, String msg, Throwable err) {
		// TODO Auto-generated method stub

	}

	@Override
	public void v(String tag, String msg, Throwable err) {
		// TODO Auto-generated method stub

	}

	@Override
	public void w(String tag, String msg, Throwable err) {
		// TODO Auto-generated method stub

	}

}
