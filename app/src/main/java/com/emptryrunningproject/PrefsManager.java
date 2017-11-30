package com.emptryrunningproject;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;

import static com.emptryrunningproject.WebUtil.KEY_AGE;
import static com.emptryrunningproject.WebUtil.KEY_CITY;
import static com.emptryrunningproject.WebUtil.KEY_DOB;
import static com.emptryrunningproject.WebUtil.KEY_EMAIL;
import static com.emptryrunningproject.WebUtil.KEY_FBID;
import static com.emptryrunningproject.WebUtil.KEY_GENDER;
import static com.emptryrunningproject.WebUtil.KEY_MOBILE;
import static com.emptryrunningproject.WebUtil.KEY_NAME;
import static com.emptryrunningproject.WebUtil.KEY_USER_IMAGE_URL;
import static com.emptryrunningproject.WebUtil.KEY_UUID;


/**
 * It's used to manage sharedpreference all over the application
 */
public class PrefsManager{

    private static final SharedPreferences sharedPreferences = AppController.getSharedPrefs();
    private static final SharedPreferences.Editor editor = AppController.getSharedPrefsEditor();

    public static final String SP_USER_JSON = "userJson";
    public static final String SP_SETTINGS_JSON = "settingsJson";
    public static final String SP_PREFERENCE_JSON = "preferenceJson";
    public static final String SP_SEARCH_DATA_JSON = "searchDataJson";
    //For Shared Preferences keys
    public static final String SP_ACCESS_TOKEN = "access_token";
    public static final String SP_ACCESS_EXPIRES = "access_expires";
    public static final String SP_LOGIN_TYPE = "loginType";
    public static final String SP_IS_ORIENTATION = "isOrientation";
    public static final String SP_IS_PROPOSAL = "isProposal";
    public static final String SP_IS_CHAT = "isChat";
    public static final String SP_IS_CHATSCREENVISIBLE = "isChatScreenVisible";
    public static final String SP_IS_OTP = "isOtp";
    public static final String SP_IS_PROFILE = "isProfile";
    public static final String SP_PROFILE_IMAGE = KEY_USER_IMAGE_URL;
    public static final String SP_UID = "userId";
    public static final String SP_UUID = KEY_UUID;
    public static final String SP_GSM_TOKEN = "gsmToken";
    public static final String SP_TOP_CARD_ID = "topCardId";
    public static final String SP_DATE_OF_BIRTH = KEY_DOB;
    public static final String SP_USER_NAME = KEY_NAME;
    public static final String SP_FIRST_NAME = "FirstName";
    public static final String SP_LAST_NAME = "LastName";
    public static final String SP_ACCESS_TOKEN_LOGIN = "jwToken";

    public static final String SP_FBID = KEY_FBID;
    public static final String SP_USER_EMAIL = KEY_EMAIL;
    public static final String SP_USER_MOBILE = KEY_MOBILE;
    public static final String SP_USER_CATEGORY = "Category";
    public static final String SP_USER_AGE = KEY_AGE;
    public static final String SP_USER_DOB = KEY_DOB;
    public static final String SP_USER_GENDER = KEY_GENDER;
    public static final String SP_USER_CITY = KEY_CITY;
    public static final String SP_UID_DEFAULT = "0";
    public static final String SP_STRING_DEFAULT = "";
    public static final int SP_INTEGER_DEFAULT = 0;
    public static final int SP_AGE_START_DEFAULT = 18;
    public static final int SP_AGE_END_DEFAULT = 70;
    public static final int SP_HELP_SEEN = 1;
    public static final boolean SP_BOOLEAN_DEFAULT = false;
    public static final String SP_GCM_TOKEN = "fgcmToken";
    public static final String SP_FACEBOOKDATA = "FacebookData";
    public static final String SP_GCM_TOKEN_FLAG = "fgcmTokenFlag";
    public static final String SP_IS_TUTORIAL_SEEN = "isTutorialSeen";

    public static final String SP_HELP_INTERESTED_IN = "interestedIn";
    public static final String SP_HELP_INTERESTED_IN_SUB = "interestedInSub";
    public static final String SP_HELP_INTERESTED_IN_SUB_SAVE = "interestedInSubSave";
    public static final String SP_HELP_STR = "str";
    public static final String SP_HELP_RLM = "rlm";
    public static final String SP_HELP_MY = "my";
    public static final String SP_HELP_WE = "we";
    public static final String SP_HELP_I = "i";
    public static final String SP_HELP_SETTINGS = "setting";
    public static final String SP_HELP_CHAT = "chat";
    public static final String SP_HELP_PAYMENT = "payment";
    public static final String SP_HELP_DATEOMETER = "dateOMeter";
    public static final String SP_HELP_ONLINE_TIME = "onlineTime";

    public static final String SP_FILTER_PROFILE_CITY = "profileCity";
    public static final String SP_FILTER_PROFILE_AGE_START = "profileAgeStart";
    public static final String SP_FILTER_PROFILE_AGE_END = "profileAgeEnd";
    public static final String SP_FILTER_PROFILE_PAYMENT = "profileUnpaidUsers";
    public static final String SP_FILTER_PROFILE_SORT_BY = "profileSortBy";

    public static final String SP_FILTER_DATE_CITY = "dateCity";
    public static final String SP_FILTER_DATE_DATE_TYPE = "dateType";
    public static final String SP_FILTER_DATE_PAID_BY = "datePaidBy";
    public static final String SP_FILTER_DATE_AREA = "dateArea";
    public static final String SP_FILTER_DATE_START_DATE = "dateStartDate";
    public static final String SP_FILTER_DATE_END_DATE = "dateEndDate";
    public static final String SP_FILTER_DATE_START_TIME = "dateStartTime";
    public static final String SP_FILTER_DATE_END_TIME = "dateEndTime";

    public static final String SP_PROFILE_PROGRESS = "profileProgress";

    public static final String SP_OPTIONS_DATE_TYPE = "dateTypeOptions";
    public static final String SP_OPTIONS_PAID_BY = "paidByOptions";
    public static final String SP_OPTIONS_DURATION = "durationOptions";
    public PrefsManager() {
    }

    public static String getProfileImage() {
        return sharedPreferences.getString(SP_PROFILE_IMAGE, "");
    }

    public static void setProfileImage(String profileImage) {
        editor.putString(SP_PROFILE_IMAGE, profileImage);
        editor.commit();
    }

    public static String getLoginType() {
        return sharedPreferences.getString(SP_LOGIN_TYPE, "");
    }

    public static void setLoginType(String loginType) {
        editor.putString(SP_LOGIN_TYPE, loginType);
        editor.commit();
    }

    public static String getAccessToken() {
        return sharedPreferences.getString(SP_ACCESS_TOKEN, null);
    }

    public static void setAccessToken(String access_token) {
        editor.putString(SP_PROFILE_IMAGE, access_token);
        editor.commit();
    }

    public static long getAccessExpires() {
        return sharedPreferences.getLong(SP_ACCESS_TOKEN, 0);
    }

    public static void setAccessExpires(long access_expires) {
        editor.putLong(SP_ACCESS_EXPIRES, access_expires);
        editor.commit();
    }

    public static String getUid() {
        return sharedPreferences.getString(SP_UID, SP_UID_DEFAULT);
    }

    public static void setUid(String uid) {
        editor.putString(SP_UID, uid);
        editor.commit();
    }

    public static String getFBid() {
        return sharedPreferences.getString(SP_FBID, SP_UID_DEFAULT);
    }

    public static void setFBid(String fbid) {
        editor.putString(SP_FBID, fbid);
        editor.commit();
    }

    public static String getUserName() {
        return sharedPreferences.getString(SP_USER_NAME, SP_STRING_DEFAULT);
    }

    public static void setUserName(String name) {
        editor.putString(SP_USER_NAME, name);
        editor.commit();
    }

    public static String getFirstName() {
        return sharedPreferences.getString(SP_FIRST_NAME, SP_STRING_DEFAULT);
    }

    public static void setFirstName(String name) {
        editor.putString(SP_FIRST_NAME, name);
        editor.commit();
    }

    public static String getAccessTokenLogin() {
        return sharedPreferences.getString(SP_ACCESS_TOKEN_LOGIN, SP_STRING_DEFAULT);
    }

    public static void setAccessTokenLogin(String name) {
        editor.putString(SP_ACCESS_TOKEN_LOGIN, name);
        editor.commit();
    }

    public static String getLastName() {
        return sharedPreferences.getString(SP_LAST_NAME, SP_STRING_DEFAULT);
    }

    public static void setLastName(String name) {
        editor.putString(SP_LAST_NAME, name);
        editor.commit();
    }

    public static String getUserEmail() {
        return sharedPreferences.getString(SP_USER_EMAIL, SP_STRING_DEFAULT);
    }

    public static void setUserEmail(String userEmail) {
        editor.putString(SP_USER_EMAIL, userEmail);
        editor.commit();
    }

    public static String getUserMobile() {
        return sharedPreferences.getString(SP_USER_MOBILE, SP_STRING_DEFAULT);
    }

    public static void setUserMobile(String mobile) {
        editor.putString(SP_USER_MOBILE, mobile);
        editor.commit();
    }

    public static String getCategory() {
        return sharedPreferences.getString(SP_USER_CATEGORY, SP_STRING_DEFAULT);
    }

    public static void setCategory(String Category) {
        editor.putString(SP_USER_CATEGORY, Category);
        editor.commit();
    }

    public static String getUserCity() {
        return sharedPreferences.getString(SP_USER_CITY, SP_STRING_DEFAULT);
    }

    public static void setUserCity(String city) {
        editor.putString(SP_USER_CITY, city);
        editor.commit();
    }

    public static boolean getIsOrientation() {
        return sharedPreferences.getBoolean(SP_IS_ORIENTATION, false);
    }

    public static void setIsOrientation(boolean isOrientation) {
        editor.putBoolean(SP_IS_ORIENTATION, isOrientation);
        editor.commit();
    }

    public static boolean getIsProposal() {
        return sharedPreferences.getBoolean(SP_IS_PROPOSAL, false);
    }

    public static void setIsProposal(boolean isOrientation) {
        editor.putBoolean(SP_IS_PROPOSAL, isOrientation);
        editor.commit();
    }

    public static boolean getIsChat() {
        return sharedPreferences.getBoolean(SP_IS_CHAT, false);
    }

    public static void setIsChat(boolean isOrientation) {
        editor.putBoolean(SP_IS_CHAT, isOrientation);
        editor.commit();
    }
    public static boolean getIsChatScreenVisible() {
        return sharedPreferences.getBoolean(SP_IS_CHATSCREENVISIBLE, false);
    }

    public static void setIsChatScreenVisible(boolean isChatScreenVisible) {
        editor.putBoolean(SP_IS_CHATSCREENVISIBLE, isChatScreenVisible);
        editor.commit();
    }
    public static boolean getIsOtp() {
        return sharedPreferences.getBoolean(SP_IS_OTP, false);
    }

    public static void setIsOtp(boolean isOtp) {
        editor.putBoolean(SP_IS_OTP, isOtp);
        editor.commit();
    }

    public static boolean getIsProfile() {
        return sharedPreferences.getBoolean(SP_IS_PROFILE, false);
    }

    public static void setIsProfile(boolean isOrientation) {
        editor.putBoolean(SP_IS_PROFILE, isOrientation);
        editor.commit();
    }


    public static String getBirthDate() {
        return sharedPreferences.getString(SP_USER_DOB, SP_STRING_DEFAULT);
    }

    public static void setBirthDate(String birthDate) {
        editor.putString(SP_USER_DOB, birthDate);
        editor.commit();
    }

    public static int getAge() {
        return sharedPreferences.getInt(SP_USER_AGE, 0);
    }

    public static void setAge(int birthDate) {
        editor.putInt(SP_USER_AGE, birthDate);
        editor.commit();
    }

    public static String getUserJson() {
        return sharedPreferences.getString(SP_USER_JSON, SP_STRING_DEFAULT);
    }

    public static void setUserJson(String userJson) {
        editor.putString(SP_USER_JSON, userJson);
        editor.commit();
    }

    public static String getPreferenceJson() {
        return sharedPreferences.getString(SP_PREFERENCE_JSON, SP_STRING_DEFAULT);
    }

    public static void setPreferenceJson(String userJson) {
        editor.putString(SP_PREFERENCE_JSON, userJson);
        editor.commit();
    }

    public static String getSearchDataJson() {
        return sharedPreferences.getString(SP_SEARCH_DATA_JSON, SP_STRING_DEFAULT);
    }

    public static void setSearchDataJson(String userJson) {
        editor.putString(SP_SEARCH_DATA_JSON, userJson);
        editor.commit();
    }

    public static String getSettingsJson() {
        return sharedPreferences.getString(SP_SETTINGS_JSON, SP_STRING_DEFAULT);
    }

    public static void setSettingsJson(String userJson) {
        editor.putString(SP_SETTINGS_JSON, userJson);
        editor.commit();
    }

    public static String getUuid() {
        return sharedPreferences.getString(SP_UUID, SP_STRING_DEFAULT);
    }

    public static void setUuid(String uuid) {
        editor.putString(SP_UUID, uuid);
        editor.commit();
    }

    public static String getGender() {
        return sharedPreferences.getString(SP_USER_GENDER, SP_STRING_DEFAULT);
    }

    public static void setGender(String gender) {
        editor.putString(SP_USER_GENDER, gender);
        editor.commit();
    }

    public static String getGsmToken() {
        return sharedPreferences.getString(SP_GSM_TOKEN, SP_STRING_DEFAULT);
    }

    public static void setGsmToken(String uuid) {
        editor.putString(SP_GSM_TOKEN, uuid);
        editor.commit();
    }

    public static String getTopCardId() {
        return sharedPreferences.getString(SP_TOP_CARD_ID, SP_STRING_DEFAULT);
    }

    public static void setTopCardId(String uuid) {
        editor.putString(SP_TOP_CARD_ID, uuid);
        editor.commit();
    }

    public static String getGcmToken() {
        return sharedPreferences.getString(SP_GCM_TOKEN, SP_STRING_DEFAULT);
    }

    public static void setGcmToken(String uuid) {
        editor.putString(SP_GCM_TOKEN, uuid);
        editor.commit();
    }

    public static boolean getGcmTokenUpdateFlag() {
        return sharedPreferences.getBoolean(SP_GCM_TOKEN_FLAG, false);
    }

    public static void setGcmTokenUpdateFlag(boolean flag) {
        editor.putBoolean(SP_GCM_TOKEN_FLAG, flag);
        editor.commit();
    }

    //Log all key-value pairs which stored in sharedpreferences
    public static void logPrefs() {
        Map<String, ?> keys = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            Log.d("map values", entry.getKey() + ": " +
                    entry.getValue().toString());
        }
    }

    //set default values in Sharedprefernces
    public static void clearPrefs() {
        setUid(SP_UID_DEFAULT);
        setFBid(SP_UID_DEFAULT);
        setUserEmail(SP_STRING_DEFAULT);
        setUserJson(SP_STRING_DEFAULT);
        setBirthDate(SP_STRING_DEFAULT);
        setIsOrientation(SP_BOOLEAN_DEFAULT);
        setSearchDataJson(SP_STRING_DEFAULT);
        setSettingsJson(SP_STRING_DEFAULT);
        setGsmToken(SP_STRING_DEFAULT);
        setProfileImage(SP_STRING_DEFAULT);
        setAccessToken(SP_STRING_DEFAULT);
        setPreferenceJson(SP_STRING_DEFAULT);
        setTopCardId(SP_STRING_DEFAULT);
        setUserName(SP_STRING_DEFAULT);
        setFirstName(SP_STRING_DEFAULT);
        setLastName(SP_STRING_DEFAULT);
        setFacebookResponse(SP_STRING_DEFAULT);
        setAccessTokenLogin(SP_STRING_DEFAULT);
        setIsChat(SP_BOOLEAN_DEFAULT);
        setIsProposal(SP_BOOLEAN_DEFAULT);
        setIsProfile(SP_BOOLEAN_DEFAULT);
        setFilterCity(SP_STRING_DEFAULT);
        setFilterSortBy(SP_STRING_DEFAULT);
        setFilterPayment(SP_BOOLEAN_DEFAULT);
        setFilterAgeStart(SP_AGE_START_DEFAULT);
        setFilterAgeEnd(SP_AGE_END_DEFAULT);
        setUserMobile(SP_STRING_DEFAULT);
        setCategory(SP_STRING_DEFAULT);
        setUserCity(SP_STRING_DEFAULT);
        setIsChatScreenVisible(SP_BOOLEAN_DEFAULT);
        setIsOtp(SP_BOOLEAN_DEFAULT);
        setAge(SP_INTEGER_DEFAULT);
        setGender(SP_STRING_DEFAULT);
        setInterestedIn(SP_INTEGER_DEFAULT);
        setOnlineTime(SP_INTEGER_DEFAULT);
        setChat(SP_INTEGER_DEFAULT);
        setPayment(SP_INTEGER_DEFAULT);
        setProfileProgress(SP_INTEGER_DEFAULT);

        setDateFilterCity(SP_STRING_DEFAULT);
        setDateFilterDateType(SP_STRING_DEFAULT);
        setDateFilterPaidBy(SP_STRING_DEFAULT);
        setDateFilterArea(SP_STRING_DEFAULT);
        setDateFilterStartDate(SP_STRING_DEFAULT);
        setDateFilterEndDate(SP_STRING_DEFAULT);
        setDateFilterStartTime(SP_STRING_DEFAULT);
        setDateFilterEndTime(SP_STRING_DEFAULT);

    }

    public static String getFaceBookResponse() {
        return sharedPreferences.getString(SP_FACEBOOKDATA, SP_STRING_DEFAULT);
    }

    public static void setFacebookResponse(String facebookResponse) {
        editor.putString(SP_FACEBOOKDATA, facebookResponse);
        editor.commit();
    }

    public static boolean getIsTutorialSeen() {
        return sharedPreferences.getBoolean(SP_IS_TUTORIAL_SEEN, false);
    }

    public static void setIsTutorialSeen(boolean isTutorialSeen) {
        editor.putBoolean(SP_IS_TUTORIAL_SEEN, isTutorialSeen);
        editor.commit();
    }
    public static int getInterestedIn() {
        return sharedPreferences.getInt(SP_HELP_INTERESTED_IN, SP_INTEGER_DEFAULT);
    }

    public static void setInterestedIn(int status) {
        editor.putInt(SP_HELP_INTERESTED_IN, status);
        editor.commit();
    }
    public static int getInterestedInSub() {
        return sharedPreferences.getInt(SP_HELP_INTERESTED_IN_SUB, SP_INTEGER_DEFAULT);
    }

    public static void setInterestedInSub(int status) {
        editor.putInt(SP_HELP_INTERESTED_IN_SUB, status);
        editor.commit();
    }

    public static int getInterestedInSubSave() {
        return sharedPreferences.getInt(SP_HELP_INTERESTED_IN_SUB_SAVE, SP_INTEGER_DEFAULT);
    }

    public static void setInterestedInSubSave(int status) {
        editor.putInt(SP_HELP_INTERESTED_IN_SUB_SAVE, status);
        editor.commit();
    }

    public static int getSTR() {
        return sharedPreferences.getInt(SP_HELP_STR, SP_INTEGER_DEFAULT);
    }

    public static void setSTR(int status) {
        editor.putInt(SP_HELP_STR, status);
        editor.commit();
    }
    public static int getRLM() {
        return sharedPreferences.getInt(SP_HELP_RLM, SP_INTEGER_DEFAULT);
    }

    public static void setRLM(int status) {
        editor.putInt(SP_HELP_RLM, status);
        editor.commit();
    }
    public static int getI() {
        return sharedPreferences.getInt(SP_HELP_I, SP_INTEGER_DEFAULT);
    }

    public static void setI(int status) {
        editor.putInt(SP_HELP_I, status);
        editor.commit();
    }
    public static int getMy() {
        return sharedPreferences.getInt(SP_HELP_MY, SP_INTEGER_DEFAULT);
    }

    public static void setMy(int status) {
        editor.putInt(SP_HELP_MY, status);
        editor.commit();
    }
    public static int getWe() {
        return sharedPreferences.getInt(SP_HELP_WE, SP_INTEGER_DEFAULT);
    }

    public static void setWe(int status) {
        editor.putInt(SP_HELP_WE, status);
        editor.commit();
    }
    public static int getSetting() {
        return sharedPreferences.getInt(SP_HELP_SETTINGS, SP_INTEGER_DEFAULT);
    }

    public static void setSetting(int status) {
        editor.putInt(SP_HELP_SETTINGS, status);
        editor.commit();
    }
    public static int getChat() {
        return sharedPreferences.getInt(SP_HELP_CHAT, SP_INTEGER_DEFAULT);
    }

    public static void setChat(int status) {
        editor.putInt(SP_HELP_CHAT, status);
        editor.commit();
    }
    public static int getPayment() {
        return sharedPreferences.getInt(SP_HELP_PAYMENT, SP_INTEGER_DEFAULT);
    }

    public static void setPayment(int status) {
        editor.putInt(SP_HELP_PAYMENT, status);
        editor.commit();
    }
    public static int getDateOMater() {
        return sharedPreferences.getInt(SP_HELP_DATEOMETER, SP_INTEGER_DEFAULT);
    }

    public static void setDateOMater(int status) {
        editor.putInt(SP_HELP_DATEOMETER, status);
        editor.commit();
    }
    public static int getOnlineTime() {
        return sharedPreferences.getInt(SP_HELP_ONLINE_TIME, SP_INTEGER_DEFAULT);
    }

    public static void setOnlineTime(int status) {
        editor.putInt(SP_HELP_ONLINE_TIME, status);
        editor.commit();
    }
    /* Profile Search filters */
    public static String getFilterCity() {
        return sharedPreferences.getString(SP_FILTER_PROFILE_CITY, SP_STRING_DEFAULT);
    }

    public static void setFilterCity(String city) {
        editor.putString(SP_FILTER_PROFILE_CITY, city);
        editor.commit();
    }
    public static String getFilterSortBy() {
        return sharedPreferences.getString(SP_FILTER_PROFILE_SORT_BY, SP_STRING_DEFAULT);
    }

    public static void setFilterSortBy(String sortBy) {
        editor.putString(SP_FILTER_PROFILE_SORT_BY, sortBy);
        editor.commit();
    }
    public static int getFilterAgeStart() {
        return sharedPreferences.getInt(SP_FILTER_PROFILE_AGE_START, SP_INTEGER_DEFAULT);
    }

    public static void setFilterAgeStart(int ageStart) {
        editor.putInt(SP_FILTER_PROFILE_AGE_START, ageStart);
        editor.commit();
    }
    public static int getFilterAgeEnd() {
        return sharedPreferences.getInt(SP_FILTER_PROFILE_AGE_END, SP_INTEGER_DEFAULT);
    }

    public static void setFilterAgeEnd(int ageEnd) {
        editor.putInt(SP_FILTER_PROFILE_AGE_END, ageEnd);
        editor.commit();
    }
    public static boolean getFilterPayment() {
        return sharedPreferences.getBoolean(SP_FILTER_PROFILE_PAYMENT, false);
    }

    public static void setFilterPayment(boolean payment) {
        editor.putBoolean(SP_FILTER_PROFILE_PAYMENT, payment);
        editor.commit();
    }
    /* Date Search filters */
    public static String getDateFilterCity() {
        return sharedPreferences.getString(SP_FILTER_DATE_CITY, SP_STRING_DEFAULT);
    }

    public static void setDateFilterCity(String city) {
        editor.putString(SP_FILTER_DATE_CITY, city);
        editor.commit();
    }
    public static String getDateFilterDateType() {
        return sharedPreferences.getString(SP_FILTER_DATE_DATE_TYPE, SP_STRING_DEFAULT);
    }

    public static void setDateFilterDateType(String dateType) {
        editor.putString(SP_FILTER_DATE_DATE_TYPE, dateType);
        editor.commit();
    }
    public static String getDateFilterPaidBy() {
        return sharedPreferences.getString(SP_FILTER_DATE_PAID_BY, SP_STRING_DEFAULT);
    }

    public static void setDateFilterPaidBy(String paidBy) {
        editor.putString(SP_FILTER_DATE_PAID_BY, paidBy);
        editor.commit();
    }
    public static String getDateFilterArea() {
        return sharedPreferences.getString(SP_FILTER_DATE_AREA, SP_STRING_DEFAULT);
    }

    public static void setDateFilterArea(String area) {
        editor.putString(SP_FILTER_DATE_AREA, area);
        editor.commit();
    }
    public static String getDateFilterStartDate() {
        return sharedPreferences.getString(SP_FILTER_DATE_START_DATE, SP_STRING_DEFAULT);
    }

    public static void setDateFilterStartDate(String area) {
        editor.putString(SP_FILTER_DATE_START_DATE, area);
        editor.commit();
    }
    public static String getDateFilterEndDate() {
        return sharedPreferences.getString(SP_FILTER_DATE_END_DATE, SP_STRING_DEFAULT);
    }

    public static void setDateFilterEndDate(String area) {
        editor.putString(SP_FILTER_DATE_END_DATE, area);
        editor.commit();
    }
    public static String getDateFilterStartTime() {
        return sharedPreferences.getString(SP_FILTER_DATE_START_TIME, SP_STRING_DEFAULT);
    }
    public static void setDateFilterStartTime(String startTime) {
        editor.putString(SP_FILTER_DATE_START_TIME, startTime);
        editor.commit();
    }
    public static String getDateFilterEndTime() {
        return sharedPreferences.getString(SP_FILTER_DATE_END_TIME, SP_STRING_DEFAULT);
    }

    public static void setDateFilterEndTime(String endTime) {
        editor.putString(SP_FILTER_DATE_END_TIME, endTime);
        editor.commit();
    }
    /*public static long getDateFilterStartTime() {
        return sharedPreferences.getLong(SP_FILTER_DATE_START_TIME, SP_INTEGER_DEFAULT);
    }
    public static void setDateFilterStartTime(long startTime) {
        editor.putLong(SP_FILTER_DATE_START_TIME, startTime);
        editor.commit();
    }
    public static long getDateFilterEndTime() {
        return sharedPreferences.getLong(SP_FILTER_DATE_END_TIME, SP_INTEGER_DEFAULT);
    }

    public static void setDateFilterEndTime(long endTime) {
        editor.putLong(SP_FILTER_DATE_END_TIME, endTime);
        editor.commit();
    }*/
    public static int getProfileProgress() {
        return sharedPreferences.getInt(SP_PROFILE_PROGRESS, SP_INTEGER_DEFAULT);
    }

    public static void setProfileProgress(int profileProgress) {
        editor.putInt(SP_PROFILE_PROGRESS, profileProgress);
        editor.commit();
    }
    public static void setDateTypeOptions(String dateOptions) {
        editor.putString(SP_OPTIONS_DATE_TYPE, dateOptions);
        editor.commit();
    }
    public static String getDateTypeOptions() {
        return sharedPreferences.getString(SP_OPTIONS_DATE_TYPE, SP_STRING_DEFAULT);
    }
    public static void setPaidByOptions(String paidByeOptions) {
        editor.putString(SP_OPTIONS_PAID_BY, paidByeOptions);
        editor.commit();
    }
    public static String getPaidByOptions() {
        return sharedPreferences.getString(SP_OPTIONS_PAID_BY, SP_STRING_DEFAULT);
    }
    public static void setDurationOptions(String durationOptions) {
        editor.putString(SP_OPTIONS_DURATION, durationOptions);
        editor.commit();
    }
    public static String getDurationOptions() {
        return sharedPreferences.getString(SP_OPTIONS_DURATION, SP_STRING_DEFAULT);
    }
}
