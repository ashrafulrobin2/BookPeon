package bookpeon.cutprice.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.activity.ActivityHome;
import bookpeon.cutprice.com.activity.ActivitySetting;
import bookpeon.cutprice.com.activity.SplashActivity;
import bookpeon.cutprice.com.base.BaseFragment;
import bookpeon.cutprice.com.statusbar.StatusBarUtil;


public class AccountFragment extends BaseFragment {
    TextView tvSettings;

    public AccountFragment() {
    }

    @Override
    public int initFragmentLayout() {
        return R.layout.fragment_account;

    }

    @Override
    public void initFragmentBundleData(Bundle bundle) {

    }

    @Override
    public void initFragmentViews(View parentView) {
        StatusBarUtil.immersive(getActivity(),getResources().getColor( R.color.app_same_primary_color ));

        tvSettings = (TextView)parentView.findViewById( R.id.tv_settings );
    }

    @Override
    public void initFragmentViewsData() {

    }

    @Override
    public void initFragmentActions() {

        tvSettings.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intentSetting = new Intent(getActivity(), ActivitySetting.class);
                startActivity(intentSetting);
            }
        } );
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
