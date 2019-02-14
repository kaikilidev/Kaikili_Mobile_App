package com.sit.kaikiliService.comman;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public class AppLog {
    public static String http = "http://";

    public static final boolean isDebug = true;

    public static final void Log(String tag, String message) {
        if (isDebug) {

            android.util.Log.e(tag, message + "");
        }
    }

    public static final void handleException(String tag, Exception e) {
        if (isDebug) {
            if (e != null) {
                android.util.Log.d(tag, e.getMessage() + "");
                e.printStackTrace();
            }
        }
    }


}
