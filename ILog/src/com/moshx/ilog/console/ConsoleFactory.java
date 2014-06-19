package com.moshx.ilog.console;

import java.util.Locale;

import com.moshx.ilog.Settings;

public class ConsoleFactory {

	static boolean isAndroidVM = false;
	static {
		String vendor = System.getProperty("java.vm.vendor");
		isAndroidVM = (vendor.toLowerCase(Locale.US).contains("android"));
	}

	public static ILogConsole getNewLogger(Settings sts) {
		if (isAndroidVM) {
			return new AndroidConsole(sts);
		} else {
			return new JVMConsole(sts);
		}
	}

}
