package com.moshx.ilog.loggers;

import android.util.Log;

import com.moshx.ilog.Settings;

class AndroidLogger extends ILogLogger {

	public AndroidLogger(Settings sts) {
	}

	@Override
	public void d(String tag, Object msg, Throwable err) {

		if (!isNull(msg) && err != null) {
			Log.d(tag, msg.toString(), err);
		} else if (!isNull(msg) && err == null) {
			Log.d(tag, msg.toString());
		} else if (isNull(msg) && err != null) {
			Log.d(tag, "", err);
		}
	}

	@Override
	public void e(String tag, Object msg, Throwable err) {

		if (!isNull(msg) && err != null) {
			Log.e(tag, msg.toString(), err);
		} else if (!isNull(msg) && err == null) {
			Log.e(tag, msg.toString());
		} else if (isNull(msg) && err != null) {
			Log.e(tag, "", err);
		}
	}

	@Override
	public void i(String tag, Object msg, Throwable err) {

		if (!isNull(msg) && err != null) {
			Log.i(tag, msg.toString(), err);
		} else if (!isNull(msg) && err == null) {
			Log.i(tag, msg.toString());
		} else if (isNull(msg) && err != null) {
			Log.i(tag, "", err);
		}
	}

	@Override
	public void v(String tag, Object msg, Throwable err) {

		if (!isNull(msg) && err != null) {
			Log.v(tag, msg.toString(), err);
		} else if (!isNull(msg) && err == null) {
			Log.v(tag, msg.toString());
		} else if (isNull(msg) && err != null) {
			Log.v(tag, "", err);
		}
	}

	@Override
	public void w(String tag, Object msg, Throwable err) {

		if (!isNull(msg) && err != null) {
			Log.w(tag, msg.toString(), err);
		} else if (!isNull(msg) && err == null) {
			Log.w(tag, msg.toString());
		} else if (isNull(msg) && err != null) {
			Log.w(tag, "", err);
		}
	}

}
