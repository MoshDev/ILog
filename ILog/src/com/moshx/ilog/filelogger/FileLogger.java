package com.moshx.ilog.filelogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.moshx.ilog.Settings.Level;

public abstract class FileLogger {

	protected PrintStream printStream;
	protected boolean isStarted;

	private static final SimpleDateFormat FILE_DATE_FORMATTER = new SimpleDateFormat(
			"yyyy_MM_dd__HH_mm_ss_SSS", Locale.US);

	protected static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", Locale.US);

	public FileLogger setLogStream(PrintStream printStream) {
		reset();
		this.printStream = printStream;
		return this;
	}

	public FileLogger setLogFile(String path) {
		setLogFile(new File(path));
		return this;
	}

	public FileLogger createLogFile(String path) {
		try {
			File f = new File(path);
			f.getParentFile().mkdirs();
			f.createNewFile();
			setLogFile(f);
		} catch (Exception e) {
			e.printStackTrace();
			setLogStream(null);
		}
		return this;
	}

	public FileLogger createLogFile(String parent, String fileName) {
		try {
			File f = new File(parent, fileName);
			f.getParentFile().mkdirs();
			f.createNewFile();
			setLogFile(f);
		} catch (Exception e) {
			e.printStackTrace();
			setLogStream(null);
		}
		return this;
	}

	public FileLogger createLogFile(File parentFile, String fileName) {
		return createLogFile(parentFile.getAbsolutePath(), fileName);
	}

	public FileLogger createLogFile(File parentFile) {
		try {
			File f = new File(parentFile, generateLogFileName()
					+ getFileExtension());
			f.getParentFile().mkdirs();
			f.createNewFile();
			setLogFile(f);
		} catch (Exception e) {
			e.printStackTrace();
			setLogStream(null);
		}

		return this;
	}

	public FileLogger setLogFile(File file) {
		if (file != null && file.exists() && file.canWrite()) {
			try {
				PrintStream stream = new PrintStream(
						new FileOutputStream(file), true);
				setLogStream(stream);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				setLogStream(null);
			}

		} else {
			setLogStream(null);
		}

		return this;
	}

	public void onStart() {
		isStarted = true;
		if (printStream == null) {
			return;
		}
		printStream.append("Logging Started on "
				+ TIME_FORMATTER.format(new Date()).concat("\n\n"));
	}

	public abstract boolean log(Level level, String tag, Object msg,
			Throwable err);

	public void onEnd() {
		if (printStream == null) {
			return;
		}
		printStream.append("\nLogging Ended on "
				+ TIME_FORMATTER.format(new Date()).concat("\n"));
	}

	public static String generateLogFileName() {
		return "ILog_" + FILE_DATE_FORMATTER.format(new Date());
	}

	private void reset() {
		isStarted = false;
	}

	protected String getFileExtension() {
		return ".log";
	}

}
