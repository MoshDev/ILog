package com.moshx.ilog.console;

import android.util.Log;

import com.moshx.ilog.Settings;

class AndroidLogger extends ILogLogger {

	private Settings mSettings;

	public AndroidLogger(Settings sts) {
		mSettings = sts;
	}

	@Override
	public void d(String tag, Object msg, Throwable err) {

		String msgStr = msg != null ? msg.toString() : "";

		if (msgStr.length() > 4000 && mSettings.isWrapText()) {
			String[] arrs = splitStringByLimit(msgStr, 4000);
			for (String s : arrs) {
				Log.d(tag, s);
			}
			if (err != null) {
				Log.d(tag, "", err);
			}
		} else {
			Log.d(tag, msgStr, err);
		}
	}

	@Override
	public void e(String tag, Object msg, Throwable err) {
		String msgStr = msg != null ? msg.toString() : "";

		if (msgStr.length() > 4000 && mSettings.isWrapText()) {
			String[] arrs = splitStringByLimit(msgStr, 4000);
			for (String s : arrs) {
				Log.e(tag, s);
			}
			if (err != null) {
				Log.e(tag, "", err);
			}
		} else {
			Log.e(tag, msgStr, err);
		}
	}

	@Override
	public void i(String tag, Object msg, Throwable err) {

		String msgStr = msg != null ? msg.toString() : "";

		if (msgStr.length() > 4000 && mSettings.isWrapText()) {
			String[] arrs = splitStringByLimit(msgStr, 4000);
			for (String s : arrs) {
				Log.i(tag, s);
			}
			if (err != null) {
				Log.i(tag, "", err);
			}
		} else {
			Log.i(tag, msgStr, err);
		}
	}

	@Override
	public void v(String tag, Object msg, Throwable err) {

		String msgStr = msg != null ? msg.toString() : "";

		if (msgStr.length() > 4000 && mSettings.isWrapText()) {
			String[] arrs = splitStringByLimit(msgStr, 4000);
			for (String s : arrs) {
				Log.v(tag, s);
			}
			if (err != null) {
				Log.v(tag, "", err);
			}
		} else {
			Log.v(tag, msgStr, err);
		}
	}

	@Override
	public void w(String tag, Object msg, Throwable err) {

		String msgStr = msg != null ? msg.toString() : "";

		if (msgStr.length() > 4000 && mSettings.isWrapText()) {
			String[] arrs = splitStringByLimit(msgStr, 4000);
			for (String s : arrs) {
				Log.w(tag, s);
			}
			if (err != null) {
				Log.w(tag, "", err);
			}
		} else {
			Log.w(tag, msgStr, err);
		}
	}

}
