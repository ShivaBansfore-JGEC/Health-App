package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shiva on 4/17/2018.
 */

public class RvCommentProdDetail extends RecyclerView.Adapter<RvCommentProdDetail.ViewHolder> {
    Context context;
    ArrayList<String> list2=new ArrayList<>();
    public RvCommentProdDetail(Context ctx,ArrayList<String> list)
    {
     this.context=ctx;
     this.list2=list;
    }

    @Override
    public RvCommentProdDetail.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.review_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RvCommentProdDetail.ViewHolder holder, int position) {
            holder.tv.setText(list2.get(position));
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.tv_reviews);
        }
    }
}
