package com.emptryrunningproject;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.util.Log;

import org.json.JSONObject;

import java.net.Socket;
import java.util.List;


public class AppController extends Application implements WebUtil {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static AppController mInstance;
    private static Socket mSocket;
    private static Activity mactivity;
//    public SocketListioner socketListioner;
//    public static DBController objDBController;

    public Socket getSocket() {
        return mSocket;
    }

    public static int exclusive_other = 0, status_accept = 0, status_photo_instantselfie = 0, read_status = 0;
//    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        mInstance = this;
        sharedPreferences = initSharedPrefs();
        editor = sharedPreferences.edit();
//        objDBController = new DBController(this);
       /* try {
            mSocket = IO.socket(Const.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }*/
//        if (!isApplicationSentToBackground(getApplicationContext())) {
//        connectSocket();
//        }

    }

   /* public DBController getDatabase() {
        return objDBController;
    }*/

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        /*if (isApplicationSentToBackground(getApplicationContext())){
            Log.e("onDisconnect..." + getClass().getName(), "" + "onTrimMemory...IF");
        }else{
            Log.e("onDisconnect..." + getClass().getName(), "" + "onTrimMemory...ELSE");
        }*/
        if (!PrefsManager.getIsChatScreenVisible()) {
            Log.e("onDisconnect..." + getClass().getName(), "" + "onTrimMemory");
//            disconnectSocket();
        }

    }

    public static synchronized AppController getInstance(Activity mactivityPara) {
        mactivity = mactivityPara;
        return mInstance;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    // TODO Check Application in background or not.
    public boolean isApplicationSentToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }

        }
        return false;
    }

    public static boolean isChatActivityVisible; // Variable that will check the
    // current activity state

    public static boolean isActivityVisible() {
        return isChatActivityVisible; // return true or false
    }

    public static void activityResumed() {
        isChatActivityVisible = true;// this will set true when activity resumed

    }

    public static void activityPaused() {
        isChatActivityVisible = false;// this will set false when activity paused

    }

    // TODO  Start... Get SharedPreferences whenever any class needs
    public SharedPreferences initSharedPrefs() {
        sharedPreferences = getSharedPreferences(Const.SHARED_PREF_FILE, MODE_PRIVATE);
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getSharedPrefsEditor() {
        return editor;
    }

    public static SharedPreferences getSharedPrefs() {
        return sharedPreferences;
    }
    // TODO  End... Get SharedPreferences whenever any class needs
// TODO Display dummy Profile pics
    public Drawable getDummyThumbImageProfile() {
        Drawable drawable = null;
        try {
            JSONObject object = new JSONObject(PrefsManager.getUserJson());
            if (object.has("gender")) {
                if (object.getString("gender").equals("m")) {
                    drawable = getResources().getDrawable(R.drawable.no_photo_boy);
                } else {
                    drawable = getResources().getDrawable(R.drawable.no_photo_girl);
                }
            } else {
                drawable = getResources().getDrawable(R.drawable.no_photo_boy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawable;
    }

}
