package com.moshx.ilog.loggers;

import com.moshx.ilog.Settings;

import android.util.Log;

class AndroidLogger extends ILogLogger {

	private Settings mSettings;

	public AndroidLogger(Settings sts) {
		mSettings = sts;
	}

	@Override
	public void d(String tag, String msg, Throwable err) {

		if (!isEmptyText(msg) && err != null) {
			Log.d(tag, msg, err);
		} else if (!isEmptyText(msg) && err == null) {
			Log.d(tag, msg);
		} else if (isEmptyText(msg) && err != null) {
			Log.d(tag, "", err);
		}
	}

	@Override
	public void e(String tag, String msg, Throwable err) {

		if (!isEmptyText(msg) && err != null) {
			Log.e(tag, msg, err);
		} else if (!isEmptyText(msg) && err == null) {
			Log.e(tag, msg);
		} else if (isEmptyText(msg) && err != null) {
			Log.e(tag, "", err);
		}
	}

	@Override
	public void i(String tag, String msg, Throwable err) {

		if (!isEmptyText(msg) && err != null) {
			Log.i(tag, msg, err);
		} else if (!isEmptyText(msg) && err == null) {
			Log.i(tag, msg);
		} else if (isEmptyText(msg) && err != null) {
			Log.i(tag, "", err);
		}
	}

	@Override
	public void v(String tag, String msg, Throwable err) {

		if (!isEmptyText(msg) && err != null) {
			Log.v(tag, msg, err);
		} else if (!isEmptyText(msg) && err == null) {
			Log.v(tag, msg);
		} else if (isEmptyText(msg) && err != null) {
			Log.v(tag, "", err);
		}
	}

	@Override
	public void w(String tag, String msg, Throwable err) {

		if (!isEmptyText(msg) && err != null) {
			Log.w(tag, msg, err);
		} else if (!isEmptyText(msg) && err == null) {
			Log.w(tag, msg);
		} else if (isEmptyText(msg) && err != null) {
			Log.w(tag, "", err);
		}
	}

}
