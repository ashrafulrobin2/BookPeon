package bookpeon.cutprice.com.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.activity.ActivityCategory;
import bookpeon.cutprice.com.activity.ActivityDetails;
import bookpeon.cutprice.com.model.SectionDataModel;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

    private ArrayList<SectionDataModel> dataList;
    private Context mContext;

    SectionListDataAdapter itemListDataAdapter;
    public RecyclerViewDataAdapter(Context context, ArrayList<SectionDataModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        if (getItemViewType(i) == 0) {
            ArrayList singleSectionItems = dataList.get(0).getAllItemsInSection();
            final String sectionName = dataList.get(0).getHeaderTitle();
            itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

            itemRowHolder.recycler_view_list.setHasFixedSize(true);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

            itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
            itemRowHolder.itemTitle.setText(sectionName);

        }  if (getItemViewType(i) == 1) {

            ArrayList singleSectionItems = dataList.get(1).getAllItemsInSection();
            final String sectionName = dataList.get(1).getHeaderTitle();
            itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

            itemRowHolder.recycler_view_list.setHasFixedSize(true);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

            itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
            itemRowHolder.itemTitle.setText(sectionName);


        }if (getItemViewType(i) == 2) {

            ArrayList singleSectionItems = dataList.get(2).getAllItemsInSection();
            final String sectionName = dataList.get(2).getHeaderTitle();
            itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

            itemRowHolder.recycler_view_list.setHasFixedSize(true);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

            itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
            itemRowHolder.itemTitle.setText(sectionName);


        }
//        else {
//
//            ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
//            final String sectionName = dataList.get(i).getHeaderTitle();
//            itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);
//
//            itemRowHolder.recycler_view_list.setHasFixedSize(true);
//            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
//            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);
//
//            itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
//            itemRowHolder.itemTitle.setText(sectionName);
//            itemRowHolder.btnMore.setText( "All" );
//        }

       //  int ii= getItemViewType( i );




       // Toast.makeText(mContext, "click  more, "+dataList.get(i) , Toast.LENGTH_SHORT).show();

        Log.e( "dataList",dataList.get(i).toString()+"pos" );
       /*  itemRowHolder.recycler_view_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        //Allow ScrollView to intercept touch events once again.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle RecyclerView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/

        itemRowHolder.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(v.getContext(), ActivityCategory.class);
                v.getContext().startActivity(intentReg);

               // Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();

            }
        });







       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle,tvMore;

        protected RecyclerView recycler_view_list;

       // protected Button btnMore;



        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.tv_title);
            this.tvMore = (TextView) view.findViewById(R.id.tv_more);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            //this.btnMore= (Button) view.findViewById( R.id.btnMore);


        }

    }

}