package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shiva on 4/17/2018.
 */

public class RvCartListAdapter extends RecyclerView.Adapter<RvCartListAdapter.ViewHolder> {
    Context context;
    ArrayList<Integer> list1=new ArrayList<>();

    public RvCartListAdapter(Context context,ArrayList<Integer> list)
    {
        this.context=context;
        this.list1=list;

    }
    @Override
    public RvCartListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_cart,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RvCartListAdapter.ViewHolder holder, int position) {
        holder.title.setText(Shop.arrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            iv=(ImageView)itemView.findViewById(R.id.iv_cartList);
            title=(TextView)itemView.findViewById(R.id.tv_title_cartList);
        }
    }
}
