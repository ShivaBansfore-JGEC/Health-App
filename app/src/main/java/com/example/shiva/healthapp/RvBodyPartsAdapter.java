package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Shiva on 4/13/2018.
 */

public class RvBodyPartsAdapter extends RecyclerView.Adapter<RvBodyPartsAdapter.ViewHolder> {
    Context context;
    ArrayList<BodyPartsData> arrayList=new ArrayList<>();
    private onItemClickListener mlistener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener)
    {
        mlistener=listener;
    }
    public RvBodyPartsAdapter(Context ctx,ArrayList<BodyPartsData> list)
    {
        this.context=ctx;
        this.arrayList=list;
    }
    @Override
    public RvBodyPartsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_body_parts,parent,false);
        return new ViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(RvBodyPartsAdapter.ViewHolder holder, int position) {
         holder.textView.setText(arrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView imageView;
        TextView textView;
        public ViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            imageView=(CircleImageView)itemView.findViewById(R.id.iv_body_parts);
            textView=(TextView)itemView.findViewById(R.id.tv_bodyParts);
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
                           }