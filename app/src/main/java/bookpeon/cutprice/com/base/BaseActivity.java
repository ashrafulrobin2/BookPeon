package bookpeon.cutprice.com.base;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.util.RuntimePermissionManager;

import static bookpeon.cutprice.com.util.RuntimePermissionManager.REQUEST_CODE_PERMISSION;


/**
 * @author Md. Rashadul Alam
 * Email: rashed.droid@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    private BaseActivity mActivity;
    public Bundle mSavedInstanceState;
    public String TAG;
    public ProgressDialog mProgressDialog;
    private PERMISSION_TYPE mPermissionType;
    public List<String> mDefaultPermissions = new ArrayList<>();
    private List<String> mPermissions = new ArrayList<>();
    private BaseUpdateListener mRuntimePermissionUpdateListener;

    public enum PERMISSION_TYPE {ACTIVITY, TASK}

    //Abstract declaration
    public abstract String[] initActivityPermissions();

    public abstract int initActivityLayout();

    public abstract void initStatusBarView();

    public abstract void initNavigationBarView();

    public abstract void initIntentData(Bundle savedInstanceState, Intent intent);

    public abstract void initActivityViews();

    public abstract void initActivityViewsData(Bundle savedInstanceState);

    public abstract void initActivityActions(Bundle savedInstanceState);

    public abstract void initActivityOnResult(int requestCode, int resultCode, Intent data);

    public abstract void initActivityBackPress();

    public abstract void initActivityDestroyTasks();

    public void setRuntimePermissionUpdateListener(BaseUpdateListener runtimePermissionUpdateListener) {
        this.mRuntimePermissionUpdateListener = runtimePermissionUpdateListener;
    }

    public void initRuntimePermissions(PERMISSION_TYPE permissionType, String[] runtimePermissions, BaseUpdateListener baseUpdateListener) {
        mPermissionType = permissionType;
        mRuntimePermissionUpdateListener = baseUpdateListener;

        //Process permissions with default permissions
        mPermissions.clear();
        mPermissions.addAll(mDefaultPermissions);
        if (runtimePermissions != null && runtimePermissions.length > 0) {
            for (String permission : runtimePermissions) {
                if (!isPermissionExist(permission)) {
                    mPermissions.add(permission);
                }
            }
        }

        //Check permissions
        if (checkAndRequestRuntimePermissions(mPermissions)) {
            switch (permissionType) {
                case ACTIVITY:
                    initActivityViewsData(mSavedInstanceState);
                    initActivityActions(mSavedInstanceState);
                    break;
                case TASK:
                    break;
            }
        }
    }

    public abstract void initActivityPermissionResult(int requestCode, String permissions[], int[] grantResults);

    public BaseActivity() {
        this.mActivity = this;
        this.TAG = getClass().getSimpleName();
        this.mDefaultPermissions = new ArrayList<String>() {{
            //For internet
            add(Manifest.permission.INTERNET);
            add(Manifest.permission.ACCESS_NETWORK_STATE);
            //For image caching
            add(Manifest.permission.READ_EXTERNAL_STORAGE);
            add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//            //For phone state
//            add(Manifest.permission.READ_PHONE_STATE);
        }};
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initActivityLayout());

        mSavedInstanceState = savedInstanceState;
        initStatusBarView();
        initNavigationBarView();
        initIntentData(mSavedInstanceState, getIntent());
        initActivityViews();
        initRuntimePermissions(PERMISSION_TYPE.ACTIVITY, initActivityPermissions(), mRuntimePermissionUpdateListener);
    }

    public Activity getActivity() {
        return mActivity;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        try {
            super.onRestoreInstanceState(savedInstanceState);

            mSavedInstanceState = savedInstanceState;
        } catch (Exception e) {
            e.printStackTrace();
//            Intent intent = new Intent(this, BaseLocationActivity.class);
//            startActivity(intent);
        }
    }

    /********************
     * Fragment methods *
     ********************/
    protected void initFragment(int containerViewId, BaseFragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, tag).commitAllowingStateLoss();
    }

    protected void addFragment(int containerViewId, BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment).commitAllowingStateLoss();
    }

    protected <F extends BaseFragment> void addFragment(int containerViewId, Class<F> fragmentClazz) {
        F frg = createFragment(fragmentClazz, getIntent().getExtras());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, frg).commitAllowingStateLoss();
    }

    public static <T extends BaseFragment> T createFragment(Class<T> fragmentClazz, Bundle args) {
        T fragment = null;
        try {
            fragment = fragmentClazz.newInstance();
            fragment.setArguments(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }

    /**********************
     * Permission methods *
     **********************/
    public List<String> getPermissions() {
        return mPermissions;
    }

    private boolean checkAndRequestRuntimePermissions(List<String> permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!RuntimePermissionManager.isAllPermissionsGranted(mActivity, permissions)) {
                ArrayList<String> permissionNeeded = RuntimePermissionManager.getAllUnGrantedPermissions(mActivity, permissions);
                ActivityCompat.requestPermissions(this, permissionNeeded.toArray(new String[permissionNeeded.size()]), REQUEST_CODE_PERMISSION);
                return false;
            }
        }

        //Update about runtime permission update if there any listener assigned.
        if (mRuntimePermissionUpdateListener != null) {
            mRuntimePermissionUpdateListener.onUpdate(true);
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        initActivityPermissionResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE_PERMISSION:
                if (RuntimePermissionManager.isAllPermissionsGranted(mActivity, permissions)) {
                    //Update about runtime permission update if there any listener assigned.
                    if (mRuntimePermissionUpdateListener != null) {
                        mRuntimePermissionUpdateListener.onUpdate(true);
                    }

                    switch (mPermissionType) {
                        case ACTIVITY:
                            initActivityViewsData(mSavedInstanceState);
                            initActivityActions(mSavedInstanceState);
                            break;
                        case TASK:
                            break;
                    }
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initActivityOnResult(requestCode, resultCode, data);

        //send on activity result event to the fragment
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (fragmentList != null) {
            for (Fragment fragment : fragmentList) {
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onFragmentResult(requestCode, resultCode, data);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        initActivityBackPress();

        //send back press event to the fragment
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (fragmentList != null) {
            for (Fragment fragment : fragmentList) {
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onFragmentBackPressed();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        initActivityDestroyTasks();

        super.onDestroy();
    }

    public String[] getPermissions(List<String> permissions) {
        String permissionsList[] = new String[]{};
        if (permissions != null && permissions.size() > 0) {
            for (int i = 0; i < permissions.size(); i++) {
                permissionsList[i] = permissions.get(i);
            }
        }
        return permissionsList;
    }

    public boolean isPermissionExist(String permission) {
        for (String mPermission : mDefaultPermissions) {
            if (permission.equalsIgnoreCase(mPermission)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /***************************
     * Progress dialog methods *
     ***************************/
    public ProgressDialog showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getResources().getString(R.string.view_loading));
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface arg0) {
                    if (mProgressDialog != null && mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                        mProgressDialog = null;
                    }
                }
            });
        }

        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

        return mProgressDialog;
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}