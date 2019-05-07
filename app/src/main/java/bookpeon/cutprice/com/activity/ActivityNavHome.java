package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.jkb.slidemenu.OnSlideChangedListener;
import com.jkb.slidemenu.SlideMenuLayout;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.fragment.AccountFragment;
import bookpeon.cutprice.com.fragment.HomeFragment;
import bookpeon.cutprice.com.fragment.PaymentLandingFragment;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;


public class ActivityNavHome extends AppCompatActivity implements View.OnClickListener {

    private TextView messageView;
    private Fragment fragment = null;
    BottomNavigationViewEx bottomNve;
    private int currentMenuId = 0;
    private SlideMenuLayout slideMenuLayout;
    RelativeLayout rel_sliding;
    private Toolbar toolbar;
    public TextView txttoolbar;
    private ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView( R.layout.activity_sliding);
     //   StatusBarUtil.setStatusBarTransparentAndDark( this );

        Log.e( "<<onCreate","onCreate" );


        //  initialize ToolBarSetUp
        initToolBarSetUp();
        //  initialize UI
        initUI();
        // Setup drawer view
        initActionComponent();
        loadFragment(new HomeFragment());
    }

    private void initToolBarSetUp() {
//        toolbar = (Toolbar) findViewById( R.id.toolbar );
//        txttoolbar = (TextView) toolbar.findViewById( R.id.txttoolbar );
//        ivMenu = (ImageView) toolbar.findViewById( R.id.iv_menu );
//        txttoolbar.setText( "CutPrice" );
//        ivMenu.setOnClickListener( this );
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
        Log.e( "<<onStart","onStart" );

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e( "<<onResume","onResume" );
    }


    public void openFragment(int menuId) {

        switch (menuId) {
            case R.id.item_home:
              //  toolbar.setVisibility( View.VISIBLE );

                fragment = new HomeFragment();
                loadFragment(fragment);
                break;

            case R.id.item_search2:
             //   toolbar.setVisibility( View.GONE );
                Intent intentReg = new Intent(getApplicationContext(), ActivityWishList.class);
                startActivity(intentReg);
                break;

            case R.id.item_search:
              //  toolbar.setVisibility( View.GONE );
//                Intent intentCheckout = new Intent(getApplicationContext(), ActivityCheckout.class);
//                startActivity(intentCheckout);
                fragment = new PaymentLandingFragment();
                loadFragment(fragment);
                Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_accounts:
              //  toolbar.setVisibility( View.GONE );
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
        slideMenuLayout = (SlideMenuLayout) findViewById(R.id.mainSlideMenu);
        bottomNve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        bottomNve.enableAnimation(false);
        bottomNve.enableShiftingMode(false);
        bottomNve.enableItemShiftingMode(false);
        // add badge
       // addBadgeAt(2, 5);

        slideMenuLayout.addOnSlideChangedListener(new OnSlideChangedListener() {
            @Override
            public void onSlideChanged(SlideMenuLayout slideMenu, boolean isLeftSlideOpen, boolean isRightSlideOpen) {
                Log.e( "<<onSlideChanged",isLeftSlideOpen +"onResume" );
                }
        });
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

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.iv_menu:
                slideMenuLayout.toggleLeftSlide();
                break;
        }
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
