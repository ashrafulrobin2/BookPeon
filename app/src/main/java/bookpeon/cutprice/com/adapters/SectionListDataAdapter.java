package bookpeon.cutprice.com.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import bookpeon.cutprice.com.R;
import bookpeon.cutprice.com.activity.ActivityDetails;
import bookpeon.cutprice.com.activity.ActivityDetails2;
import bookpeon.cutprice.com.model.SingleItemModel;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {

        int ii= getItemViewType( i );
        final int index = holder.getAdapterPosition();
        final SingleItemModel singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.getName());

        Log.e( "<<pos",ii+"<<pos" );
        Log.e( "<<index",index+"<<index" );
        Log.e( "<<singleItem",singleItem.toString()+"<<index" );
        holder.tvTitle.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "click , "+itemsList.get(i).getName() , Toast.LENGTH_SHORT).show();
            }
        } );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDeatils = new Intent( v.getContext(), ActivityDetails2.class);
                v.getContext().startActivity(intentDeatils);
                Toast.makeText(v.getContext(), singleItem.getName(), Toast.LENGTH_SHORT).show();

            }
        } );

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        private ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tv_festival_name);
            this.itemImage = (ImageView) view.findViewById(R.id.iv_product);




        }

    }

}