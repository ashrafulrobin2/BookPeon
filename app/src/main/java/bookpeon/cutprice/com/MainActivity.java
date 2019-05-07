package bookpeon.cutprice.com;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import bookpeon.cutprice.com.activity.ActivitySearch;
import bookpeon.cutprice.com.activity.ActivityWishList;
import bookpeon.cutprice.com.fragment.AccountFragment;
import bookpeon.cutprice.com.fragment.HomeFragment;
import bookpeon.cutprice.com.fragment.PaymentLandingFragment;
import bookpeon.cutprice.com.fragment.ProductsFragment;
import bookpeon.cutprice.com.util.CommonContents;
import cn.ymex.popup.controller.AlertController;
import cn.ymex.popup.dialog.PopupDialog;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Fragment fragment = null;
    private FrameLayout fm;
    private Toolbar toolbar;
    public TextView txttoolbar;
    private TextView tvDrawerCategory,tvDrawerWishlist,tvDrawerNotification,tvDrawerContact,tvDrawerAbout,tvDrawerLogout;
    private ImageView ivSearch,ivMenu;
    LinearLayout llMenuCategory,llMenuWishlist,llMenuNotification,llMenuContact,llMenuAbout,llMenuLogout;
    private Context context;
    BottomNavigationViewEx bottomNve;
    private int currentMenuId = 0;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        context = this;
        // Setup ToolBar
        initToolBarSetUp();
        //  initialize UI
        initUI();
        // Setup drawer view
        //initDrawerSetup();
        // Setup Fragment view
        initFragment();
        initBottomNavAction();
    }




    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        toolbar.setVisibility( View.VISIBLE );
        fragment = new HomeFragment();
        fragmentManager.beginTransaction().replace( R.id.frame_container, fragment ).commit();
    }

    private void initToolBarSetUp() {
        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );

        toolbar = (Toolbar) findViewById( R.id.toolbar );
        txttoolbar = (TextView) toolbar.findViewById( R.id.txttoolbar );
        ivMenu = (ImageView)  toolbar.findViewById( R.id.iv_menu );
        ivSearch = (ImageView)  toolbar.findViewById( R.id.iv_search );

        txttoolbar.setText( "CutPrice" );
       // setSupportActionBar( toolbar );


    }


    private void initUI() {
        fm = (FrameLayout) findViewById( R.id.frame_container );
        // Navigation drawer declaration
        mDrawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        nvDrawer = (NavigationView) findViewById( R.id.nav_view );
        bottomNve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        bottomNve.enableAnimation(false);
        bottomNve.enableShiftingMode(false);
        bottomNve.enableItemShiftingMode(false);
        llMenuCategory = (LinearLayout) findViewById( R.id.ll_menu_category );
        llMenuWishlist = (LinearLayout) findViewById( R.id.ll_menu_wishlist );
        llMenuNotification = (LinearLayout) findViewById( R.id.ll_menu_notification );
        llMenuContact = (LinearLayout) findViewById( R.id.ll_menu_contact );
        llMenuAbout = (LinearLayout) findViewById( R.id.ll_menu_about );
        llMenuLogout = (LinearLayout) findViewById( R.id.ll_menu_logout );
        tvDrawerCategory = (TextView) findViewById( R.id.tv_drawer_category );
        tvDrawerWishlist = (TextView) findViewById( R.id.tv_drawer_wishlist );
        tvDrawerNotification = (TextView) findViewById( R.id.tv_drawer_notification );
        tvDrawerContact = (TextView) findViewById( R.id.tv_drawer_contact );
        tvDrawerAbout = (TextView) findViewById( R.id.tv_drawer_about );
        tvDrawerLogout = (TextView) findViewById( R.id.tv_drawer_logout );

//        lyt_item_home = (MaterialRippleLayout) findViewById(R.id.lyt_item_home);
//        lyt_item_home.setOnClickListener(this);
        tvDrawerCategory.setTypeface( typeface );
        tvDrawerWishlist.setTypeface( typeface );
        tvDrawerNotification.setTypeface( typeface );
        tvDrawerContact.setTypeface( typeface );
        tvDrawerAbout.setTypeface( typeface );
        tvDrawerLogout.setTypeface( typeface );
        llMenuCategory.setOnClickListener( this );
        llMenuWishlist.setOnClickListener( this );
        llMenuLogout.setOnClickListener( this );

        ivSearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSearch = new Intent(getApplicationContext(), ActivitySearch.class);
                startActivity(intentSearch);
            }
        } );
    }

    /*
     * Closes or opens the drawer
     */
    private void handleOrderDrawer()
    {
        if (mDrawer != null)
        {
            if (mDrawer.isDrawerOpen(GravityCompat.START))
            {
                mDrawer.closeDrawer(GravityCompat.START);
            } else
            {
                mDrawer.openDrawer(GravityCompat.START);
            }
        }
    }

    private void initDrawerSetup() {
        drawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override

                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        selectDrawerItem( menuItem );
                        return true;
                    }
                } );
    }


    @Override
    public void onClick(View v) {

        toolbar.setVisibility( View.VISIBLE );

        switch (v.getId()) {

            case R.id.ll_menu_category:
                fragment = new HomeFragment();
                mDrawer.closeDrawers();
                loadFragment(fragment);
                break;
            case R.id.ll_menu_wishlist:
                Intent intentReg = new Intent(getApplicationContext(), ActivityWishList.class);
                startActivity(intentReg);
                break;
            case R.id.ll_menu_logout:
               logOutDialog( getResources().getString( R.string.dialog_logout_title ), getResources().getString( R.string.dialog_logout_mgs ) );
                break;

        }


    }

    private void showToast(String msg) {
        Toast.makeText( getApplicationContext(), msg, Toast.LENGTH_SHORT ).show();
    }

    private void initBottomNavAction() {
        ivMenu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOrderDrawer();
               // mDrawer.isDrawerOpen( GravityCompat.START);
            }
        } );

        bottomNve.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                navigationMenuChanged(item);
                return true;
            }
        } );

    }

    private void navigationMenuChanged(MenuItem menuItem) {
        openFragment(menuItem.getItemId());
        menuItem.setChecked(true);
    }


    public void openFragment(int menuId) {

        switch (menuId) {
            case R.id.item_home:
                fragment = new HomeFragment();
                loadFragment(fragment);
                toolbar.setVisibility( View.VISIBLE );


                break;

            case R.id.item_search2:

                break;

            case R.id.item_search:
//                Intent intentCheckout = new Intent(getApplicationContext(), ActivityCheckout.class);
//                startActivity(intentCheckout);


                fragment = new PaymentLandingFragment();
                loadFragment(fragment);
                toolbar.setVisibility( View.GONE );
                Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_accounts:

                fragment = new AccountFragment();
                loadFragment(fragment);
                toolbar.setVisibility( View.GONE );
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

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
     //   transaction.addToBackStack(null);
        transaction.commit();
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

//            case R.id.drawer_item_home:
//                fragment = new Fragment();
//
//                txttoolbar.setText("Basic Info");
//                Toast.makeText(PatientMainActivity.this, "Click..", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.drawer_item_:
//                fragment = new Fragment();
//
//                txttoolbar.setText("ShasthoNet");
//                Toast.makeText(PatientMainActivity.this, "Click..", Toast.LENGTH_SHORT).show();
//                break;
        }

        if (fragment != null) {

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace( R.id.frame_container, fragment ).commit();
            // Highlight the selected item, update the title, and close the drawer

            menuItem.setChecked( true );
            setTitle( menuItem.getTitle() );
            mDrawer.closeDrawers();
        }
    }


    @Override

    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate( savedInstanceState );
      //  drawerToggle.syncState();

    }

    @Override

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged( newConfig );

        // Pass any configuration change to the drawer toggles

       // drawerToggle.onConfigurationChanged( newConfig );
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder( this ).setIcon( R.mipmap.logo_icon ).setTitle( "Close" )
                .setMessage( "Do you want to exit the apps?" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent( Intent.ACTION_MAIN );
                        intent.addCategory( Intent.CATEGORY_HOME );
                        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
                        startActivity( intent );
                        finish();
                    }
                } ).setNegativeButton( "No ", null ).show();

    }
    /**
     * Log out
     */
    public void logOutDialog(String title, String message) {
        PopupDialog.create(this)
                .outsideTouchHide(false)
                .dismissTime(1000 * 5)
                .controller( AlertController.build()
                        .title(title+"\n")
                        .message(message)
                        .negativeButton( getString(R.string.dialog_cancel),null)
                        .positiveButton( getString( R.string.dialog_ok ), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

//                                CommonTask.setBooleanSetting(getActivity(), CommonContents.isLoggedIn, false);
//                                CommonTask.setBooleanSetting(getActivity(), CommonContents.INTENT_KEY_LOGIN, false);
                              //  updateMenu();
                            }
                        } ))
                .show();
    }
}
