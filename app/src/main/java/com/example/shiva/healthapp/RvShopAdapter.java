package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shiva on 4/16/2018.
 */

public class RvShopAdapter extends RecyclerView.Adapter<RvShopAdapter.ViewHolder> {
Context context;
    int previous=0;
ArrayList<ShopModelClass> list=new ArrayList<>();
private onItemClickListener mlistener;
public interface onItemClickListener{
    void onItemClick(int position);
}
public void setOnItemClickListener(onItemClickListener listener)
{
    mlistener=listener;
}
public RvShopAdapter(Context context,ArrayList<ShopModelClass> list) {
this.context=context;
this.list=list;
}

    @Override
    public RvShopAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_shop_rv,parent,false);
        return new ViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(RvShopAdapter.ViewHolder holder, int position) {
              holder.productTitle.setText(list.get(position).getTitle());
              holder.Amount.setText(list.get(position).getAmount());
              holder.productDesc.setText(list.get(position).getDesc());
              holder.product_image.setImageResource(list.get(position).getImage());
        if (position > previous)
        {
           AnimationUtil.animate(holder,true);
            //Shop.relativeLayout.setVisibility(View.GONE);
        }else {
           AnimationUtil.animate(holder,false);
           // Shop.relativeLayout.setVisibility(View.VISIBLE);

        }
       previous=position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView product_image;
        TextView productTitle,Amount,productDesc;

        public ViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            product_image=(ImageView)itemView.findViewById(R.id.iv_productImage);
            productTitle=(TextView)itemView.findViewById(R.id.tv_productTitle);
            Amount=(TextView)itemView.findViewById(R.id.tv_product_amount);
            productDesc=(TextView)itemView.findViewById(R.id.tv_product_desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

    }
    public void setFilter(ArrayList<ShopModelClass> newList)
    {
        list=new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}
