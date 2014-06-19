package com.moshx.ilog.filelogger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Date;

import com.moshx.ilog.Settings.Level;

public class HtmlFileLogger extends FileLogger {

	private String htmlStart1 = "<!DOCTYPE html><html><head>" + "%s</br></br>";
	private String htmlStart2 = "<style>table,th,td	{border:1px solid black;border-collapse:collapse;gravity:center}</style>"
			+ "</head>"
			+ "<body>"
			+ "<table cellpadding=\"10\">"
			+ "<tbody><tr>"
			+ "<th bgcolor=\"#87C2FF\">Level</th>"
			+ "<th bgcolor=\"#87C2FF\">Time</th>"
			+ "<th bgcolor=\"#87C2FF\">Tag</th>"
			+ "<th bgcolor=\"#87C2FF\">Message</th>"
			+ "<th bgcolor=\"#87C2FF\">Error</th>" + "</tr>";

	private String tableRow = "<tr>"
			+ "<td><font color=\"#color\">%s</font></td>"
			+ "<td><font color=\"#color\">%s</font></td>"
			+ "<td><font color=\"#color\">%s</font></td>"
			+ "<td><font color=\"#color\">%s</font></td>"
			+ "<td><font color=\"#color\">%s</font></td>" + "</tr>";

	private String htmlEnd = "</tbody></table>" + "</body></html>";

	@Override
	public void onStart() {
		if (printStream != null) {

			isStarted = true;

			printStream.format(htmlStart1, "Logging Started on:"
					+ TIME_FORMATTER.format(new Date()));
			printStream.append(htmlStart2);

		}
	}

	@Override
	public boolean log(Level level, String tag, Object msg, Throwable err) {
		if (printStream != null) {

			if (!isStarted) {
				onStart();
			}

			String row = String
					.format(tableRow, level.name().charAt(0), TIME_FORMATTER
							.format(new Date()), tag,
							msg != null ? msg.toString() : "",
							getStackTraceString(err));
			switch (level) {
			case DEBUG:
				row = row.replaceAll("#color", "#39379B");
				break;
			case ERROR:
				row = row.replaceAll("#color", "#FA1100");
				break;
			case WARN:
				row = row.replaceAll("#color", "#FB9700");
				break;
			case INFO:
				row = row.replaceAll("#color", "#1B8000");
				break;
			case VERBOSE:
				row = row.replaceAll("#color", "#000000");
				break;
			default:
				break;
			}
			printStream.append(row);

		}
		return false;
	}

	@Override
	public void onEnd() {
		printStream.append(htmlEnd);

	}

	private String getStackTraceString(Throwable tr) {
		if (tr == null) {
			return "";
		}

		// This is to reduce the amount of log spew that apps do in the
		// non-error
		// condition of the network being unavailable.
		Throwable t = tr;
		while (t != null) {
			if (t instanceof UnknownHostException) {
				return "";
			}
			t = t.getCause();
		}

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, false);
		tr.printStackTrace(pw);
		pw.flush();
		return sw.toString().replaceAll("\n", "</br>");
	}

	@Override
	protected String getFileExtension() {
		return ".html";
	}
}
