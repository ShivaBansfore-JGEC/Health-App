package com.example.shiva.healthapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Shiva on 3/27/2018.
 */

public class DashbordRvAdapter extends RecyclerView.Adapter<DashbordRvAdapter.ViewHolder> {
    Context context;
    ArrayList<DashboardData> list2=new ArrayList<>();
    public DashbordRvAdapter(Context context,ArrayList<DashboardData> list)
    {
     this.context=context;
     this.list2=list;
    }


    @Override
    public DashbordRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_dashboard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DashbordRvAdapter.ViewHolder holder, final int position) {
        holder.image.setImageResource(list2.get(position).getImageId());
        holder.tv.setText(list2.get(position).getTitle());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position)
                {
                    case 0:
                        context.startActivity(new Intent(context,DietChart.class));

                        break;
                    case 1:
                        context.startActivity(new Intent(context,AskExpert.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context,CalorieTracker.class));
                        break;
                    case 3:
                        context.startActivity(new Intent(context,ExcerciseType.class));

                        break;
                    case 4:
                        context.startActivity(new Intent(context,GymClubDetails.class));
                        break;
                    case 5:
                        context.startActivity(new Intent(context,Shop.class));
                        break;
                    case 6:
                        context.startActivity(new Intent(context,Professionals.class));
                        break;
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return list2.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
       CircleImageView image;
       TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            image=(CircleImageView) itemView.findViewById(R.id.iv_dashbord);
            tv=(TextView)itemView.findViewById(R.id.tv_dashbord);
        }
    }
}
