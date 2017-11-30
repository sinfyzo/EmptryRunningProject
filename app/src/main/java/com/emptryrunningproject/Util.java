package com.emptryrunningproject;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.format.DateUtils;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_AUDIO;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

public class Util implements WebUtil {

    public static Util util;
    public static Activity mactivity;
    public Timer mTimerTask = new Timer("hello", true);
    public int minute = 0, seconds = 0, hour = 0;
    PermissionListioner permissionListioner;

    public static Util getInstance(Activity activity) {
        mactivity = activity;
        if (util == null)
            util = new Util();
        return util;
    }

    public boolean checkForVaildEmail(String paramString) {
        return paramString
                .matches("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$");
    }

    public void showLog(String mlogvalue) {
        if (BuildConfig.DEBUG) {
            Log.e("showLog...", "..." + mlogvalue);
        }
    }

    public void setErrorValidation(EditText eterror, String mError) {
        eterror.setError(mError);
    }

    public int getDeviceWidth() {
        Display display = mactivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            display.getSize(size);
        } else {
            size.x = 500;
        }
        return size.x;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            mactivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    // call next activity with animation
    public void nextActivity(Intent intent) {

        mactivity.startActivity(intent);
        mactivity.overridePendingTransition(R.anim.slide_in_right,
                R.anim.slide_out_left);
    }

    // call next activity with animation
    public void nextActivityForResult(Intent intent, int requestCode) {

        mactivity.startActivityForResult(intent, requestCode);
        mactivity.overridePendingTransition(R.anim.slide_in_right,
                R.anim.slide_out_left);
    }

    public void redirectHomeActivity() {
        Intent intent = new Intent(mactivity,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        backActivityWithIntent(intent);
    }

    // call back activity with animation
    public void backActivity() {
        mactivity.overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
        mactivity.finish();
            /*       Visibility returnTransition = buildReturnTransition();
                    mactivity.getWindow().setReturnTransition(returnTransition);
                    mactivity.finishAfterTransition();*/
    }

    public void backActivityWithIntent(Intent intent) {
        mactivity.startActivity(intent);
        mactivity.overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);


            /*       Visibility returnTransition = buildReturnTransition();
                    mactivity.getWindow().setReturnTransition(returnTransition);
                    mactivity.finishAfterTransition();*/
    }

    public void showErrorAlertDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(mactivity, R.style.Theme_AppCompat_Light_Dialog_MinWidth).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(mactivity.getResources().getString(R.string.error_ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
       /* alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });*/

        alertDialog.show();
    }

    public void showAlertDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(mactivity, R.style.Theme_AppCompat_Light_Dialog_MinWidth).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(mactivity.getResources().getString(R.string.error_ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
       /* alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });*/

        alertDialog.show();
    }

    public void showAppExitDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(mactivity, R.style.Theme_AppCompat_Light_Dialog_MinWidth).create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        alertDialog.setTitle(title);
        alertDialog.setMessage("Are you sure you want to exit from Datecoy ?");
        alertDialog.setButton(mactivity.getResources().getString(R.string.error_yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mactivity.startActivity(startMain);
                dialog.cancel();
            }
        });
        alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    public void ShowToast(String message) {
        final Toast tag = Toast.makeText(mactivity, message, Toast.LENGTH_LONG);
        tag.show();
       /* new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
                tag.show();
            }

            public void onFinish() {
                tag.show();
            }
        }.start();*/
    }

    public void setValidationError(CoordinatorLayout mCoordinatorLayout, String mErrorMsg) {
        hideSoftKeyboard();
        Snackbar.make(mCoordinatorLayout,
                mErrorMsg, Snackbar.LENGTH_LONG).setAction("CLOSE", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Custom action
            }
        }).show();
    }

    public String getDeviceId() {
        String androidId = Settings.Secure.getString(
                mactivity.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }

    public static int getAge(int _year, int _month, int _day) {

        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, a;

        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(_year, _month, _day);
        a = y - cal.get(Calendar.YEAR);
        if ((m < cal.get(Calendar.MONTH))
                || ((m == cal.get(Calendar.MONTH)) && (d < cal
                .get(Calendar.DAY_OF_MONTH)))) {
            --a;
        }
        /*if(a < 0)
            throw new IllegalArgumentException("Age < 0");*/
        return a;
    }

    public String compressImage(String imageUri) {

        String filePath = imageUri;
        Bitmap scaledBitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();

      /*by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
      you try the use the bitmap here, you will get null.*/
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

        int actualHeight = options.outHeight;
        int actualWidth = options.outWidth;

      /*max Height and width values of the compressed image is taken as 816x612*/
        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

/*      width and height values are set maintaining the aspect ratio of the image*/
        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }
      /*setting inSampleSize value allows to load a scaled down version of the original image*/
        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);
      /*inJustDecodeBounds set to false to load the actual bitmap*/
        options.inJustDecodeBounds = false;
      /*this options allow android to claim the bitmap memory if it runs low on memory*/
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
            bmp = BitmapFactory.decodeFile(filePath, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

      /*check the rotation of the image and display it properly*/
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePath);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
            } else if (orientation == 3) {
                matrix.postRotate(180);
            } else if (orientation == 8) {
                matrix.postRotate(270);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), Const.IMAGE_DIRECTORY_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        return uriSting;

    }

    public long getFileLength(String filePath) {
        File file = new File(filePath);
        long length = file.length();
        length = length / 1024;
        return length;
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }

    public void setProfilePhotos(String mProfilePics, ImageView ivProfile) {
        if (mProfilePics != null) {
            if (mProfilePics.length() > 0) {


                Picasso.with(mactivity).load(mProfilePics).placeholder(AppController.getInstance(mactivity).getDummyThumbImageProfile())
                        .into(ivProfile);
            } else {
                ivProfile.setImageDrawable(AppController.getInstance(mactivity).getDummyThumbImageProfile());
            }
        } else {
            ivProfile.setImageDrawable(AppController.getInstance(mactivity).getDummyThumbImageProfile());
        }
    }

    public void setProfilePhotos(String mProfilePics, ImageView ivProfile, ImageView ivAdd) {
        if (mProfilePics != null) {
            if (mProfilePics.length() > 0) {

                Picasso.with(mactivity).load(mProfilePics).placeholder(AppController.getInstance(mactivity).getDummyThumbImageProfile())
                        .into(ivProfile);
                ivAdd.setVisibility(View.GONE);
            }
        }
    }

    public void setChatProfilePhotos(String mProfilePics, final ImageView ivProfile) {
        if (mProfilePics != null) {
            if (mProfilePics.length() > 0) {
                int[] mScreenSize = setLayoutParams(0.55, 0.30);

                Picasso.with(mactivity).load(mProfilePics).placeholder(AppController.getInstance(mactivity).getDummyThumbImageProfile()).resize(mScreenSize[0], mScreenSize[1]).centerCrop()
                        .into(ivProfile);
            }
        }
    }

    public void setChatSearchPhotos(String mProfilePics, final ImageView ivProfile) {
        if (mProfilePics != null) {
            if (mProfilePics.length() > 0) {
                int[] mScreenSize = setLayoutParams(0.55, 0.30);

                Picasso.with(mactivity).load(mProfilePics).placeholder(AppController.getInstance(mactivity).getDummyThumbImageProfile()).resize(mScreenSize[0], mScreenSize[1]).centerCrop()
                        .into(ivProfile);
            }
        }
    }

    public void setProfilePhotosSearch(String mProfilePics, ImageView ivProfile) {
        if (mProfilePics != null) {
            if (mProfilePics.length() > 0) {

                Picasso.with(mactivity).load(mProfilePics).placeholder(AppController.getInstance(mactivity).getDummyThumbImageProfile())
                        .into(ivProfile);
            } else {
                ivProfile.setImageDrawable(AppController.getInstance(mactivity).getDummyThumbImageProfile());
            }
        } else {
            ivProfile.setImageDrawable(AppController.getInstance(mactivity).getDummyThumbImageProfile());
        }
    }

    public void hideSoftKeyboard() {
        if (mactivity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) mactivity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(mactivity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void hideSoftKeyboardDialog() {
        if (mactivity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) mactivity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }

    public void showSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) mactivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public boolean isImageSizeValid(String uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        return imageHeight >= 512 && imageWidth >= 512;
    }

    public boolean isFileSizeValid(File file, String fileType) {
        boolean valid = false;
        String value = null;
        long Filesize = getFolderSize(file) / 1024;//call function and convert bytes into Kb
        //value = Filesize / 1024 + " Mb";
        value = Filesize + " kb";
        if (fileType.equals("audio")) {
            if (Filesize <= 1024 * 5)
                valid = true;
            else
                valid = false;
        } else if (fileType.equals("video")) {
            if (Filesize <= 1024 * 10)
                valid = true;
            else
                valid = false;
        }
        Util.getInstance(mactivity).showLog("file size..." + value);
        return valid;
    }

    public static long getFolderSize(File f) {
        long size = 0;
        if (f.isDirectory()) {
            for (File file : f.listFiles()) {
                size += getFolderSize(file);
            }
        } else {
            size = f.length();
        }
        return size;
    }

    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     */
    public String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    /**
     * Function to get Progress percentage
     *
     * @param currentDuration
     * @param totalDuration
     */
    public int getProgressPercentage(long currentDuration, long totalDuration) {
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage = (((double) currentSeconds) / totalSeconds) * 100;

        // return percentage
        return percentage.intValue();
    }

    /**
     * Function to change progress to timer
     *
     * @param progress      -
     * @param totalDuration returns current duration in milliseconds
     */
    public int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = totalDuration / 1000;
        currentDuration = (int) ((((double) progress) / 100) * totalDuration);

        // return current duration in milliseconds
        return currentDuration * 1000;
    }


    public void doTimerTask(final TextView hTextView) {
        mTimerTask = new Timer("hello", true);

        mTimerTask.schedule(new TimerTask() {

            @Override
            public void run() {
                hTextView.post(new Runnable() {

                    public void run() {
                        seconds++;
                        if (seconds == 30) {
                            stopTask(hTextView);
                        } else {
                            if (seconds == 60) {
                                seconds = 0;
                                minute++;
                            }
                            if (minute == 60) {
                                minute = 0;
                                hour++;
                            }
                            hTextView.setText("Start Recording...."
                                    + (hour > 9 ? hour : ("0" + hour)) + " : "
                                    + (minute > 9 ? minute : ("0" + minute))
                                    + " : "
                                    + (seconds > 9 ? seconds : "0" + seconds));
                        }


                    }
                });

            }
        }, 1000, 1000);
    }

    public void stopTask(final TextView hTextView) {

        if (mTimerTask != null) {
            hTextView.setText("Stop Recording...."
                    + (hour > 9 ? hour : ("0" + hour)) + " : "
                    + (minute > 9 ? minute : ("0" + minute))
                    + " : "
                    + (seconds > 9 ? seconds : "0" + seconds));

            mTimerTask.cancel();
        }

    }

    public JSONObject basicReuqest(String type) {
        JSONObject params = new JSONObject();
        try {
            params = new JSONObject();
            params.put(KEY_TYPE, type);
            params.put(KEY_UID, PrefsManager.getUid());
            params.put(KEY_UUID, getDeviceId());
        } catch (Exception e) {
            Util.getInstance(mactivity).showLog(e.toString());
        }
        return params;
    }

    public void deleteFile(Uri uri) {
        File fdelete = new File(uri.getPath());
        if (fdelete.exists()) {
            if (fdelete.delete()) {
                System.out.println("file Deleted :" + uri.getPath());
            } else {
                System.out.println("file not Deleted :" + uri.getPath());
            }
        }
    }


    public String getDownloadImagePath(String mPicsUrlPara) {
        String filepath = "";
        try {

            //String encodedString = URLEncoder.De(mPicsUrl, "UTF-8");
            String mPicsUrl = URLDecoder.decode(mPicsUrlPara, "UTF-8");
            Util.getInstance(mactivity).showLog("..FB..URL" + mPicsUrl);
            URL url = new URL(mPicsUrl);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            File SDCardRoot = Environment.getExternalStorageDirectory().getAbsoluteFile();
            String filename = "downloadedFile.png";
            Log.i("Local filename:", "" + filename);
            File file = new File(SDCardRoot, filename);
            if (file.createNewFile()) {
                file.createNewFile();
            }
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            int totalSize = urlConnection.getContentLength();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                Log.i("Progress:", "downloadedSize:" + downloadedSize + "totalSize:" + totalSize);
            }
            fileOutput.close();
            if (downloadedSize == totalSize) filepath = file.getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            filepath = null;
            e.printStackTrace();
        }
        Log.i("filepath:", " " + filepath);
        return filepath;
    }

    /*public void saveUserData(JSONObject user) {
        try {
            PrefsManager.setUserJson(user.toString());
            if (user.has(KEY_FNAME)) {
                String name = user.getString(KEY_FNAME);
                String fname = name.substring(0, 1).toUpperCase() + name.substring(1);
                PrefsManager.setFirstName(fname);
                PrefsManager.setUserName(fname);
            }
            if (user.has(KEY_LANME)) {
                String name = user.getString(KEY_LANME);
                if (name.length() > 0) {
                    String lname = name.substring(0, 1).toUpperCase() + name.substring(1);
                    PrefsManager.setLastName(lname);
                    PrefsManager.setUserName(PrefsManager.getFirstName() + " " + lname);
                }
            }
            if (user.has(KEY_GENDER)) {
                PrefsManager.setGender(user.getString(KEY_GENDER));
            }

            if (user.has(KEY_PROFILEPICS)) {
                JSONArray jProfile = new JSONArray(user.getString(KEY_PROFILEPICS));
                if (jProfile.length() > 0) {
                    JSONObject jLarge = jProfile.getJSONObject(0);
                    PrefsManager.setProfileImage(jLarge.getString(KEY_LARGE));
                }
            }
            if (user.has(KEY_DOB)) {
                PrefsManager.setBirthDate(user.getString(KEY_DOB));
            }
            if (user.has(KEY_AGE)) {//Set default Filter range for Age
                PrefsManager.setAge(user.getInt(KEY_AGE));
                setAgeFilterDefault();
            }
            if (user.has(KEY_MOBILE)) {
                PrefsManager.setUserMobile(user.getString(KEY_MOBILE));
            }
            if (user.has(KEY_EMAIL)) {
                PrefsManager.setUserEmail(user.getString(KEY_EMAIL));
            }
            if (user.has(KEY_CITY)) {
                PrefsManager.setUserCity(user.getString(KEY_CITY));
            }
            if (user.has(KEY_IS_ORIENTATION)) {
                PrefsManager.setIsOrientation(user.getBoolean(KEY_IS_ORIENTATION));
            }
            if (user.has(KEY_IS_PROFILE)) {
                PrefsManager.setIsProfile(user.getBoolean(KEY_IS_PROFILE));
            }
            if (user.has(KEY_JWTOKEN)) {
                PrefsManager.setAccessTokenLogin(user.getString(KEY_JWTOKEN));
            }

            //TODO: Calculate profile completion percentage
            int filledFieldcount = 0;
            if (user.has(KEY_PROFILEPICS))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_PROFILE_AUDIO))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_PROFILE_VIDEO))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_TAGLINE))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_ABOUTME))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_IDEAL_DATE))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_INTERESTS))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_OCCUPATION))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_HEIGHT))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_HAIRCOLOR))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_WEIGHT))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_SUNSIGN))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_COMPLEXION))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_DIET))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_BODYTYPE))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_SMOKING))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_EYECOLOR))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_DRINKING))
                filledFieldcount = filledFieldcount + 1;
            if (user.has(KEY_KNOWNLANGUAGE))
                filledFieldcount = filledFieldcount + 1;

            PrefsManager.setProfileProgress((100 * filledFieldcount) / Const.totalProfileField);
        } catch (Exception e) {

        }

    }*/

    public static String setFirstLatterCaps(String name) {
        if (name != null && !name.isEmpty() && name.trim().length() != 0) {
            String menuname = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            return menuname;
        } else {
            return "";
        }
    }


    public String removelastchar(String str) {
        if (str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static File getMediaStoragePath() {
        File mediaStorageDir = new File(
                Environment.getExternalStorageDirectory().getPath(),
                Const.IMAGE_DIRECTORY_NAME);
        /*File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Const.IMAGE_DIRECTORY_NAME);*/
        return mediaStorageDir;
    }

    public static File getOutputMediaFile() {

        // External sdcard location
        File mediaStorageDir = getMediaStoragePath();

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(Const.IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + Const.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");
        return mediaFile;
    }

    public static File getMediaStoragePath(int type) {
        File mediaStorageDir = null;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory().getPath(),
                    Const.IMAGE_DIRECTORY_NAME);
        } else if (type == MEDIA_TYPE_AUDIO) {
            mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory().getPath(),
                    Const.AUDIO_DIRECTORY_NAME);
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory().getPath(),
                    Const.VIDEO_DIRECTORY_NAME);
        }

        /*File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Const.IMAGE_DIRECTORY_NAME);*/
        return mediaStorageDir;
    }

    public static File getMediaStoragePathForChat(int type) {
        File mediaStorageDir = null;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory().getPath(),
                    Const.CHAT_IMAGE_DIRECTORY_NAME);
        } else if (type == MEDIA_TYPE_AUDIO) {
            mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory().getPath(),
                    Const.CHAT_AUDIO_DIRECTORY_NAME);
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory().getPath(),
                    Const.CHAT_VIDEO_DIRECTORY_NAME);
        }

        /*File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Const.IMAGE_DIRECTORY_NAME);*/
        return mediaStorageDir;
    }

    public static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = getMediaStoragePath(type);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(Const.IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + Const.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile = null;
       /* File mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");*/
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_AUDIO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "AUD_" + timeStamp + ".mp3");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_" + timeStamp + ".mp4");
        }
        return mediaFile;
    }

    public String getFileIfExits(String fileurl, int type) {
        String fileName = fileurl.substring(fileurl.lastIndexOf('/') + 1);
        File directory = getMediaStoragePath(type);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                Log.d(Const.IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + Const.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }
        Util.getInstance(mactivity).showLog("getFileIfExits...." + directory + "..." + fileurl);
        File filePath = new File(directory.getPath() + File.separator + fileName);
        if (filePath.exists()) {
            return filePath.getPath();
        }
        return "";
    }

    public int getImagePath(String shortName) {
        String iconSmallPath = "@drawable/" + shortName;
        int iconSmall = mactivity.getResources().getIdentifier(iconSmallPath, null, mactivity.getPackageName());
//        Util.getInstance(mactivity).showLog("iconSmall..." + iconSmall + "...iconSmallPath.." + iconSmallPath);
        return iconSmall;
    }

       /**
     * Convert UTC time( 1491294020 in Long -- Multiply with 1000 to convert it in to milliseconds) to formatted time 2 hr ago,Yesterday,2 days ago
     * 2 Mar, 4 Apr 2016
     *
     * @param context
     * @param dateStr
     * @return
     */
    public String getFormattedUTCDate(Context context, Object dateStr) {
        String niceDateStr = "";
        try {
            if (dateStr instanceof Long) {
                Date date = new Date((Long) dateStr);
//                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
                String formattedDate = dateFormat.format(date);
                Date date1 = dateFormat.parse(formattedDate);
                CharSequence relavetime1 = DateUtils.getRelativeTimeSpanString(
                        date1.getTime(),
                        System.currentTimeMillis(),
                        DateUtils.SECOND_IN_MILLIS);
                niceDateStr = (String) relavetime1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatingDateShort(niceDateStr);
    }

    /**
     * Format date in 3 characters hours(hr),days(days),seconds(sec),minutes(min),March(Mar),December(Dec)
     *
     * @param str
     * @return
     */
    private String formatingDateShort(String str) {
        String formettedDate = "";
//        Util.getInstance(mactivity).showLog("formatingDateShort..ERROR.."+str);
        if (str.contains("hour")) {
            str = str.replace("hour", "hr");
            formettedDate = str;
        } else if (!str.contains("day") && !str.contains("yesterday")) {
            if (str.contains("minutes")) {
                str = str.replace("minutes", "min");
                formettedDate = str;
            } else if (str.contains("minute")) {
                str = str.replace("minute", "min");
                formettedDate = str;
            } else if (str.contains("seconds")) {
                str = str.replace("seconds", "sec");
                formettedDate = str;
            } else {
                formettedDate = str;
            }
        } else {
            formettedDate = str;
        }
        return formettedDate;
    }

    /*public SpannableStringBuilder getTitleColor(String title) {
        Typeface font2 = Typeface.createFromAsset(mactivity.getAssets(), mactivity.getResources().getString(R.string.fontpath));
        SpannableStringBuilder SS = new SpannableStringBuilder(title);
        SS.setSpan(new CustomTypefaceSpan("", font2), 0, SS.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return SS;
    }*/

    public String getUnixTime(long unixSeconds) {
        Date date = new Date(unixSeconds); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm a"); // the format of your date
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT-4")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        showLog("getUnixTime...."+formattedDate);
        return formattedDate;
    }

    public String getUnixTimeLogin(long unixSeconds) {
//        Date date = new Date(unixSeconds * 1000L);
        Date date = new Date(unixSeconds);// *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm a"); // the format of your date
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT-4")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String getCurrentUnixTime() {
        long unixTime = System.currentTimeMillis();
        String ts = String.valueOf(unixTime);
        return ts;
    }

    /*public TextPaint getShowCaseTitleTextStyle() {
        TextPaint title = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        title.setTextSize(mactivity.getResources().getDimension(R.dimen.abc_text_size_headline_material));
        //title.setUnderlineText(true);
        title.setColor(Color.WHITE);
        title.setFakeBoldText(true);
        title.setTypeface(Typeface.createFromAsset(mactivity.getAssets(), mactivity.getResources().getString(R.string.fontpath)));
        return title;
    }

    public TextPaint getShowCaseContentTextStyle() {
        TextPaint title = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        title.setTextSize(mactivity.getResources().getDimension(R.dimen.abc_text_size_body_1_material));
        //title.setUnderlineText(true);
        title.setColor(Color.WHITE);
        title.setTypeface(Typeface.createFromAsset(mactivity.getAssets(), mactivity.getResources().getString(R.string.fontpath)));
        return title;
    }*/


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = mactivity.getAssets().open("state_city_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public String convertJsonArrayToString(JSONArray jsonArray) {
        StringBuilder builder = new StringBuilder("");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                if (i != 0) {
                    builder.append(", ").append(jsonArray.getString(i));
                } else {
                    builder.append(jsonArray.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String JsonArrayToStringForOptions(JSONArray jsonArray) {
        StringBuilder builder = new StringBuilder("");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                Object obj = jsonArray.get(i);
                if (i != 0) {
                    if (obj instanceof String) {
                        builder.append(",").append((String) obj);
                    } else if (obj instanceof Integer) {
                        builder.append(",").append((Integer) obj);
                    }
                } else {
                    if (obj instanceof String) {
                        builder.append((String) obj);
                    } else if (obj instanceof Integer) {
                        builder.append((Integer) obj);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void setScalingParams(ImageView imageView) {
        float dWidth = getDeviceWidth();
        float dheight = (float) (dWidth * 0.60);

        Matrix matrix = new Matrix();
        RectF rectF = new RectF(0.0f, 0.0f, 300.0f, 300.0f);
        RectF rectF1 = new RectF(0.0f, 0.0f, dWidth, dheight);
        matrix.setRectToRect(rectF, rectF1, Matrix.ScaleToFit.START);
        imageView.setImageMatrix(matrix);
    }

    public void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(mactivity, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth)
                .setCancelable(false)
                .setMessage(message + ".\nGo to Setting")
                .setPositiveButton("OK", okListener)
                //.setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

    public int getImageSize() {
        int density = mactivity.getResources().getDisplayMetrics().densityDpi;

        Display display = mactivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Util.getInstance(mactivity).showLog("get" + size.y);
        int height = size.y;
        int reSize = 0;
        if (height > 2560) {
            reSize = (int) (height * 0.50);
        } else if (height <= 2560 && height > 2000) {
            reSize = (int) (height * 0.50);
        } else if (height <= 2000 && height >= 1280) {
            reSize = (int) (height * 0.50);
        } else if (height < 1280 && height > 900) {
            reSize = (int) (height * 0.45);
        } else if (height < 900 && height > 480) {
            reSize = (int) (height * 0.47);
        } else if (height < 480) {
            reSize = (int) (height * 0.30);
        }
        Util.getInstance(mactivity).showLog("getImageSize..." + reSize);
        return reSize;
    }

    public int[] setLayoutParams(double widthPercentage, double heightPercentage) {
        int[] displayMetrics = new int[2];
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        mactivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        if (widthPercentage != 0) {
            displayMetrics[0] = (int) (mScreenWidth * widthPercentage);
        } else {
            displayMetrics[0] = mScreenWidth;
        }
        if (heightPercentage != 0) {
            displayMetrics[1] = (int) (mScreenHeight * heightPercentage);
        } else {
            displayMetrics[1] = mScreenHeight;
        }

        return displayMetrics;
    }

    public void clearAllNotification() {
        NotificationManager notifManager = (NotificationManager) mactivity.getSystemService(Context.NOTIFICATION_SERVICE);
        notifManager.cancelAll();
    }

    /* TODO Start Multiple Permission Only for API above 22 */
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;

    public void checkPermission(PermissionListioner permissionListionerPara) {
        permissionListioner = permissionListionerPara;
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_FINE_LOCATION))
            permissionsNeeded.add("Access Fine Location");
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_COARSE_LOCATION))
            permissionsNeeded.add("Access Coarse Location");
        if (!addPermission(permissionsList, Manifest.permission.INTERNET))
            permissionsNeeded.add("Internet");
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_NETWORK_STATE))
            permissionsNeeded.add("Access Network State");
        if (!addPermission(permissionsList, Manifest.permission.READ_EXTERNAL_STORAGE))
            permissionsNeeded.add("Read External Storage");
        if (!addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
            permissionsNeeded.add("Write External Storage");
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_WIFI_STATE))
            permissionsNeeded.add("Access Wifi State");
        if (!addPermission(permissionsList, Manifest.permission.RECORD_AUDIO))
            permissionsNeeded.add("Record Audio");
        if (!addPermission(permissionsList, Manifest.permission.CAMERA))
            permissionsNeeded.add("Camera");
        if (!addPermission(permissionsList, Manifest.permission.RECEIVE_SMS))
            permissionsNeeded.add("Receive SMS");
        if (!addPermission(permissionsList, Manifest.permission.READ_SMS))
            permissionsNeeded.add("Read SMS");
        if (!addPermission(permissionsList, Manifest.permission.WAKE_LOCK))
            permissionsNeeded.add("Wake Lock");
        if (!addPermission(permissionsList, Manifest.permission.GET_TASKS))
            permissionsNeeded.add("GetTasks");

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "You need to grant access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);
                Util.getInstance(mactivity).showMessageOKCancel(message,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                permissionListioner.onDailogSuccess();
                                mactivity.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                                dialog.dismiss();
                            }
                        });
                return;
            }
            mactivity.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            return;
        }
        //TODO : Put your code here
        permissionListioner.onSuccess();
    }

    public boolean addPermission(List<String> permissionsList, String permission) {
        if (ContextCompat.checkSelfPermission(mactivity, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!ActivityCompat.shouldShowRequestPermissionRationale(mactivity, permission))
                return false;
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                Map<String, Integer> perms = new HashMap<String, Integer>();

                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.INTERNET, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_NETWORK_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_WIFI_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.RECORD_AUDIO, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.RECEIVE_SMS, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_SMS, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.WAKE_LOCK, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.GET_TASKS, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.ACCESS_WIFI_STATE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.WAKE_LOCK) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.GET_TASKS) == PackageManager.PERMISSION_GRANTED) {
                    // All Permissions Granted
                    //TODO : Put your code here
                    permissionListioner.onSuccess();
                } else {
                    // Permission Denied
                    permissionListioner.onDailogSuccess();
                    checkPermission(permissionListioner);
                    Util.getInstance(mactivity).ShowToast("Some Permission is Denied");
                }
            }
            break;
          /*  default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);*/
        }
    }
 /* TODO End Multiple Permission Only for API above 22 */

    public int dpToPixel(int dp) {
        Resources r = mactivity.getResources();
        int pixels = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
        return pixels;
    }

    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = mactivity.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    public String formatToYesterdayOrToday(long date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date dateTime = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        Calendar today = Calendar.getInstance();
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm aa");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");

        if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
            return "today at " + timeFormatter.format(dateTime);
        } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
            return "yesterday at " + timeFormatter.format(dateTime);
        } else {
            return dateFormatter.format(dateTime);
        }
    }

    public long convertCurrentTimeToUtcTimeZone(boolean isCurrent, long timeMiliSecond) {
        Date myDate = new Date();
        if (!isCurrent) {
            myDate.setTime(timeMiliSecond);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTime(myDate);
        long dateResult = calendar.getTime().getTime();
        showLog("convertUtcToCurrentTimeZone..." + dateResult);
        return dateResult;
    }

    public String convertUtcToCurrentTimeZone(String time, int typeFormate) {
        Date dateTime = new Date();
        dateTime.setTime(Long.parseLong(time));
        SimpleDateFormat outputFmt = null;
        if (typeFormate == 1) {
            outputFmt = new SimpleDateFormat("EEE,d,MMMM", Locale.ENGLISH);
        } else if (typeFormate == 2) {
            outputFmt = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);
        } else if (typeFormate == 3) {
            outputFmt = new SimpleDateFormat("hh:mm aa-EEE, d, MMMM");
        } else if (typeFormate == 4) {
            outputFmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        } else if (typeFormate == 5) {
            outputFmt = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
        } else if (typeFormate == 6) {
            outputFmt = new SimpleDateFormat("EEE,d MMMM", Locale.ENGLISH);
        } else if (typeFormate == 7) {
            outputFmt = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
        }

        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        outputFmt.setTimeZone(tz);
        String dateResult = outputFmt.format(dateTime).replace("a.m.", "AM").replace("p.m.", "PM");

        showLog("convertUtcToCurrentTimeZone..." + dateResult);
        return dateResult;
    }

    public String noDataFound(String data) {
        return "No " + data + " found";
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mactivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mactivity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        mactivity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        int actionBarHeight = mactivity.getResources().getDimensionPixelSize(tv.resourceId);
        return actionBarHeight;
    }

   /* public void showTimeDialog(final String time, final TextView txtTime, final TextView txtEndTime) {
        final Dialog dialog = new Dialog(mactivity, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.activity_mydate_time_dialog);

        final TimePicker tpTime = (TimePicker) dialog.findViewById(R.id.tpTime);
        Button setButton = (Button) dialog.findViewById(R.id.btnSet);
        Button cancelButton = (Button) dialog.findViewById(R.id.btnCancel);
        tpTime.setIs24HourView(false);
        try {
            if (time.length() > 0) {
                SimpleDateFormat format1 = new SimpleDateFormat("hh:mm a");
                Date startDate = format1.parse(time);
                tpTime.setHour(startDate.getHours());
                tpTime.setMinute(startDate.getMinutes());
            } else {
                Calendar c = Calendar.getInstance();
                tpTime.setHour(c.get(Calendar.HOUR_OF_DAY));
                tpTime.setMinute(c.get(Calendar.MINUTE));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        tpTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Util.getInstance(mactivity).showLog("onTimeChanged selected time..." + hourOfDay + ":" + minute);
            }
        });

        // if decline button is clicked, close the custom dialog
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                Util.getInstance(mactivity).showLog("selected time..." + tpTime.getHour() + ":" + tpTime.getMinute());
                txtTime.setText(getTime(tpTime.getHour(), tpTime.getMinute()));
                //TODO:     "Date filter"   Save Start time in milliseconds
                PrefsManager.setDateFilterStartTime(getTime24(tpTime.getHour(), tpTime.getMinute()));
                //set End time default value
                txtEndTime.setText(NO_VALUE);
                PrefsManager.setDateFilterEndTime("");
                dialog.dismiss();
            }
        });
        // if decline button is clicked, close the custom dialog
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();

            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }*/


    public String getTime(int hr, int min) {
        Time tme = new Time(hr, min, 0);//seconds by default set to zero
        Format formatter;
        formatter = new SimpleDateFormat("hh:mm a");
        return formatter.format(tme);
    }

    public String getTime24(int hr, int min) {
        Time tme = new Time(hr, min, 0);//seconds by default set to zero
        Format formatter;
        formatter = new SimpleDateFormat("HH:mm");
        Util.getInstance(mactivity).showLog(formatter.format(tme));
        return formatter.format(tme);
    }

    public Date getTime24ToDate(String time) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        try {
            Util.getInstance(mactivity).showLog(format.parse(time).toString());
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String getReversDate(String date) {
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date date1 = format3.parse(date);
            Util.getInstance(mactivity).showLog("getReversDate..." + format1.format(date1));
            return format1.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public RecyclerView.LayoutManager setLayoutManager(boolean isChat) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mactivity, LinearLayoutManager.VERTICAL, false) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(mactivity) {

                    private static final float SPEED = 300f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }

                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }

        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);
        if (isChat) {
            layoutManager.setStackFromEnd(true);
        }
        return layoutManager;
    }

    public String formatMediaViewCount(long val) {
        final long THOU =                1000L;
        final long MILL =             1000000L;
        final long BILL =          1000000000L;
        final long TRIL =       1000000000000L;
        final long QUAD =    1000000000000000L;
        final long QUIN = 1000000000000000000L;
        if (val < THOU) return Long.toString(val);
        if (val < MILL) return makeDecimal(val, THOU, "k");
        if (val < BILL) return makeDecimal(val, MILL, "m");
        if (val < TRIL) return makeDecimal(val, BILL, "b");
        if (val < QUAD) return makeDecimal(val, TRIL, "t");
        if (val < QUIN) return makeDecimal(val, QUAD, "q");
        return makeDecimal(val, QUIN, "u");
    }
    private String makeDecimal(long val, long div, String sfx) {
        val = val / (div / 10);
        long whole = val / 10;
        long tenths = val % 10;
        if ((tenths == 0) || (whole >= 10))
            return String.format("%d%s", whole, sfx);
        return String.format("%d.%d%s", whole, tenths, sfx);
    }
}
