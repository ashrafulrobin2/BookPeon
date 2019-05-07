package bookpeon.cutprice.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.activity.ActivityDirectSell2;
import bookpeon.cutprice.com.base.BaseFragment;
import co.ceryle.segmentedbutton.SegmentedButton;
import co.ceryle.segmentedbutton.SegmentedButtonGroup;


/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ShippingFragment extends BaseFragment {

    private RecyclerView rvCheckoutFood;
   // private CheckoutFoodAdapter checkoutFoodAdapter;
   SegmentedButtonGroup sgbPayoutPlace;
    SegmentedButton sgPayPlacce;

    public static ShippingFragment newInstance() {
        ShippingFragment fragment = new ShippingFragment();
        return fragment;
    }

    @Override
    public int initFragmentLayout() {
        return R.layout.fragment_shipping_view;
    }

    @Override
    public void initFragmentBundleData(Bundle bundle) {

    }

    @Override
    public void initFragmentViews(View parentView) {
        sgbPayoutPlace = (SegmentedButtonGroup) parentView. findViewById(R.id.sgb_payout_now);
        sgPayPlacce = (SegmentedButton) parentView. findViewById(R.id.sb_pay_now);
        sgPayPlacce.setEnabled( true );
        //  rvCheckoutFood = (RecyclerView) parentView.findViewById(R.id.rv_checkout_food);
        sgbPayoutPlace.setPosition( 0 );

    }

    @Override
    public void initFragmentViewsData() {
//        checkoutFoodAdapter = new CheckoutFoodAdapter(getActivity());
//        rvCheckoutFood.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rvCheckoutFood.setAdapter(checkoutFoodAdapter);
//        checkoutFoodAdapter.addAll(AppUtil.getAllStoredFoodItems(getActivity()));
    }

    @Override
    public void initFragmentActions() {
        sgbPayoutPlace.setOnClickedButtonListener( new SegmentedButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(int position) {
                if (position == 0) {
                } else if (position == 1) {
                    Intent intentDirectSell = new Intent(getActivity(), ActivityDirectSell2.class);
                    startActivity(intentDirectSell);
                    //  Toast.makeText(ActivityProductBids2.this, "Buy Now", Toast.LENGTH_SHORT).show();

                }
            }
        } );
    }

    @Override
    public void initFragmentBackPress() {

    }

    @Override
    public void initFragmentOnResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void initFragmentUpdate(Object object) {

    }

//    public boolean isAllFieldsVerified() {
//        if (checkoutFoodAdapter.getCount() > 0) {
//            return true;
//        } else {
//            Toast.makeText(getActivity(), getString(R.string.toast_please_add_to_cart_first), Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }
}