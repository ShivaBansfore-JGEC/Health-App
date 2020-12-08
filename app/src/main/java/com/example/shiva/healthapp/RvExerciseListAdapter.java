package com.example.shiva.healthapp;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Shiva on 4/13/2018.
 */

public class RvExerciseListAdapter extends RecyclerView.Adapter<RvExerciseListAdapter.ViewHolder> {
 Context context;
 private onItemClickListener mlistener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener)
    {
        mlistener=listener;
    }
 public RvExerciseListAdapter(Context context)
 {
     this.context=context;
 }
    @Override
    public RvExerciseListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_exercise_list,parent,false);
        return new ViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(RvExerciseListAdapter.ViewHolder holder, int position) {
        try {
            holder.textView.setText(ExcerciseList.jsonArray.getJSONObject(position).optString("title"));
            Log.e("textview", String.valueOf(holder.textView));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return ExcerciseList.jsonArray.length();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
          CircleImageView imageView;
          TextView textView;
        public ViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            imageView=(CircleImageView)itemView.findViewById(R.id.iv_exercise_list);
            textView=(TextView)itemView.findViewById(R.id.tv_exercise_list);
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
