package com.moshx.ilog.loggers;

import java.util.Locale;

import com.moshx.ilog.Settings;

public class LoggerFactory {

	static boolean isAndroidVM = false;
	static {
		String vendor = System.getProperty("java.vm.vendor");
		isAndroidVM = (vendor.toLowerCase(Locale.US).contains("android"));
	}

	public static ILogLogger getNewLogger(Settings sts) {
		if (isAndroidVM) {
			return new AndroidLogger(sts);
		} else {
			return new JVMLogger(sts);
		}
	}

}
