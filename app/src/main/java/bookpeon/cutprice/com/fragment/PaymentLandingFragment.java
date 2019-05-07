package bookpeon.cutprice.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.badoualy.stepperindicator.StepperIndicator;
import com.balysv.materialripple.MaterialRippleLayout;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.adapters.CheckoutPagerAdapter;
import bookpeon.cutprice.com.base.BaseFragment;
import bookpeon.cutprice.com.view.LockableViewPager;


public class PaymentLandingFragment extends BaseFragment {

    private Toolbar toolbar;
    private TextView txttoolbar,txtBackTitle;
    ImageView iv_back;
    private MaterialRippleLayout mrBack;
    private LockableViewPager vpCheckout;
    private CheckoutPagerAdapter checkoutPagerAdapter;
    private StepperIndicator stepperIndicator;

    public PaymentLandingFragment() {
    }

    @Override
    public int initFragmentLayout() {
        return R.layout.fragment_payment_process;

    }

    @Override
    public void initFragmentBundleData(Bundle bundle) {

    }

    @Override
    public void initFragmentViews(View parentView) {
       // StatusBarUtil.immersive(getActivity(),getResources().getColor( R.color.app_same_primary_color ));
        toolbar = (Toolbar) parentView.findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
        txtBackTitle = (TextView) toolbar.findViewById(R.id.txt_back_title);
        txtBackTitle.setText( "Payment" );
        iv_back = (ImageView) parentView.findViewById( R.id.iv_back );
        mrBack = (MaterialRippleLayout) parentView.findViewById( R.id.mr_back );
        vpCheckout = (LockableViewPager)parentView.findViewById(R.id.vp_checkout);
        stepperIndicator = (StepperIndicator)parentView.findViewById(R.id.stepper_indicator_checkout);

        checkoutPagerAdapter = new CheckoutPagerAdapter(getFragmentManager());
        vpCheckout.setAdapter(checkoutPagerAdapter);
        vpCheckout.setSwipable(true);
        stepperIndicator.setViewPager(vpCheckout, false);
    }

    @Override
    public void initFragmentViewsData() {

    }

    @Override
    public void initFragmentActions() {

/*
        vpCheckout.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //this variable is needed for the very first time viewpage fragment selection
            boolean first = true;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (first && positionOffset == 0 && positionOffsetPixels == 0) {
                    onPageSelected(0);
                    first = false;
                }
            }

            @Override
            public void onPageSelected(int position) {
                int lastPagePosition = checkoutPagerAdapter.getCount() - 1;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
               // Logger.d(TAG, "onPageScrollStateChanged: " + "state: " + state);
            }
        });
*/
    }

    @Override
    public void initFragmentBackPress() {

    }

    @Override
    public void initFragmentUpdate(Object object) {

    }

    @Override
    public void initFragmentOnResult(int requestCode, int resultCode, Intent data) {

    }





}
