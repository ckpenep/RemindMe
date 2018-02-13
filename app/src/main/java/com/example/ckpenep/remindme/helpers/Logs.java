package com.example.ckpenep.remindme.helpers;

import android.util.Log;

/**
 * Created by ckpenep on 08.02.2018.
 */

public class Logs {
    private static final String TAG = "RemindMeLogs";
    private static final boolean DEBUG_MODE = true;

    public static void d(String msg) {
        if(DEBUG_MODE) {
            Log.d(TAG, msg);
        }
    }
}
