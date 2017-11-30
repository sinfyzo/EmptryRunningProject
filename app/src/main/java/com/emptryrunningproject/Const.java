package com.emptryrunningproject;

import android.app.Activity;

public class Const extends Activity {
    public static final String TAG = "GCM Android Example";
    public static final String SMS_ORIGIN = "Demo";
    public static final String IMAGE_DIRECTORY_NAME = "Demo/Images";
    public static final String VIDEO_DIRECTORY_NAME = "Demo/Videos";
    public static final String AUDIO_DIRECTORY_NAME = "Demo/Audios";

    public static final String CHAT_IMAGE_DIRECTORY_NAME = "Demo/Images";
    public static final String CHAT_VIDEO_DIRECTORY_NAME = "Demo/Videos";
    public static final String CHAT_AUDIO_DIRECTORY_NAME = "Demo/Audios";

    //For Shared Preferences keys
    public static final String SHARED_PREF_FILE = "lovecoy";

//   public static final String LIVE = "http://18.220.170.12:80/";
    public static final String APIVERSION = "v1";
    //public static final String APIURL = BuildConfig.WEB_SERVER_URL + APIVERSION + "/";
    public static final String WEB_SERVER_URL = "http://192.168.1.104:9000/";
    public static final String APIURL = WEB_SERVER_URL + APIVERSION + "/";


    // TODO LOGIN, SIGNUP, CHANGE PASSWORD, FORGOT PASSWORD, OTP, OTP RESEND, SIGNOUT FUNCTIONALITY
    public static final String LOGIN = APIURL + "login";
    public static final String USER_VIEW = APIURL + "user/view";
}