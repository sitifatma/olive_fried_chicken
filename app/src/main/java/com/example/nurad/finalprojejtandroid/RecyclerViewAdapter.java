package com.example.nurad.finalprojejtandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Produk> mData ;


    public RecyclerViewAdapter(Context mContext, List<Produk> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_produk,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_phone_title.setText(mData.get(position).getTitle());
        holder.tv_phone_harga.setText(String.valueOf(mData.get(position).getHarga()));
        holder.img_phone_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,Produk_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Category",mData.get(position).getCategory());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Harga",mData.get(position).getHarga());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_phone_title;
        TextView tv_phone_harga;
        ImageView img_phone_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_phone_title = (TextView) itemView.findViewById(R.id.phone_title_id);
            tv_phone_harga = (TextView) itemView.findViewById(R.id.phone_harga_id);
            img_phone_thumbnail = (ImageView) itemView.findViewById(R.id.phone_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}