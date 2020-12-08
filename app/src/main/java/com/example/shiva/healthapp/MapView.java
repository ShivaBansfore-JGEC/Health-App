package com.example.shiva.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;

/**
 * Created by Shiva on 3/28/2018.
 */

public class MapView extends Fragment {
    TextView tv_mon,tv_tue,tv_wed,tv_thur,tv_fri,tv_sat,tv_sun;
    TextView tv1_from,tv2_from,tv3_from,tv4_from,tv5_from,tv6_from,tv7_from;
    TextView tv1_to,tv2_to,tv3_to,tv4_to,tv5_to,tv6_to,tv7_to;
    String time[]={};
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapview, container, false);
        Intent intent=getActivity().getIntent();
        int position=intent.getIntExtra("position",0);
        tv_mon=(TextView)view.findViewById(R.id.tv_day);
        tv1_from=(TextView)view.findViewById(R.id.tv1_timing);
        tv1_to=(TextView)view.findViewById(R.id.tv_timing_to);
        tv_tue=(TextView)view.findViewById(R.id.tv_day1);
        tv2_from=(TextView)view.findViewById(R.id.tv1_timing1);
        tv2_to=(TextView)view.findViewById(R.id.tv1_timing_to1);
        tv_wed=(TextView)view.findViewById(R.id.tv_day2);
        tv3_from=(TextView)view.findViewById(R.id.tv1_timing2);
        tv3_to=(TextView)view.findViewById(R.id.tv1_timing_to2);
        tv_thur=(TextView)view.findViewById(R.id.tv_day4);
        tv4_from=(TextView)view.findViewById(R.id.tv1_timing4);
        tv4_to=(TextView)view.findViewById(R.id.tv1_timing_to4);
        tv_fri=(TextView)view.findViewById(R.id.tv_day5);
        tv5_from=(TextView)view.findViewById(R.id.tv1_timing5);
        tv5_to=(TextView)view.findViewById(R.id.tv1_timing_to5);
        tv_sat=(TextView)view.findViewById(R.id.tv_day6);
        tv6_from=(TextView)view.findViewById(R.id.tv1_timing6);
        tv6_to=(TextView)view.findViewById(R.id.tv1_timing_to6);
        tv_sun=(TextView)view.findViewById(R.id.tv_day3);
        tv7_from=(TextView)view.findViewById(R.id.tv1_timing3);
        tv7_to=(TextView)view.findViewById(R.id.tv1_timing_to3);

        for (int i=0;i<GymClubDetails.jArr.length();i++)
        {
            try {
                tv_mon.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(0).optString("day"));
                tv_tue.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(1).optString("day"));
                tv1_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(0).optString("time_from"));
                tv2_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(1).optString("time_from"));
                tv1_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(0).optString("time_to"));
                tv2_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(1).optString("time_to"));
                tv_wed.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(2).optString("day"));
                tv3_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(2).optString("time_from"));
                tv3_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(2).optString("time_to"));
                tv_sun.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(3).optString("day"));
                tv7_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(3).optString("time_from"));
                tv7_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(3).optString("time_to"));
                tv_thur.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(4).optString("day"));
                tv4_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(4).optString("time_from"));
                tv4_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(4).optString("time_to"));
                tv_fri.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(5).optString("day"));
                tv5_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(5).optString("time_from"));
                tv5_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(5).optString("time_to"));
                tv_sat.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(6).optString("day"));
                tv6_from.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(6).optString("time_from"));
                tv6_to.setText(GymClubDetails.jArr.getJSONObject(position).getJSONArray("gym_timing").getJSONObject(6).optString("time_to"));


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
       /* try {


        }
        catch (JSONException e) {
            e.printStackTrace();
        }*/
        return view;
    }
}
