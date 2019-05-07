package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.fragment.AccountFragment;
import bookpeon.cutprice.com.fragment.HomeFragment;
import bookpeon.cutprice.com.fragment.PaymentLandingFragment;
import bookpeon.cutprice.com.fragment.SearchFragment;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;


public class ActivityHome extends AppCompatActivity  {

    private TextView messageView;
    private Fragment fragment = null;
    BottomNavigationViewEx bottomNve;
    private int currentMenuId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView( R.layout.activity_home);
     //   StatusBarUtil.setStatusBarTransparentAndDark( this );

        Log.e( "<<onCreate","onCreate" );


        //  initialize UI
        initUI();
        // Setup drawer view
        initActionComponent();
        loadFragment(new HomeFragment());
    }

    private void initActionComponent() {

        bottomNve.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                navigationMenuChanged(item);
                return true;
//                switch (item.getItemId()) {
//                    case R.id.item_home:
//                        fragment = new HomeFragment2();
//                        loadFragment(fragment);
//                        break;
//                    case R.id.item_explore:
////                        fragment = new LandingFragment();
////                        loadFragment(fragment);
//                        break;
//                    case R.id.item_search:
//                        break;
//                    case R.id.item_accounts:
//                        fragment = new AccountSettingFragment();
//                        loadFragment(fragment);
//                        break;
//                }
//                return true;
            }
        } );

    }

    private void navigationMenuChanged(MenuItem menuItem) {
        openFragment(menuItem.getItemId());
        menuItem.setChecked(true);
    }


    @Override
    protected void onStart() {
        super.onStart();
    //    StatusBarUtil.immersive(this);

        Log.e( "<<onStart","onStart" );
////
//        Window window = getWindow();
//        WindowManager.LayoutParams winParams = window.getAttributes();
//      //  winParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//        window.setAttributes(winParams);
//        window.getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

    }

    @Override
    public void onResume() {
        super.onResume();
    //    StatusBarUtil.immersive(this);
        Log.e( "<<onResume","onResume" );

        // StatusBarUtils.setTransparent(this);
//        Window window = getWindow();
//        WindowManager.LayoutParams winParams = window.getAttributes();
//        //    winParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//        window.setAttributes(winParams);
//        window.getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }
    }


    public void openFragment(int menuId) {

        switch (menuId) {
            case R.id.item_home:
                fragment = new HomeFragment();
                loadFragment(fragment);
                break;

            case R.id.item_search2:
                Intent intentReg = new Intent(getApplicationContext(), ActivityWishList.class);
                startActivity(intentReg);
                break;

            case R.id.item_search:
//                Intent intentCheckout = new Intent(getApplicationContext(), ActivityCheckout.class);
//                startActivity(intentCheckout);
                fragment = new PaymentLandingFragment();
                loadFragment(fragment);
                Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_accounts:
                fragment = new AccountFragment();
                loadFragment(fragment);
                break;

        }

        if (currentMenuId != menuId) {
            currentMenuId = menuId;

            //updateFragment(fragment);

            try {
                bottomNve.getMenu().findItem(menuId).setChecked(true);
            } catch (Exception e) {
            }
        }
    }

    private void updateFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


    private void initUI() {
        bottomNve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        bottomNve.enableAnimation(false);
        bottomNve.enableShiftingMode(false);
        bottomNve.enableItemShiftingMode(false);
        // add badge
       // addBadgeAt(2, 5);
    }

    private Badge addBadgeAt(int position, int number) {
        // add badge
        return new QBadgeView(this)
                .setBadgeNumber(number)
                .setGravityOffset(12, 2, true)
                .bindTarget(bottomNve.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
//                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState)
//                            Toast.makeText(BadgeViewActivity.this, R.string.tips_badge_removed, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }


//    @Override
//    public void onBackPressed() {
//            if (getFragmentManager().getBackStackEntryCount() > 0) {
//                getFragmentManager().popBackStack();
//            } else {
//                super.onBackPressed();
//            }
//
////        if (bnve.getSelectedItemId() == R.id.item_home)
////        {
////            super.onBackPressed();
////            finish();
////        }
////        else
////        {
////            bnve.setSelectedItemId(R.id.item_home);
////        }
//
//    }







//    protected void setStatusBar() {
//        StatusBarUtils.setColor(this, getResources().getColor(R.color.grey_700));
//        StatusBarUtils.setTranslucentForImageViewInFragment(ActivityHome.this, null);
//
//    }

}
