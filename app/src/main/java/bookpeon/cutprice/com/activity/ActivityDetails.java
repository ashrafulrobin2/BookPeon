package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.ArrayList;

import bookpeon.cutprice.com.MainActivity;
import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.adapters.RecyclerViewDataAdapter;
import bookpeon.cutprice.com.base.BaseActivity;
import bookpeon.cutprice.com.model.SectionDataModel;
import bookpeon.cutprice.com.model.SingleItemModel;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ActivityDetails extends BaseActivity {

    private Toolbar toolbar;
    private TextView txttoolbar;
    ImageView iv_back;
    private MaterialRippleLayout mrBack;
    LinearLayout linBuyNow;
    Typeface typeface;
    ArrayList<SectionDataModel> allSampleData;
    RecyclerView recyclerView;
    @Override
    public String[] initActivityPermissions() {
        return new String[]{};
    }

    @Override
    public int initActivityLayout() {
        return R.layout.activity_product_detail2;
    }

    @Override
    public void initStatusBarView() {

    }

    @Override
    public void initNavigationBarView() {

    }

    @Override
    public void initIntentData(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    public void initActivityViews() {
        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );
        allSampleData = new ArrayList<SectionDataModel>();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
        txttoolbar.setVisibility( View.VISIBLE );
        txttoolbar.setText( "The Third Heaven" );

        iv_back = (ImageView) findViewById( R.id.iv_back );
        mrBack = (MaterialRippleLayout) findViewById( R.id.mr_back );
        linBuyNow = (LinearLayout)findViewById(R.id.lin_buy_now);
        createDummyData();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getApplicationContext(), allSampleData);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initActivityViewsData(Bundle savedInstanceState) {

    }

    @Override
    public void initActivityActions(Bundle savedInstanceState) {

        linBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDirectSell = new Intent(getActivity(), ActivityDirectSell.class);
                startActivity(intentDirectSell);
            }
        });

        iv_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initActivityBackPress();
            }
        } );
        mrBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initActivityBackPress();
            }
        } );


    }

    @Override
    public void initActivityOnResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void initActivityBackPress() {

      finish();
    }

    @Override
    public void initActivityDestroyTasks() {

    }

    @Override
    public void initActivityPermissionResult(int requestCode, String[] permissions, int[] grantResults) {

    }

//
//    private Toolbar toolbar;
//    private TextView txttoolbar;
//    ImageView iv_back;
//    private MaterialRippleLayout mrBack;
//
//    Typeface typeface;
//    ArrayList<SectionDataModel> allSampleData;
//    RecyclerView recyclerView;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView( R.layout.activity_product_detail2);
//
//      //  initStatusBar();
//        initActivityViews();
//    }
//
////    private void initStatusBar() {
////        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
////        StatusBarUtil.setTransparent(SplashActivity.this);
////    }
//
//    public void initActivityViews() {
//        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );
//        allSampleData = new ArrayList<SectionDataModel>();
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
//        txttoolbar.setText( "The Third Heaven" );
//
//        iv_back = (ImageView) findViewById( R.id.iv_back );
//        mrBack = (MaterialRippleLayout) findViewById( R.id.mr_back );
//        createDummyData();
//        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//
//        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getApplicationContext(), allSampleData);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
//
//        recyclerView.setAdapter(adapter);
//        iv_back.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        } );
//        mrBack.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        } );
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == android.R.id.home) {
//            finish();
//            //  this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//            return true;
//        }
//
//        return super.onOptionsItemSelected( item );
//    }
//
//
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
}