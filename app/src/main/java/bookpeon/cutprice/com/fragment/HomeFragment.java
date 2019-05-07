package bookpeon.cutprice.com.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jkb.slidemenu.OnSlideChangedListener;
import com.jkb.slidemenu.SlideMenuLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.activity.ActivityDetails;
import bookpeon.cutprice.com.activity.ActivitySearch;
import bookpeon.cutprice.com.adapters.RecyclerViewDataAdapter;
import bookpeon.cutprice.com.adapters.SearchDropDownMenuAdapter;
import bookpeon.cutprice.com.base.BaseFragment;
import bookpeon.cutprice.com.model.SectionDataModel;
import bookpeon.cutprice.com.model.SingleItemModel;
import bookpeon.cutprice.com.model.commonparams.ParamsApiKey;
import bookpeon.cutprice.com.model.getmenu.DataResponse;
import bookpeon.cutprice.com.model.getmenu.MenuCategory;
import bookpeon.cutprice.com.model.getmenu.SubCategory;
import bookpeon.cutprice.com.network.NetworkManager;
import bookpeon.cutprice.com.retrofit.APIClient;
import bookpeon.cutprice.com.retrofit.APIInterface;
import bookpeon.cutprice.com.retrofit.APIResponse;
import bookpeon.cutprice.com.statusbar.StatusBarUtil;
import bookpeon.cutprice.com.util.Logger;
import retrofit2.Call;
import retrofit2.Response;
import tech.codegarage.dropdownmenuplus.DropDownMenu;
import tech.codegarage.dropdownmenuplus.interfaces.OnFilterDoneListener;
import tech.codegarage.dropdownmenuplus.model.FilterBean;
import tech.codegarage.dropdownmenuplus.model.ItemBean;
import tech.codegarage.dropdownmenuplus.model.TitleBean;

import static bookpeon.cutprice.com.util.CommonContents.API_KEY;


public class HomeFragment extends BaseFragment {

    private Toolbar toolbar;
    private TextView txttoolbar;
    ImageView ivSearch,ivMenu;
    NestedScrollView scrollView;
    ArrayList<SectionDataModel> allSampleData;

    private LinearLayout appbar_layout;
    RecyclerView my_recycler_view;
    RecyclerViewDataAdapter adapter;
    //Dropdown menu
    private String[] titleList;
    private DropDownMenu dropDownMenu;
    private FilterBean filterBean = new FilterBean();
    private SearchDropDownMenuAdapter searchDropDownMenuAdapter;
    private ItemBean mSelectedArea, mSelectedCuisine;

    private List<MenuCategory> menuCategoryList;
    private List<SubCategory> subCategories;
    //Background task
    private APIInterface mApiInterface;
    private GetAllMenuCategoryTask getAllMenuCategoryTask;

    @Override
    public int initFragmentLayout() {
        return R.layout.fragment_home;

    }

    @Override
    public void initFragmentBundleData(Bundle bundle) {

    }

    @Override
    public void initFragmentViews(View parentView) {
        StatusBarUtil.immersive(getActivity(),getResources().getColor( R.color.colorWhite ));
        mApiInterface = APIClient.getClient(getActivity()).create(APIInterface.class);

//        if (!NetworkManager.isInternetAvailable(getActivity())) {
//          //  loadOfflineDropdownData();
//         //   tvSuggestion.setText(getString(R.string.view_please_connect_internet_and_retry));
//            Toast.makeText( getActivity(), getResources().getString( R.string.internet_error_msg ), Toast.LENGTH_SHORT ).show();
//
//        } else {
//            //Update app user
//            ParamsApiKey paramApiKey = new ParamsApiKey(API_KEY);
//            Logger.d(TAG, TAG + " >>> " + "paramApiKey: " + paramApiKey.toString());
////
////            getAllMenuCategoryTask = new GetAllMenuCategoryTask(getActivity(),paramApiKey);
////            getAllMenuCategoryTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//        }
        allSampleData = new ArrayList<SectionDataModel>();
      //  dropDownMenu = (DropDownMenu) parentView.findViewById(R.id.drop_DownMenu);


//        toolbar = (Toolbar)  parentView.findViewById(R.id.toolbar);
//        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
//        ivSearch = (ImageView)  toolbar.findViewById( R.id.iv_search );
//        ivMenu = (ImageView) toolbar.findViewById( R.id.iv_menu );
//        txttoolbar.setText( "CutPrice" );
        appbar_layout = (LinearLayout) parentView.findViewById(R.id.appbar_layout);
         my_recycler_view = (RecyclerView) parentView.findViewById(R.id.my_recycler_view);



    }



    @Override
    public void initFragmentViewsData() {
        createDummyData();
        my_recycler_view.setHasFixedSize(true);

        adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

       // initData();
    }

    @Override
    public void initFragmentActions() {



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


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getAllMenuCategoryTask != null && getAllMenuCategoryTask.getStatus() == AsyncTask.Status.RUNNING) {
            getAllMenuCategoryTask.cancel(true);
        }
    }

    public void createDummyData() {

        ArrayList<SectionDataModel> sectionDataModels = new ArrayList<>(  );


        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleItemModel("Book Name ", ""));

        }

        SectionDataModel dm = new SectionDataModel("Fantasay",singleItem);
        allSampleData.add(dm);
        ArrayList<SingleItemModel> singleItem2 = new ArrayList<SingleItemModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleItemModel("Book Name2 ", "" ));

        }
        SectionDataModel dm2 = new SectionDataModel("Fantasay",singleItem2);

        allSampleData.add(dm2);

        ArrayList<SingleItemModel> singleItem3 = new ArrayList<SingleItemModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleItemModel("Book Name3 ", "" ));

        }
        SectionDataModel dm3 = new SectionDataModel("Fantasay",singleItem3);

        allSampleData.add(dm3);
        // dm.setAllItemsInSection(singleItem);


    }

/*
    private void initFilterDropDownView() {
        titleList = new String[]{getActivity().getString(R.string.view_category), getActivity().getString(R.string.view_sub_category)};

//        //绑定数据源
//        dropMenuAdapter = new DropMenuAdapter(this, titleList, this);
//        dropMenuAdapter.setSortListData(sortListData);
//        dropMenuAdapter.setFilterBean(filterBean);
//        dropDownMenu.setMenuAdapter(dropMenuAdapter);
     //   dropDownMenu.visibleDropDownTab(View.VISIBLE);
//        dropDownMenu.setDropDownTabBackground(getResources().getColor(R.color.grey_800));
//        dropDownMenu.setTabDefaultTextColor(getResources().getColor(R.color.white));
        searchDropDownMenuAdapter = new SearchDropDownMenuAdapter(getActivity(), titleList, new OnFilterDoneListener() {
            @Override
            public void onFilterDone(int position, String positionTitle, String urlValue) {
                dropDownMenu.setPositionIndicatorText(position, positionTitle);
                dropDownMenu.close();
            }
        });
        searchDropDownMenuAdapter.setFilterBean(filterBean);
        dropDownMenu.setMenuAdapter(searchDropDownMenuAdapter);

        searchDropDownMenuAdapter.setOnDoubleListViewCallbackListener(new SearchDropDownMenuAdapter.OnDoubleListViewCallbackListener() {
            @Override
            public void onDoubleListViewCallback(TitleBean titleBean, ItemBean subtitleBean) {
                Logger.d(TAG, "searchDropDownMenuAdapter(onDoubleListViewCallback): " + "CityBean: " + titleBean.toString() + "\n" + "AreaBean: " + (subtitleBean == null ? "null" : subtitleBean.toString()));
                 mSelectedArea = subtitleBean;
//
//                initSearchData();
            }
        });

        searchDropDownMenuAdapter.setOnSingleGirdViewCallbackListener(new SearchDropDownMenuAdapter.OnSingleGirdViewCallbackListener() {
            @Override
            public void onSingleGridViewCallback(ItemBean item) {
                Logger.d(TAG, "searchDropDownMenuAdapter(onSingleGridViewCallback): " + "Cuisine: " + item.toString());
                 mSelectedCuisine = item;
//
//                initSearchData();
            }
        });

//        //this is for showing suggestion view
//        rlSuggestion.setVisibility(View.VISIBLE);
//        tvSuggestion.setText(R.string.view_please_select_area_and_cuisine_from_dropdown);
    }
*/


    private class GetAllMenuCategoryTask extends AsyncTask<String, Integer, Response> {

        Context mContext;
        ParamsApiKey mParamApiKey;
        public GetAllMenuCategoryTask(Context context,ParamsApiKey paramApiKeys) {
            mContext = context;
            mParamApiKey = paramApiKeys;
        }

        @Override
        protected void onPreExecute() {
            ProgressDialog progressDialog = showProgressDialog();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    cancel(true);
                }
            });
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
//            Logger.d(TAG, TAG + ">> Background task is cancelled");
//            loadOfflineDropdownData();
        }

        @Override
        protected Response doInBackground(String... params) {
            try {
                Logger.d(TAG, TAG + " >>> " + "AppKey(home-param): " + mParamApiKey.toString());

                Call<APIResponse<DataResponse>> call = mApiInterface.apiGetAllMenuCategory(mParamApiKey);

                Response response = call.execute();
                if (response.isSuccessful()) {
                    return response;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Response result) {
            try {
                if (result != null && result.isSuccessful()) {
                    Logger.d(TAG, "APIResponse(GetAllCityWithTask): onResponse-server = " + result.toString());
                    APIResponse<DataResponse> data = (APIResponse<DataResponse>) result.body();

                    if (data != null && data.getSuccess().equalsIgnoreCase("true")) {
                        Logger.d(TAG, "APIResponse(GetAllCityWithTask()): onResponse-object = " + data.toString());

                        //Initialize city with area data for search tab bar
                        if (data.getResponse() != null) {
                          //  initCityData(data.getData());

                            //Store times data into the session
                          //  SessionManager.setStringSetting(getActivity(), AllConstants.SESSION_KEY_CITY_WITH_AREA, data.toString());

                            //Call cuisine background task
//                            getAllCuisinesTask = new GetAllCuisinesTask(getActivity());
//                            getAllCuisinesTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                        }
                    } else {
                     //   loadOfflineDropdownData();
                        Toast.makeText(getActivity(), getResources().getString(R.string.toast_no_info_found) + ",\n" + getResources().getString(R.string.toast_loaded_offline_data), Toast.LENGTH_SHORT).show();
                    }
                } else {
                  //  loadOfflineDropdownData();
                    Toast.makeText(getActivity(), getResources().getString(R.string.toast_could_not_retrieve_info) + ",\n" + getResources().getString(R.string.toast_loaded_offline_data), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
//
//    private void initData() {
//        menuCategoryList = new ArrayList<>();
//        subCategories = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            SubCategory subCategory = new SubCategory();
//            if (i == 0) {
//                subCategory.setCategories_id(""+i);
//                subCategory.setEn_sub_cat_name("Jeans");
//                subCategories.add(subCategory);
//            } else {
//                subCategory.setCategories_id(""+i);
//                subCategory.setEn_sub_cat_name("Jeans " + i);
//                subCategories.add(subCategory);
//            }
//        }
//
//        for (int i = 0; i < 5; i++) {
//            MenuCategory menuCategory = new MenuCategory();
//            if (i == 0) {
//                menuCategory.setMc_id(""+i);
//                menuCategory.setEn_mc_name("Tk 1 to 99");
//                menuCategoryList.add(menuCategory);
//            } else {
//                menuCategory.setMc_id(""+i);
//                menuCategory.setEn_mc_name("Gents Shopping " + i);
//                menuCategoryList.add(menuCategory);
//            }
//        }
//        initMenuCategoryData(menuCategoryList);
//        initCategoryData(menuCategoryList);
//
//        //Initialize dropdown
//        initFilterDropDownView();
//    }
//
//    private void initMenuCategoryData(List<MenuCategory> menuCategoryList) {
//        List<TitleBean> titleBeans = new ArrayList<>();
//        List<TitleBean> subtitleBeans = new ArrayList<>();
//
//        for (int i = 0; i < menuCategoryList.size(); i++) {
//            List<ItemBean> areaBeans = new ArrayList<>();
//
//            for (int j = 0; j < menuCategoryList.get(i).getSub().size(); j++) {
//                //Insert area
//                SubCategory area = menuCategoryList.get(i).getSub().get(j);
//                ItemBean itemBean = new ItemBean(area.getCategories_id(), area.getEn_sub_cat_name());
//                areaBeans.add(itemBean);
//            }
//
//            //Sort area
//            Collections.sort(areaBeans, new Comparator<ItemBean>() {
//                @Override
//                public int compare(ItemBean itemBean1, ItemBean itemBean2) {
//                    return itemBean1.getName().compareTo(itemBean2.getName());
//                }
//            });
//
//            //Insert city
//            MenuCategory city = menuCategoryList.get(i);
//            TitleBean<ItemBean> subtitleBean = new TitleBean<ItemBean>(city.getMc_id(), city.getEn_mc_name(), areaBeans);
//            subtitleBeans.add(subtitleBean);
//        }
//
//        //Insert division
//        TitleBean<TitleBean> titleBean = new TitleBean<TitleBean>();
//        titleBean.setId("0");
//        titleBean.setName("Gents Shopping");
//        titleBean.setSubtitle((ArrayList<TitleBean>) subtitleBeans);
//        titleBeans.add(titleBean);
//
//        filterBean.setTitleBeans((ArrayList<TitleBean>) titleBeans);
//    }
//
//    private void initCategoryData(List<MenuCategory> menuCategoryList) {
//        List<ItemBean> cuisineBeans = new ArrayList<>();
//        for (int i = 0; i < menuCategoryList.size(); i++) {
//            //Insert cuisine
//            MenuCategory menuCategory = menuCategoryList.get(i);
//            ItemBean itemBean = new ItemBean(menuCategory.getMc_id(), menuCategory.getEn_mc_name());
//            cuisineBeans.add(itemBean);
//        }
//
//        filterBean.setItemBeans((ArrayList<ItemBean>) cuisineBeans);
//    }

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
