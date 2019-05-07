package bookpeon.cutprice.com.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;


/**
 * @author Md. Rashadul Alam
 * Email: rashed.droid@gmail.com
 */
public class BookPeonApp extends Application {

    private static Context mContext;
    private static BookPeonApp mInstance;
//
//    Handler handler = new Handler();
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            obtainFirebaseToken();
//        }
//    };


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        //Multidex initialization
        MultiDex.install(this);

        if (mContext == null) {
            mContext = this;
        }

//        MultiDex.install(this);
        //For using vector drawable
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


    }

    public static synchronized BookPeonApp getInstance() {
        return mInstance;
    }


    public static Context getGlobalContext() {
        return mContext;
    }
}