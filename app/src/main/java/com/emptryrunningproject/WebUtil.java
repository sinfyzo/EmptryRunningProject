package com.emptryrunningproject;

public interface WebUtil {


/*
    200 - Successful requests.
            201 - New resource created. (User, media, etc.)
            204 - No content. (Data is missing.)
            205 - Reset content. (Server updated the data but may not return it back. This response sometimes requires requested reset the view.)

            400 - Bad Request. (Requested data format is bad.)
            401 - Unauthorized. (Mostly states user needs to login/register to access the end point.)
            403 - Forbidden. (More close to 401, but it may be used for block status.)
            405 - Method Not Allowed. (Any method from GET, POST, PUT, DELETE not allowed.)
            408 - Request time out.
    415 - Unsupported media type. (Can be used for image, video, audio mime type check.)
            423 - Locked. (Requested resource is locked.)
            426 - Upgrade Required. (Application or Web service update is required.)
            498 - Invalid authentication token.
    499 - Authentication token required.

    500 - Internal Server Error. (Error received while processing image, audio or other media, or while processing data.)
            502 - Bad gateway. (Wrong end point or method request.)
            503 - Service Unavailable. (Server is currently not available.)
            511 - Network authentication is required.
            520 - Unknown error.
*/

    String RESPONSE_CODE = "responseCode";
    int RESPONSE_CODE_VALUE = 200;
    int RESPONSE_CODE_201 = 201;
    int RESPONSE_CODE_204 = 204;
    int RESPONSE_CODE_205 = 205;
    int RESPONSE_CODE_400 = 400;
    int RESPONSE_CODE_401 = 401;
    int RESPONSE_CODE_403 = 403;
    int RESPONSE_CODE_405 = 405;
    int RESPONSE_CODE_408 = 408;
    int RESPONSE_CODE_415 = 415;
    int RESPONSE_CODE_423 = 423;
    int RESPONSE_CODE_422 = 422;
    int RESPONSE_CODE_426 = 426;
    int RESPONSE_CODE_498 = 498;
    int RESPONSE_CODE_499 = 499;
    int RESPONSE_CODE_500 = 500;
    int RESPONSE_CODE_502 = 502;
    int RESPONSE_CODE_503 = 503;
    int RESPONSE_CODE_511 = 511;
    int RESPONSE_CODE_520 = 520;
    int RESPONSE_CODE_999 = 999;
    int RESPONSE_CODE_998 = 998;
    int RESPONSE_CODE_997 = 997;
    int RESPONSE_CODE_996 = 996;

    //Login response parameters
    String KEY_GCM_TOKEN = "fgcmToken";
    String KEY_FID = "id";
    String KEY_FB_PICTURE = "picture";
    String KEY_FB_PICTURE_DATA = "data";
    String KEY_FB_PICTURE_URL = "url";
    String KEY_FB_FIRST_NAME = "first_name";
    String KEY_FB_LAST_NAME = "last_name";
    String KEY_PROPOSAL = "proposal";
    String KEY_CHATS = "chat";


    String KEY_LAT = "lat";
    String KEY_LON = "lon";

    String VALUE_MALE = "male";
    String VALUE_FEMALE = "female";
    String VALUE_MALE_SHORT = "m";
    String VALUE_FEMALE_SHORT = "f";
    String KEY_NUMUSERS = "numUsers";

    String TITLE_REGISTRATION = "Sign Up";
    String TITLE_FORGOT_PASSWORD = "Forgot Password";
    String TITLE_RESET_PASSWORD = "Reset Password";
    String TITLE_OTP = "One Time Password";
    String TITLE_CHANGE_PASSWORD = "Change Password";
    String TITLE_CHANGE_MOBILE = "Change Mobile";


    // Orientation Screen Paramters
    //public static final String KEY_PARTNER = "partner";

    String SINGLESELECT = "singleSelect";
    String FILE = "file";
    String KEY_OPTIONS = "options";
    String KEY_STATUS = "status";
    String KEY_INSTANTSELFIE_STATUS = "instantSelfieStatus";
    String KEY_ONLINEDATE_STATUS = "onlineDateStatus";
    String KEY_GIFTTIME = "time";
    String KEY_WITHPHOTO = "withPhoto";

    String KEY_ID = "_id";
    String KEY_FNAME = "fname";
    String KEY_LANME = "lname";
    String KEY_GENDER = "gender";
    String KEY_AGE = "age";
    String KEY_DISTANCE = "distance";
    String KEY_LASTCHATTIME = "lastChatTime";

    String KEY_PAGE = "page";


    String KEY_CITY = "city";
    String KEY_SORT = "sort";
    String KEY_LOCATION = "location";
    String KEY_DOB = "dob";
    String KEY_PROFILEPICS = "profilePics";
    String KEY_PROFILEMEDIA = "profileMedia";
    String KEY_FBID = "fbId";
    String KEY_UUID = "uuid";

    String KEY_VERSION = "version";
    String KEY_DEVICE_INFO = "deviceInfo";
    String KEY_OS_VERSION = "osVersion";
    String KEY_OS_RELEASE = "osRelease";
    String KEY_DEVICE = "device";
    String KEY_MODEL = "model";
    String KEY_PRODUCT = "product";
    String KEY_BRAND = "brand";
    String KEY_DISPLAY = "display";
    String KEY_HARDWARE = "hardware";
    String KEY_DEVICE_ID = "ID";
    String KEY_MANUFACTURER = "manufacturer";
    String KEY_SERIAL = "serial";
    String KEY_USER = "user";
    String KEY_HOST = "host";
    String KEY_OS_NAME = "osName";
    String KEY_UI = "UI";
    String KEY_CPU = "CPU";
    String KEY_MAC_ADDRESS = "MacAddress";
    String KEY_RAM = "RAM";
    String KEY_INTERNAL_MEMORY = "InternalMemory";
    String KEY_IP_ADDRESS = "IPAddress";
    String KEY_RESOLUTION_IN_PIXELS = "resolutionInPixels";
    String KEY_SCREEN_HEIGHT = "screenHeight";

    String KEY_UID = "uid";
    String KEY_OTP = "otp";
    String KEY_SET_PASSWORD_TOKEN = "setPasswordToken";
    String KEY_USER_IMAGE_URL = "profilePics";
    String KEY_EMAIL = "email";
    String KEY_USERNAME = "username";
    String KEY_MOBILE = "mobile";
    String KEY_DATA = "data";

    String KEY_IS_ORIENTATION = "isOrientation";
    String KEY_IS_PROFILE = "isProfile";
    String KEY_JWTOKEN = "jwToken";
    String KEY_CHAT_APIVERSION = "apiVersion";
    String KEY_X_ACCESS_TOKEN = "x-access-token";


    String KEY_IS_OTPVERIFY = "isOtpVerify";
    String KEY_OTP_SEND_DEVICE = "OTPSendDevice";

    String KEY_CATEGORY = "category";
    String KEY_LOCALNOTIFICATION = "isLocalNotification";

    String KEY_NAME = "name";
    String KEY_TYPE = "type";
    String KEY_TO_NAME = "toName";
    String KEY_DEFAULT_TYPE = "defaultType";
    String KEY_RESPONSE_MSG = "responseMsg";
    String KEY_RESPONSE_CODE = "responseCode";
    String KEY_VALUE = "value";
    String KEY_ILIKED = "iLiked";
    String KEY_YOULIKED = "youLiked";

    String VALUE_CASUAL = "Casual";
    String VALUE_FRIENDSHIP = "Friendship";
    String VALUE_DATING = "Dating";
    String VALUE_RELATIONSHIP = "Relationship";
    String VALUE_LIVEIN = "LiveIn";
    String VALUE_MARRIAGE = "Marriage";
    String NO_VALUE = "---";
    String KEY_CHAT_USERS = "users";
    String KEY_CHAT_DATA = "data";
    String KEY_CHAT_TYPE = "type";
    String KEY_CHAT_URL = "url";
    String KEY_CHAT_SIZE = "size";
    String KEY_CHAT_FILE = "file";
    String KEY_CHAT_TIMESTAMP = "ts";
    String KEY_CHAT_NAME = "name";
    String KEY_CHAT_TO = "to";
    String KEY_ISEXCLUSIVE = "isExclusive";

    String KEY_CHATCOUNT = "chatCount";

    String KEY_CHAT_MSGTYPE = "msgType";
    String KEY_CHAT_MSGTYPE1 = "msgType1";
    String KEY_CHAT_CAPTION = "caption";
    String KEY_CHAT_MSG = "msg";
    String KEY_CHAT_MSG1 = "msg1";
    String KEY_CHAT_GCMTOKEN = "fgcmToken";
    String KEY_CHAT_GIFT = "gift";
    String KEY_CHAT_GIF = "gif";
    String KEY_CHAT_ISMESSAGESENT = "isMessageSent";

    String KEY_CHAT_NEWMSG = "newMsg";
    String KEY_CHAT_READMSG = "readMsg";
    String KEY_CHAT_READFLAG = "readFlag";
    String KEY_CHAT_DELIVERMSG = "deliverMsg";
    String KEY_CHAT_LIKE = "like";
    String KEY_CHAT_GIFTCATEGORY = "giftCategory";

    String KEY_CHAT_EVENT_INITIALIZE = "chatInitialize";
    String KEY_CHAT_EVENT_EXCLUSIVECHAT = "exclusiveChat";
    String KEY_CHAT_EVENT_ONLINE = "online";
    String KEY_CHAT_EVENT_OFFLINE = "offline";
    String KEY_CHAT_EVENT_LASTSEEN = "lastSeen";


    String KEY_CHAT_GIFT_FLOWERS = "flowers";
    String KEY_CHAT_GIFT_CARDS = "cards";
    String KEY_CHAT_GIFT_CHOCOLATE = "chocolate";
    String KEY_CHAT_GIFT_RINGS = "rings";
    String KEY_CHAT_GIFT_TEDDIES = "teddies";
    String KEY_CHAT_GIFT_MISCELLANEOUS = "miscellaneous";

    String KEY_CHAT_USERJOINED = "user joined";
    String KEY_CHAT_USERLEFT = "user left";
    String KEY_CHAT_STARTTYPING = "startTyping";
    String KEY_CHAT_STOPTYPING = "stopTyping";
    String KEY_CHAT_IMAGE_STAR = "image/*";
    String KEY_CHAT_IMAGE = "image";
    String KEY_CHAT_AUDIO_STAR = "audio/*";
    String KEY_CHAT_VIDEO_STAR = "video/*";
    //
    String KEY_CHAT_CONNECTED = "connected";
    String KEY_CHAT_AUDIO = "audio";
    String KEY_CHAT_VIDEO = "video";
    String KEY_CHAT_INSTANTSELFIE = "instantSelfie";
    String KEY_VIDEO_THUMBNAIL_URL = "thumbnail";

    String KEY_UNFRIEND = "unFriend";
    String KEY_BLOCK = "block";

    String KEY_PASSWORD = "password";
    String KEY_OLDPASSWORD = "oldPassword";

    String KEY_PASSPORT = "passport";

    /*Keys for Profile General*/
    String KEY_PROFILE_AUDIO = "profileAudio";
    String KEY_PROFILE_VIDEO = "profileVideo";
    String KEY_LIKES = "likes";
    String KEY_IDEAL_DATE = "idealDate";
    String KEY_ONLINE_USER = "onlineUser";


    /*Keys for Personal Details*/
    String KEY_PERSONAL_DETAILS = "personalDetails";
    String KEY_HEIGHT = "height";
    String KEY_WEIGHT = "weight";
    String KEY_BODYTYPE = "bodyType";
    String KEY_COMPLEXION = "complexion";
    String KEY_EYECOLOR = "eyeColor";
    String KEY_HAIRCOLOR = "hairColor";
    String KEY_OCCUPATION = "occupation";
    String KEY_SMOKING = "smoking";
    String KEY_DRINKING = "drinking";
    String KEY_DIET = "diet";
    String KEY_KNOWNLANGUAGE = "knownLanguage";
    String KEY_DATE_PERCENTAGE = "completedDatesPercent";

    /*Keys for Reviews*/
    String KEY_REVIEWS = "reviews";
    String KEY_PHOTO = "photo";
    String KEY_CONTENT = "content";
    String KEY_TIME = "time";

    String KEY_INTERESTS = "interests";
    String KEY_ONLINE_TIME = "onlineTime";
    /*Keys for Ratings*/
    String KEY_RATINGS = "ratings";
    String KEY_TOTAL = "total";
    String KEY_ITEMS = "items";
    String KEY_LOOKS = "looks";

    /*Keys for Hold*/
    String KEY_PROPOSALDATA = "proposalData";
    String KEY_HOLDDATA = "holdData";
    String KEY_DEGREE = "degree";


    String VALUE_ANY = "Any";
    String KEY_CAST = "cast";
    String KEY_STATES = "states";
    String KEY_STATENAME = "stateName";
    String KEY_CITIES = "cities";
    String KEY_CITYNAME = "cityName";
    String KEY_NATIVE_CITY = "nativeCity";
    String KEY_FAMILY_CITY = "familyCity";
    String KEY_KUNDLI = "kundli";
    String KEY_BIRTH_CITY = "birthCity";
    String KEY_SUNSIGN = "sunSign";

    String KEY_ABOUTME = "aboutMe";
    String KEY_INDUSTRY = "industry";
    String KEY_DESIGNATION = "designation";
    String KEY_TAGLINE = "tagLine";
    String KEY_EXPERIENCE = "experience";
    String KEY_UPLOADCV = "uploadCV";
    String KEY_NUM = "num";

    String KEY_MEDIUM = "medium";
    String KEY_THUMB = "thumb";
    String KEY_LARGE = "large";
    String KEY_IS_APPROVED = "isApproved";
    String KEY_URL = "url";
    String KEY_THUMBNAIL = "thumbnail";
    String KEY_VIEW_COUNT = "viewCount";
    String MEDIA_IMAGE = "imageProfile";
    String MEDIA_AUDIO = "audioProfile";
    String MEDIA_VIDEO = "videoProfile";

    String KEY_FROM = "from";
    int FROM_CHANGE_PASSWORD = 1;
    int FROM_CHANGE_MOBILE = 2;

    String KEY_IS_ONLINE = "isOnline";
    String KEY_ACTION_INFO = "actionInfo";
    String KEY_DATE_INFO = "dateInfo";


    String KEY_PAYMENT_TXNID = "invoiceId";
    String KEY_PAYMENT_TRANSACTIONID = "transactionId";
    String KEY_FROM_PROPOSAL = "fromProposal";
    String KEY_POSITION = "position";

    //For new user registration type = "register"
    String KEY_TYPE_REGISTER = "register";
    String KEY_TYPE_FORGOT_PASSWORD = "forgotPassword";//TODO: cahnge as per need
    String KEY_TYPE_CHANGE_MOBILE = "register";//TODO: cahnge as per need

    int PROFILE_TYPE_SELF = 1;
    int PROFILE_TYPE_SEARCH = 2;
    int PROFILE_TYPE_CHAT = 3;
    int PROFILE_TYPE_HOLD = 4;
    int PROFILE_TYPE_PROPOSAL = 5;
    int PROFILE_TYPE_DATE = 6;

    int FILTER_TYPE_PROFILE = 1;
    int FILTER_TYPE_DATE = 2;



    int IMAGE_CROP_TYPE_SIGNUP = 1;
    int IMAGE_CROP_TYPE_PROFILE_PIC = 2;

    public static String[] personalDeatialFields = new String[]{KEY_HEIGHT, KEY_HAIRCOLOR, KEY_WEIGHT, KEY_SUNSIGN, KEY_COMPLEXION, KEY_DIET, KEY_BODYTYPE, KEY_SMOKING,
            KEY_EYECOLOR, KEY_DRINKING, KEY_KNOWNLANGUAGE};
    int PROFILE_EDIT_REQUEST = 1001;
    String KEY_HOLD_PROPOSAL = "holdProposal";
    String KEY_HOLD_PROFILE = "holdProfile";


    // TODO MyDate, Date Related Key Define
    String KEY_SUNDAY = "sunday";
    String KEY_MONDAY = "monday";
    String KEY_TUESDAY = "tuesday";
    String KEY_WEDNESDAY = "wednesday";
    String KEY_THURSDAY = "thursday";
    String KEY_FRIDAY = "friday";
    String KEY_SATURDAY = "saturday";

    String KEY_STARTTIME = "startTime";
    String KEY_DATES = "dates";
    String KEY_DATE = "date";
    String KEY_DETAILS = "details";
    String KEY_DATEOPTIONS = "dateOptions";
    String KEY_DATEKEY = "key";
    String KEY_DATE_OPTIONS = "options";
    String KEY_DATE_ISCONFIRM = "isConfirm";
    String KEY_DATE_SHOW_BUTTON = "showButton";
    String KEY_DATE_EDIT_INFO = "editedInfo";

    String KEY_DATE_DURATION = "duration";
    String KEY_DATE_PAIDBY = "paidBy";
    String KEY_DATE_VENUE = "venue";
    String KEY_DATE_AREA = "area";
    String KEY_DATE_CITY = "city";
    String KEY_DATE_STATE = "state";
    String KEY_DATE_TYPE = "dateType";
    String KEY_DATE_START_DATE = "startDate";
    String KEY_DATE_END_DATE = "endDate";
    String KEY_DATE_START_TIME = "startTime";
    String KEY_DATE_END_TIME = "endTime";
    String KEY_DATE_STATUS = "dateStatus";
    // TODO Mydate Screen, Created,Requested,Confirm  request and response key
    String KEY_DATE_CREATED = "listType";
    String KEY_DATE_CONFIRMBEFORE = "confirmBefore";
    String KEY_DATE_USERDATA = "userData";
    String KEY_DATE_CREATEDBY = "createdBy";
    String KEY_DATE_CREATEDON = "createdOn";
    String KEY_DATE_DATENAME = "dateName";
    String KEY_DATE_ISFRIEND = "isFriend";
    String KEY_DATE_ISEXCLUSIVE = "isExclusive";
    String KEY_DATE_ISDATE = "isDate";
    String KEY_DATE_USERNAME = "userName";
    String KEY_DATE_ID="dateId";
    String KEY_DATE_SEARCH="dateSearch";
    String KEY_DATE_FROMSCREEN="fromScreen";
    String KEY_DATE_FRIENDSHIPRELATION="friendShipRelation";



    String PROFILE_DECLINED = "DECLINED";
    String PROFILE_YOU_DECLINED = "YOU DECLINED";
    String DATE_STATUS_NO_ACTION = "noAction";
    String DATE_STATUS_BLOCKED_BY = "blockedBy";
    String DATE_STATUS_BLOCK = "block";
    String DATE_STATUS_PENDING = "pending";
    String DATE_STATUS_REQUESTED = "requested";
    String DATE_STATUS_HOLD = "hold";
    String DATE_STATUS_DATE_REQUEST = "dateRequest";
    String DATE_STATUS_NO_RELATION = "noRelation";
    String DATE_STATUS_DECLINED="declined";
    String DATE_STATUS_DECLINEBY="declinedBy";
    String DATE_STATUS_BLOCKED="blocked";
    String DATE_STATUS_BLOCKEDBY="blockedBy";

    String KEY_CONNECTIONSTATUS = "connectionStatus";
    String KEY_CONNECTION_TYPE_ACCEPT = "accept";
    String KEY_CONNECTION_TYPE_CONFIRM = "confirm";
    String KEY_CONNECTION_TYPE_REQUESTED = "requested";
    String KEY_CONNECTION_TYPE_IGNORE = "ignore";
    String KEY_CONNECTION_TYPE_HOLD = "hold";

    String KEY_CONNECTION_TYPE_CANCEL_RECONFIRMED = "reConfirmed";
    String KEY_CONNECTION_TYPE_CANCEL_CONFIRMED = "cancelConfirmedDate";
    String KEY_CONNECTION_TYPE_CANCEL_REQUESTED = "cancelRequestedDate";
    String KEY_CONNECTION_TYPE_CANCEL_CREATED = "cancelCreatedDate";
    String KEY_CONNECTION_TYPE_CANCEL_EDITED = "cancelEditedDate";


   /* noAction (Connected, Declined, Unfriend and UnFriendBy status) = Date-Profile-Proposal-Accepted (Friend).jpg
    blockedBy (Some declined me) = Date-profile-proposal-Declined.jpg
    block (I Declined Someone) = Date-profile-proposal--I--Declined.jpg
    pending (Pending Proposal of a Friend Request) = Date-Profile-Proposal-received.jpg
    requested (Send invitation for friendship) = Date-profile-proposal-send.jpg
    hold (I hold someone) = Hold-Profile-Action.jpg
    dateRequest (Profile visited from My created date page) = My-Date---created---request---Profile.jpg
    noRelation (Currently no relationship between us so can be friend so all action enable) = User-Profile-View-(Date).jpg

    noAction (Connected, Unfriend and UnFriendBy status) = Date-Profile-Proposal-Accepted (Friend).jpg
declined: (Proposal declined) Date-profile-proposal--I--Declined.jpg
declinedBy: (My Proposal Declined) Date-profile-proposal-Declined.jpg
blocked (I blocked Someone) = Date-profile-proposal--I--Declined.jpg (Only change that show You Blocked instead You Declined)
blockedBy (Some Blokced me) = Date-profile-proposal-Declined.jpg (Only change that show Blocked instead Declined)

    */





}
