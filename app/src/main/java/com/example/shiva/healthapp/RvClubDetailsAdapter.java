package com.example.shiva.healthapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Shiva on 3/27/2018.
 */

public class RvClubDetailsAdapter extends RecyclerView.Adapter<RvClubDetailsAdapter.Viewholder> implements View.OnClickListener {
Context context;
ArrayList<ClubDetailsData> list=new ArrayList<>();
ImageLoader imageLoader;
private onItemClickListener mlistener;
public interface onItemClickListener
{
    void onItemClick(int position);
}
public void setOnItemClickListener(onItemClickListener listener)
{
    mlistener=listener;
}

    public RvClubDetailsAdapter(Context context,ArrayList<ClubDetailsData> list)
    {
        this.context=context;
        this.list=list;
        imageLoader=ImageLoader.getInstance();
    }

    @Override
    public RvClubDetailsAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_club_details,parent,false);
        return new Viewholder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(RvClubDetailsAdapter.Viewholder holder, final int position) {




          String  url =GymClubDetails.jArr.optJSONObject(position).optString("logo");
            imageLoader.displayImage(url,holder.img_logo);
            holder.tv1.setText(GymClubDetails.jArr.optJSONObject(position).optString("phone"));
            holder.tv2.setText(GymClubDetails.jArr.optJSONObject(position).optString("email"));
            holder.tv3.setText(GymClubDetails.jArr.optJSONObject(position).optString("address"));
          //  holder.tv2_cd_phn.setText(GymClubDetails.jArr.optJSONObject(position).optString("phone"));
           // holder.tv2_cd_email.setText(GymClubDetails.jArr.optJSONObject(position).optString("email"));
          //  holder.tv2_cd_contacts.setText(GymClubDetails.jArr.optJSONObject(position).optString("address"));
            holder.gym_name.setText(GymClubDetails.jArr.optJSONObject(position).optString("name"));


    }

    @Override
    public int getItemCount() {
        return GymClubDetails.jArr.length();
    }


    public class Viewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img_logo,img_logo2;
        TextView tv1,tv2,tv3,gym_name;
        TextView tv2_cd_phn,tv2_cd_email,tv2_cd_contacts;
        public Viewholder(View itemView, final onItemClickListener listener) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.tv_cd_phone);
            tv2=(TextView)itemView.findViewById(R.id.tv_cd_email);
            tv3=(TextView)itemView.findViewById(R.id.tv_cd_contacts);
            img_logo=(CircleImageView)itemView.findViewById(R.id.iv_club_details);
            //tv2_cd_phn=(TextView)itemView.findViewById(R.id.tv_cd_phone2);
           // tv2_cd_email=(TextView)itemView.findViewById(R.id.tv_cd_email2);
           // tv2_cd_contacts=(TextView)itemView.findViewById(R.id.tv_cd_contacts2);
           // img_logo2=(CircleImageView)itemView.findViewById(R.id.iv_club_details2);
            gym_name=(TextView)itemView.findViewById(R.id.tv_gym_name);
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
    @Override
    public void onClick(View view) {

    }
}