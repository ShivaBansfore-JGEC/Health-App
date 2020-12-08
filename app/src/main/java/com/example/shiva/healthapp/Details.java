package com.example.shiva.healthapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

/**
 * Created by Shiva on 3/28/2018.
 */

public class Details extends Fragment implements OnMapReadyCallback {
    SupportMapFragment supportMapFragment;
    GoogleMap mMap;
    private int position;
    ImageView iv_call;
    TextView tv_locate,tv_speciality,tv_contact,tv_email,gym_name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.details,container,false);
        Intent intent=getActivity().getIntent();
        position=intent.getIntExtra("position",0);
        tv_locate=(TextView)view.findViewById(R.id.tv_locate_details);
        tv_speciality=(TextView)view.findViewById(R.id.tv_speciality_details);
        tv_contact=(TextView)view.findViewById(R.id.tv_contact_details);
        tv_email=(TextView)view.findViewById(R.id.tv_email_details);
        gym_name=(TextView)view.findViewById(R.id.tv_gym_details);
        InitializeData();
        iv_call=(ImageView)view.findViewById(R.id.iv_make_call);
        iv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i=new Intent(Intent.ACTION_DIAL);
              String ph=tv_contact.getText().toString();
              if (ph.trim().isEmpty())
              {
                  i.setData(Uri.parse("tel:7758650070"));
              }else {
                  i.setData(Uri.parse("tel:"+ph));
              }
              startActivity(i);
            }
        });
        supportMapFragment=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment==null)
        {
            FragmentManager fm=getFragmentManager();
            FragmentTransaction fragmentTransaction=fm.beginTransaction();
            supportMapFragment=SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map,supportMapFragment).commit();
        }
        supportMapFragment.getMapAsync(this);
        return view;
    }
    private void InitializeData()
    {
        gym_name.setText(GymClubDetails.jArr.optJSONObject(position).optString("name"));
        tv_locate.setText(GymClubDetails.jArr.optJSONObject(position).optString("address"));
        tv_speciality.setText(GymClubDetails.jArr.optJSONObject(position).optString("detail"));
        tv_contact.setText(GymClubDetails.jArr.optJSONObject(position).optString("phone"));
        tv_email.setText(GymClubDetails.jArr.optJSONObject(position).optString("email"));
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent intent=getActivity().getIntent();
        int position=intent.getIntExtra("position",0);
          mMap=googleMap;
        LatLng byPass= null;
        try {
            byPass = new LatLng(GymClubDetails.jArr.getJSONObject(position).getDouble("lat"),GymClubDetails.jArr.getJSONObject(position).getDouble("lng"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(byPass);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        markerOptions.title("Current Location");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(byPass));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(byPass));
        mMap.setMinZoomPreference(10.0f);
        mMap.setMaxZoomPreference(14.0f);
        mMap.addMarker(markerOptions);

    }
}
