package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.ArrayList;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.base.BaseActivity;
import bookpeon.cutprice.com.model.SectionDataModel;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

public class ActivityDirectSell extends BaseActivity {
    private Toolbar toolbar;
    private TextView txttoolbar;
    ImageView iv_back;
    private MaterialRippleLayout mrBack;
    Typeface typeface;

    @Override
    public String[] initActivityPermissions() {
        return new String[]{};
    }

    @Override
    public int initActivityLayout() {
        return R.layout.activity_direct_sell_screen;
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
        txttoolbar.setText( "Order" );

        iv_back = (ImageView) findViewById( R.id.iv_back );
        mrBack = (MaterialRippleLayout) findViewById( R.id.mr_back );
    }

    @Override
    public void initActivityViewsData(Bundle savedInstanceState) {

    }

    @Override
    public void initActivityActions(Bundle savedInstanceState) {
//        iv_back.setOnClickListener(new OnSingleClickListener() {
//            @Override
//            public void onSingleClick(View view) {
//                initActivityBackPress();
//            }
//        });

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

    }

    @Override
    public void initActivityDestroyTasks() {

    }

    @Override
    public void initActivityPermissionResult(int requestCode, String[] permissions, int[] grantResults) {

    }
}
