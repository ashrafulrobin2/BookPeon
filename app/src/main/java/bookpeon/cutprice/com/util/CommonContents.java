package bookpeon.cutprice.com.util;

import android.provider.ContactsContract;

/**
 * Created by M.H.Mridul on 12/26/2015.
 */
public class CommonContents {
    public static final String FONT_EXTRA_BOLD_PATH = "fonts/NotoSans-Regular.ttf";

    //  public static final String USER_ID ="user_id" ;
    public static final String USER_BALANCE = "user_balance";
    public static String TAG = "SC";
    public static String DATABASE_NAME = "SmartCareDB";
    public static int DATABASE_VERSION = 1;
    public static String SQL_TABLE_PHONECALL = "PhoneCallInformation";
    public static String SQL_TABLE_SMS = "SMSInformation";
    public static String SQL_TABLE_CONTACT = "Contact";
    public static int OPEN_COUNTER = 50;
    public static String API_KEY = "Cutprice@987";
    //Stripe info
    public static final String STRIPE_PUBLISHABLE_KEY = "pk_test_tJUiRLrvApKRKp1BSjcJ2oYv";
    public static final String STRIPE_SECRET_KEY = "sk_test_KCXuIdLgneB3AXVwucVICPfa";

    /*
        SharedPreference value
     */

    public static String USER_ID = "USER_ID";
    public static String USER_SETTING_TYPE = "USER_SETTING_TYPE";
    public static String USER_LOGIN_SESSION_TYPE = "USER_LOGIN_SESSION_TYPE";
    public static String FCM_TOKEN = "FCM_TOKEN";
    public static String isFirstLogin = "apps_first_login";

    public static String MOBILE_NUMBER = "mobile_number";
    public static String USER_TOKEN = "token";
    public static String isLoggedIn = "is_loggedin";




    public static final String INTENT_KEY_LOGIN = "INTENT_KEY_LOGIN";

    //Intent request code
    public static final int INTENT_REQUEST_CODE_SOCIAL_USER_LOGIN = 42;
    public static final int INTENT_REQUEST_CODE_USER_LOGIN = 420;
    public static final int INTENT_REQUEST_CODE_ADD_SHIPPING = 4200;
    public static final int INTENT_REQUEST_CODE_EDIT_SHIPPING = 42000;
    public static final int INTENT_REQUEST_CODE_CONFIRM_SHIPPING = 41000;
    public static final int INTENT_REQUEST_CODE_USER_LOGOUT = 410;
    public static final int INTENT_REQUEST_CODE_IMAGE_PICKER = 42100;
    public static final int INTENT_REQUEST_CODE_USER_PROFILE = 42200;
    public static final int INTENT_REQUEST_CODE_EDIT_BUYING_BID = 42210;
    public static final int INTENT_REQUEST_CODE_EDIT_SELLING_ASK = 42110;
    public static final int REQUEST_CODE_PAYPAL_INTREGATED = 42210;
    public static final int REQUEST_CODE_PAYOUT = 42220;
    public static final int INTENT_REQUEST_CODE_ADD_BILLING = 43000;
    public static final int INTENT_REQUEST_CODE_EDIT_BILLING= 43100;

//  public static final int INTENT_REQUEST_CODE_USER_LOGIN = 420000;


    public static String[] CONTACTS_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone._ID,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.PHOTO_ID
    };

}
