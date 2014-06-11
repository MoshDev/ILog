package com.moshx.ilog;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FLog {

    private static String TAG = "FLog";
    private static FLog fl = new FLog();
    private BufferedWriter writer;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss",
            Locale.US);

    private static boolean canWrite = false;

    private FLog() {
        if (!canWrite) {
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm", Locale.US);
            File parentFile = Environment.getExternalStorageDirectory();
            parentFile = new File(parentFile, "fallah_log");
            parentFile.mkdirs();
            File logFile = new File(parentFile, "fallah_log_"
                    + dateFormat.format(new Date()) + ".txt");

            logFile.createNewFile();
            Log.e(TAG, "LogFile created " + logFile.getName());
            writer = new BufferedWriter(new FileWriter(logFile));
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }

    public static final void d(String tag, String msg) {
        Log.d(tag, msg);
        if (!canWrite) {
            return;
        }
        try {
            fl.writer.append("DEBUG").append("  ")
                    .append(fl.dateFormat.format(new Date())).append("  ")
                    .append(tag).append("  ").append(msg);
            fl.writer.newLine();
            fl.writer.flush();
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }

    public static final void e(String tag, String msg) {
        Log.e(tag, msg);
        if (!canWrite) {
            return;
        }
        try {
            fl.writer.append("ERROR").append("  ")
                    .append(fl.dateFormat.format(new Date())).append("  ")
                    .append(tag).append("  ").append(msg);
            fl.writer.newLine();
            fl.writer.flush();
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }

    public static final void close() {
        if (!canWrite) {
            return;
        }
        try {
            fl.writer.flush();
            fl.writer.close();
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }
}
