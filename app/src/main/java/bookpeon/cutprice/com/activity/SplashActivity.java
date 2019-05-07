package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.base.BaseUpdateListener;
import bookpeon.cutprice.com.util.AllSettingsManager;
import bookpeon.cutprice.com.util.AppUtil;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class SplashActivity extends AppCompatActivity {

    private TextView tvAppVersion;
    private ImageView ivAppLogo, ivAppLogoFlavor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_splash);

      //  initStatusBar();
        initActivityViews();
        initActivityViewsData();
    }

//    private void initStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setTransparent(SplashActivity.this);
//    }

    public void initActivityViews() {
        tvAppVersion = (TextView) findViewById(R.id.tv_app_version);
        ivAppLogo = (ImageView) findViewById(R.id.iv_app_logo);
    }

    public void initActivityViewsData() {
        //Set app version
        String appVersion = AppUtil.getAppVersion(SplashActivity.this);
        if (!AllSettingsManager.isNullOrEmpty(appVersion)) {
            tvAppVersion.setText("Version: " + appVersion);
        }

        //Set flavor icon

        //Rotate app logo
        AppUtil.makeRotateAnimation(ivAppLogo, 3, new BaseUpdateListener() {
            @Override
            public void onUpdate(Object update) {
                if ((boolean) update) {
                    //Navigate to the next screen
                    navigateNextScreen();
                }
            }
        });
    }

    private void navigateNextScreen() {
      Intent  intentAppDriver = new Intent(SplashActivity.this, ActivityLoginInAndSignUp.class);
      startActivity(intentAppDriver);
      finish();
    }
}