package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jkb.slidemenu.SlideMenuLayout;

import java.util.ArrayList;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.adapters.RecyclerViewDataAdapter;
import bookpeon.cutprice.com.base.BaseActivity;
import bookpeon.cutprice.com.fragment.HomeFragment;
import bookpeon.cutprice.com.model.SectionDataModel;
import bookpeon.cutprice.com.model.SingleItemModel;
import cn.ymex.popup.controller.AlertController;
import cn.ymex.popup.dialog.PopupDialog;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ActivityDetails2 extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private TextView txttoolbar;
    ImageView iv_back,ivSideMenu;
    private MaterialRippleLayout mrBack;
    private TextView tvDrawerCategory,tvDrawerWishlist,tvDrawerNotification,tvDrawerContact,tvDrawerAbout,tvDrawerLogout;
    LinearLayout llMenuCategory,llMenuWishlist,llMenuNotification,llMenuContact,llMenuAbout,llMenuLogout;
    private Fragment fragment = null;

    LinearLayout linBuyNow;
    Typeface typeface;
    ArrayList<SectionDataModel> allSampleData;
    RecyclerView recyclerView;
    private SlideMenuLayout slideMenuLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_product_detail2);

      //  initStatusBar();
        initActivityViews();
    }

//    private void initStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setTransparent(SplashActivity.this);
//    }

    public void initActivityViews() {
        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );
        allSampleData = new ArrayList<SectionDataModel>();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
        txttoolbar.setText( "The Third Heaven" );

        iv_back = (ImageView) toolbar.findViewById( R.id.iv_back );
        ivSideMenu = (ImageView)toolbar. findViewById( R.id.iv_side_menu );
        mrBack = (MaterialRippleLayout)toolbar. findViewById( R.id.mr_back );
        mDrawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        nvDrawer = (NavigationView) findViewById( R.id.nav_view );
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
        tvDrawerLogout = (TextView) findViewById( R.id.tv_drawer_logout);
        linBuyNow = (LinearLayout)findViewById(R.id.lin_buy_now);

        createDummyData();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getApplicationContext(), allSampleData);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);

        mrBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );


        linBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDirectSell = new Intent(getApplicationContext(), ActivityDirectSell2.class);
                startActivity(intentDirectSell);
            }
        });

     //   slideMenuLayout.setOnClickListener( this );
        tvDrawerCategory.setTypeface( typeface );
        tvDrawerWishlist.setTypeface( typeface );
        tvDrawerNotification.setTypeface( typeface );
        tvDrawerContact.setTypeface( typeface );
        tvDrawerAbout.setTypeface( typeface );
        tvDrawerLogout.setTypeface( typeface );
        llMenuCategory.setOnClickListener( this );
        llMenuWishlist.setOnClickListener( this );
        llMenuLogout.setOnClickListener( this );
        ivSideMenu.setOnClickListener( this );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            //  this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            return true;
        }

        return super.onOptionsItemSelected( item );
    }


    public void createDummyData() {

        ArrayList<SectionDataModel> sectionDataModels = new ArrayList<>(  );


        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleItemModel("Book Name ", ""));

        }

        SectionDataModel dm = new SectionDataModel("Related Products",singleItem);
        allSampleData.add(dm);
        ArrayList<SingleItemModel> singleItem2 = new ArrayList<SingleItemModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleItemModel("Book Name2 ", "" ));

        }
        SectionDataModel dm2 = new SectionDataModel("Related Products",singleItem2);

        allSampleData.add(dm2);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_side_menu:
                handleOrderDrawer();
                break;
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

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

    /*
     * Closes or opens the drawer
     */
    private void handleOrderDrawer()
    {
        if (mDrawer != null)
        {
            if (mDrawer.isDrawerOpen( GravityCompat.START))
            {
                mDrawer.closeDrawer(GravityCompat.START);
            } else
            {
                mDrawer.openDrawer(GravityCompat.START);
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