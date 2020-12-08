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
 * Created by Shiva on 4/25/2018.
 */

public class RvProffessionalAdapter extends RecyclerView.Adapter<RvProffessionalAdapter.ViewHolder> {
    Context context;
    ArrayList<ProffesionalModel> list=new ArrayList<>();
    onItemClickListener mlistener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnClickListenerListener(onItemClickListener listener)
    {
        mlistener=listener;
    }

    public RvProffessionalAdapter(Context context, ArrayList<ProffesionalModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RvProffessionalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_professionals,parent,false);
        return new ViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(RvProffessionalAdapter.ViewHolder holder, int position) {
          holder.imageView.setImageResource(list.get(position).getProfile_img());
          holder.name.setText(list.get(position).getName());
          holder.field.setText(list.get(position).getField());
          holder.city.setText(list.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
         ImageView imageView;
         TextView name,field,city;
        public ViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_proff);
            name=(TextView)itemView.findViewById(R.id.tv_proff_name);
            field=(TextView)itemView.findViewById(R.id.tv_proff_field);
            city=(TextView)itemView.findViewById(R.id.tv_proff_city);
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
