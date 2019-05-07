package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.base.BaseUpdateListener;
import bookpeon.cutprice.com.util.AllSettingsManager;
import bookpeon.cutprice.com.util.AppUtil;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ActivitySetting extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txttoolbar;
    ImageView iv_back;
    private MaterialRippleLayout mrBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_setting);

      //  initStatusBar();
        // Setup ToolBar
        initToolBarSetUp();
        initActivityViews();

    }

    private void initToolBarSetUp() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
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

//    private void initStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setTransparent(SplashActivity.this);
//    }

    public void initActivityViews() {

    }


}