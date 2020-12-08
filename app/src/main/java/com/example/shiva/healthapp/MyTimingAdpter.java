package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;

/**
 * Created by Shiva on 4/4/2018.
 */

public class MyTimingAdpter extends RecyclerView.Adapter<MyTimingAdpter.viewHolder> {
    Context context;
    public MyTimingAdpter(Context context)
    {
        this.context=context;
    }

    @Override
    public MyTimingAdpter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_timing,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyTimingAdpter.viewHolder holder, int position) {
      /*  try {
          //  holder.tv1_timing.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(position).optString("time_from"));
           // holder.tv2_timing.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(position).optString("time_to"));
           // holder.day.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(position).optString("day"));
            holder.day2.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(position).optString("day"));
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public int getItemCount() {
        return GymClubDetails.jArr.length();
    }
    public class viewHolder extends RecyclerView.ViewHolder
    {
       TextView tv1_timing,tv2_timing,day,tv1_timing1,day1,tv_timing2,day2,tv_timing3,day3;
        public viewHolder(View itemView) {
            super(itemView);
            tv1_timing=(TextView)itemView.findViewById(R.id.tv1_timing);
            tv2_timing=(TextView)itemView.findViewById(R.id.tv_timing_to);
            day=(TextView)itemView.findViewById(R.id.tv_day);
            tv1_timing=(TextView)itemView.findViewById(R.id.tv1_timing1);
            day2=(TextView)itemView.findViewById(R.id.tv_day1);

        }
    }
}
