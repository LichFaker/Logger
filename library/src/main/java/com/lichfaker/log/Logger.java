package com.lichfaker.log;



/**
 * Android Log Util
 *
 * Thanks to https://github.com/orhanobut/logger
 *
 * @author lichfaker
 */
public class Logger {

    private final static int V = 0x101;
    private final static int I = 0x102;
    private final static int D = 0x103;
    private final static int W = 0x104;
    private final static int E = 0x105;

    // the switch to print the log, default is true
    private static boolean isPrint = true;

    // default tag
    private static String DEFAULT_TAG = "lichfaker";

    // if true, the tag will change automatic according to the class where you invoke
    private static boolean isAutoSetTag = true;

    // print when message is null
    private final static String NULL = "print null object";

    /**
     * Android's max limit for a log entry is ~4076 bytes,
     * so 4000 bytes is used as chunk size since default charset
     * is UTF-8
     */
    private static final int CHUNK_SIZE = 4000;

    /**
     * Drawing toolbox
     */
    private static final char TOP_LEFT_CORNER = '╔';
    private static final char BOTTOM_LEFT_CORNER = '╚';
    private static final char MIDDLE_CORNER = '╟';
    private static final char HORIZONTAL_DOUBLE_LINE = '║';
    private static final String DOUBLE_DIVIDER = "════════════════════════════════════════════";
    private static final String SINGLE_DIVIDER = "────────────────────────────────────────────";
    private static final String TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER;


    public static void setLevel(boolean _isPrint) {
        isPrint = _isPrint;
    }

    public static void setCurrentTag(String tag) {
        if (tag == null || tag.trim().length() == 0) {
            DEFAULT_TAG = "lichfaker";
            return;
        }
        DEFAULT_TAG = tag;
    }

    public static void setIsAutoSetTag(boolean _isAuto) {
        isAutoSetTag = _isAuto;
    }

    private Logger() {
    }

    /**
     * ********************Log with Object format*********************
     */
    public static void i(String msg, Object... args) {
        print(I, msg, null, args);
    }

    public static void v(String msg, Object... args) {
        print(V, msg, null, args);
    }

    public static void d(String msg, Object... args) {
        print(D, msg, null, args);
    }

    public static void w(String msg, Object... args) {
        print(W, msg, null, args);
    }

    public static void e(String msg, Object... args) {
        print(E, msg, null, args);
    }

    /**
     * ******************Log with Object format and throwable*********************
     */
    public static void i(String msg, Throwable tr, Object... args) {
        print(I, msg, tr, args);
    }

    public static void v(String msg, Throwable tr, Object... args) {
        print(V, msg, tr, args);
    }

    public static void d(String msg, Throwable tr, Object... args) {
        print(D, msg, tr, args);
    }

    public static void w(String msg, Throwable tr, Object... args) {
        print(W, msg, tr, args);
    }

    public static void e(String msg, Throwable tr, Object... args) {
        print(E, msg, tr, args);
    }

    private static void print(int type, String msg, Throwable tr, Object... args) {

        if (!isPrint) {
            return;
        }
        String[] contents = wrapperContent();
        String tag = contents[0];
        String headStr = contents[1];
        msg = msg == null ? NULL : msg;
        String message = args.length == 0 ? msg : String.format(msg, args);

        // log top border
        log(tag, type, TOP_BORDER);
        // log head string
        log(tag, type, HORIZONTAL_DOUBLE_LINE + headStr);
        // log mid border
        log(tag, type, MIDDLE_BORDER);
        // log content
        byte[] bytes = message.getBytes();
        int length = bytes.length;
        if (length <= CHUNK_SIZE) {
            logContent(type, tag, message, tr);
        } else {
            for (int i = 0; i < length; i += CHUNK_SIZE) {
                int count = Math.min(length - i, CHUNK_SIZE);
                //create a new String with system's default charset (which is UTF-8 for Android)
                String str = new String(bytes, i , count);
                logContent(type, tag, str, tr);
            }
        }
        // log bottom
        log(tag, type, BOTTOM_BORDER);

    }

    private static String[] wrapperContent() {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index = 5;
        String className = stackTrace[index].getFileName();
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();
        String methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ (").append(className).append(":").append(lineNumber).append(")#").append(methodNameShort).append(" ] ");

        String tag = (isAutoSetTag ? className : DEFAULT_TAG);
        String headString = stringBuilder.toString();

        return new String[]{tag, headString};
    }

    private static void logContent(int type, String tag, String chunk, Throwable tr) {
        String[] lines = chunk.split(System.getProperty("line.separator"));
        for (String line : lines) {
            if (tr == null) {
                log(tag, type, HORIZONTAL_DOUBLE_LINE + " " + line);
            } else {
                log(tag, type, HORIZONTAL_DOUBLE_LINE + " " + line, tr);
            }
        }
    }


    private static void log(String tag, int type, String msg) {
        switch (type) {
            case I:
                LogTool.i(tag, msg);
                break;
            case D:
                LogTool.d(tag, msg);
                break;
            case W:
                LogTool.w(tag, msg);
                break;
            case E:
                LogTool.e(tag, msg);
                break;
            case V:
                LogTool.v(tag, msg);
                break;
            default:
                LogTool.d(tag, msg);
                break;
        }
    }

    private static void log(String tag, int type, String msg, Throwable tr) {
        switch (type) {
            case I:
                LogTool.i(tag, msg, tr);
                break;
            case D:
                LogTool.d(tag, msg, tr);
                break;
            case W:
                LogTool.w(tag, msg, tr);
                break;
            case E:
                LogTool.e(tag, msg, tr);
                break;
            case V:
                LogTool.v(tag, msg, tr);
                break;
            default:
                LogTool.d(tag, msg, tr);
                break;
        }
    }


}
