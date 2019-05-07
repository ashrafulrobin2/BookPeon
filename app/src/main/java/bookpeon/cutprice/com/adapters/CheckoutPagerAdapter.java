package bookpeon.cutprice.com.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.badoualy.stepperindicator.adapter.SmartFragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bookpeon.cutprice.com.enumeration.CheckoutScreenType;
import bookpeon.cutprice.com.fragment.CheckoutFragment;
import bookpeon.cutprice.com.fragment.ProductsFragment;
import bookpeon.cutprice.com.fragment.ShippingFragment;
import bookpeon.cutprice.com.fragment.CompletedFragment;


/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class CheckoutPagerAdapter extends SmartFragmentStatePagerAdapter {

    private List<CheckoutScreenType> mFragmentsPages = new ArrayList<CheckoutScreenType>();

    public CheckoutPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        mFragmentsPages.clear();
        mFragmentsPages.addAll(Arrays.asList(CheckoutScreenType.values()));
    }

    @Override
    public Fragment getItem(int position) {
        switch (mFragmentsPages.get(position)) {
            case PRODUCT:
                return ProductsFragment.newInstance();
            case SHIPPING:
                return ShippingFragment.newInstance();
            case CHECKOUT:
                return CheckoutFragment.newInstance();
            case COMPLETED:
                return CompletedFragment.newInstance();
            default:
                return ProductsFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mFragmentsPages.size();
    }

    public CheckoutScreenType getScreenType(int position) {
        return mFragmentsPages.get(position);
    }
}