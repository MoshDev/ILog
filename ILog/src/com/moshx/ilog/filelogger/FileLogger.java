package com.moshx.ilog.filelogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.moshx.ilog.Settings.Level;
import com.moshx.ilog.utils.Utility;

public abstract class FileLogger {

	protected PrintStream printStream;

	public void setLogStream(PrintStream printStream) {
		this.printStream = printStream;
		onStart();
	}

	public FileLogger setLogFile(String path) {
		setLogFile(new File(path));
		return this;
	}

	public File createLogFile(String path) {

		try {
			File f = new File(path);
			f.getParentFile().mkdirs();
			f.createNewFile();
			setLogFile(f);
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			setLogStream(null);
		}
		return null;
	}

	public File createLogFile(String parent, String fileName) {
		try {
			File f = new File(parent, fileName);
			f.getParentFile().mkdirs();
			f.createNewFile();
			setLogFile(f);
			return f;

		} catch (Exception e) {
			e.printStackTrace();
			setLogStream(null);
		}
		return null;
	}

	public File createLogFile(File parentFile, String fileName) {
		return createLogFile(parentFile.getAbsolutePath(), fileName);
	}

	public File createLogFile(File parentFile) {
		try {
			File f = new File(parentFile, generateLogFileName()
					+ getFileExtension());
			f.getParentFile().mkdirs();
			f.createNewFile();
			setLogFile(f);
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			setLogStream(null);
		}

		return null;
	}

	public File setLogFile(File file) {
		if (file != null && file.exists() && file.canWrite()) {
			try {
				PrintStream stream = new PrintStream(
						new FileOutputStream(file), true);
				setLogStream(stream);
				return file;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				setLogStream(null);
			}

		} else {
			setLogStream(null);
		}

		return null;
	}

	public void onStart() {
		if (printStream == null) {
			return;
		}
		printStream.append("Logging Started on "
				+ Utility.getFormattedDate().concat("\n\n"));
	}

	public abstract boolean log(Level level, String tag, Object msg,
			Throwable err);

	public void onEnd() {
		if (printStream == null) {
			return;
		}
		printStream.append("\nLogging Ended on "
				+ Utility.getFormattedDate().concat("\n"));
	}

	public static String generateLogFileName() {
		return "ILog_" + Utility.getFormattedFileDate();
	}

	protected String getFileExtension() {
		return ".log";
	}

}
