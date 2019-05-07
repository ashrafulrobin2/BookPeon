package bookpeon.cutprice.com.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.badoualy.stepperindicator.StepperIndicator;
import com.balysv.materialripple.MaterialRippleLayout;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.adapters.CheckoutPagerAdapter;
import bookpeon.cutprice.com.view.LockableViewPager;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ActivityCheckout extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txtBackTitle;
    ImageView iv_back;
    private MaterialRippleLayout mrBack;
    private LockableViewPager vpCheckout;
    private CheckoutPagerAdapter checkoutPagerAdapter;
    private StepperIndicator stepperIndicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.fragment_payment_process );

      //  initStatusBar();
        // Setup ToolBar
        initToolBarSetUp();
        initActivityViews();

    }

    private void initToolBarSetUp() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        vpCheckout = (LockableViewPager)findViewById(R.id.vp_checkout);
        stepperIndicator = (StepperIndicator)findViewById(R.id.stepper_indicator_checkout);

        checkoutPagerAdapter = new CheckoutPagerAdapter(getSupportFragmentManager());
        vpCheckout.setAdapter(checkoutPagerAdapter);
        vpCheckout.setSwipable(true);
        stepperIndicator.setViewPager(vpCheckout, false);
    }


}