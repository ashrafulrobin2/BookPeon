package bookpeon.cutprice.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.base.BaseFragment;


/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ProductsFragment extends BaseFragment {

    private RecyclerView rvCheckoutFood;
   // private CheckoutFoodAdapter checkoutFoodAdapter;

    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        return fragment;
    }

    @Override
    public int initFragmentLayout() {
        return R.layout.fragment_payment_view;
    }

    @Override
    public void initFragmentBundleData(Bundle bundle) {

    }

    @Override
    public void initFragmentViews(View parentView) {
      //  rvCheckoutFood = (RecyclerView) parentView.findViewById(R.id.rv_checkout_food);
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