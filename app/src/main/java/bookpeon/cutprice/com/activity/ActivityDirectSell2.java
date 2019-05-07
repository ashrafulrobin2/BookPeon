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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.ArrayList;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.adapters.RecyclerViewDataAdapter;
import bookpeon.cutprice.com.base.BaseActivity;
import bookpeon.cutprice.com.model.SectionDataModel;
import bookpeon.cutprice.com.model.SingleItemModel;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

public class ActivityDirectSell2 extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txttoolbar;
    ImageView iv_back;
    private MaterialRippleLayout mrBack;
    Typeface typeface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_direct_sell_screen);

        //  initStatusBar();
        initActivityViews();
    }

//    private void initStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setTransparent(SplashActivity.this);
//    }

    public void initActivityViews() {
        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
        txttoolbar.setText( "Order" );

        iv_back = (ImageView) findViewById( R.id.iv_back );
        mrBack = (MaterialRippleLayout) findViewById( R.id.mr_back );

        iv_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );
        mrBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );


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



}
