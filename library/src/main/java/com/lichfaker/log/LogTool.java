package com.lichfaker.log;

/**
 * real log used android.util.Log
 *
 * @author lichfaker
 */
public class LogTool {

    public static void i(String tag, String msg) {
        android.util.Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        android.util.Log.d(tag, msg);
    }

    public static void w(String tag, String msg) {
        android.util.Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        android.util.Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        android.util.Log.v(tag, msg);
    }


    public static void i(String tag, String msg, Throwable throwable) {
        android.util.Log.i(tag, msg, throwable);
    }

    public static void d(String tag, String msg, Throwable throwable) {
        android.util.Log.d(tag, msg, throwable);
    }

    public static void w(String tag, String msg, Throwable throwable) {
        android.util.Log.w(tag, msg, throwable);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        android.util.Log.e(tag, msg, throwable);
    }

    public static void v(String tag, String msg, Throwable throwable) {
        android.util.Log.v(tag, msg, throwable);
    }
}
