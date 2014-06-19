package com.moshx.ilog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utility {

	private static final SimpleDateFormat FILE_DATE_FORMATTER = new SimpleDateFormat(
			"yyyy_MM_dd__HH_mm_ss_SSS", Locale.US);

	protected static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", Locale.US);

	public static String getFormattedDate() {
		return TIME_FORMATTER.format(new Date());
	}

	public static String getFormattedFileDate() {
		return FILE_DATE_FORMATTER.format(new Date());
	}

}
