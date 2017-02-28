package com.blissapp.vyphe.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Shanthakumar on 23-08-2016.
 * Class using Application preference
 */
public class MySharedPreference {

    public static final String PREF_NAME = "officer_pref";
    public static final int MODE = Context.MODE_PRIVATE;
    private static final String TAG = MySharedPreference.class.getCanonicalName();


    /**
     * Method are using to write boolean value to preference
     *
     * @param context
     * @param key
     * @param value
     */
    public static void writeBoolean(Context context, String key, boolean value) {
        try {
            getEditor(context).putBoolean(key, value).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method using to read boolean from preference
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean readBoolean(Context context, String key,
                                      boolean defValue) {
        try {
            return getPreferences(context).getBoolean(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method are using to write int value to preference
     *
     * @param context
     * @param key
     * @param value
     */
    public static void writeInteger(Context context, String key, int value) {
        try {
            getEditor(context).putInt(key, value).commit();
            Log.d(TAG, String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method are using to read int value to preference
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int readInteger(Context context, String key, int defValue) {
        try {
            return getPreferences(context).getInt(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Method are using to write string value to preference
     *
     * @param context
     * @param key
     * @param value
     */
    public static void writeString(Context context, String key, String value) {
        try {
            getEditor(context).putString(key, value).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method are using to read string value to preference
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String readString(Context context, String key, String defValue) {
        try {
            return getPreferences(context).getString(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static SharedPreferences getPreferences(Context context) {
        try {
            return context.getSharedPreferences(PREF_NAME, MODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        try {
            return getPreferences(context).edit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
