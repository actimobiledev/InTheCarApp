package com.inthecarapp.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class LoginDetailsPref {
    public static String ISLOGGEDIN="is_loggedin";
    public static String LOGIN_ID = "log_id";
    public static String USER_ID = "user_id";
    public static String DATE_FORMAT = "dateformat";
    public static String FIREBASE_ID = "firebase_id";

    public static String FIRST_NAME = "first_name";
    public static String LAST_NAME = "last_name";
    public static String PHONE_NO = "phone_no";
    public static String EMAIL = "email";
    public static String SUBSCRIPTION_STATUS = "subscription_status";
    public static String STATUS = "status";
    public static String GROUP_ID = "group_id";
    public static String SESSION_TOKEN = "session_token";
    public static String PLAN_EXIST = "plan_exist";
    public static String USER_IMAGE = "user_image";

    public static String SHOW_DIALOG="show_dialog";



    private static LoginDetailsPref loginDetailsPref;
    private String SFS_DETAILS = "PRIMAL_DETAILS";

    public static LoginDetailsPref getInstance() {
        if (loginDetailsPref == null)
            loginDetailsPref = new LoginDetailsPref();
        return loginDetailsPref;
    }

    private SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(SFS_DETAILS, Context.MODE_PRIVATE);
    }

    public String getStringPref(Context context, String key) {
        return getPref(context).getString(key, "");
    }

    public int getIntPref(Context context, String key) {
        return getPref(context).getInt(key, 0);
    }

    public boolean getBooleanPref(Context context, String key) {
        return getPref(context).getBoolean(key, false);
    }

    public void putBooleanPref(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getPref(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putStringPref(Context context, String key, String value) {
        SharedPreferences.Editor editor = getPref(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putIntPref(Context context, String key, int value) {
        SharedPreferences.Editor editor = getPref(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }
}
