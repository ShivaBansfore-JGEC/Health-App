package com.example.shiva.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Shiva on 3/28/2018.
 */

public class Membership extends Fragment {
    int posit;
    TextView tv4_monthly,tv5_quarterly,tv6_halfyearly,tv7_yearlt;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.membership, container, false);
        Intent intent1=getActivity().getIntent();
        posit=intent1.getIntExtra("position",0);
        tv4_monthly=(TextView)view.findViewById(R.id.tv4_monthly);
        tv5_quarterly=(TextView)view.findViewById(R.id.tv5_mebership_quarterly);
        tv6_halfyearly=(TextView)view.findViewById(R.id.tv6_mebership_halfyearly);
        tv7_yearlt=(TextView)view.findViewById(R.id.tv8_mebership_yearly);
        tv4_monthly.setText(GymClubDetails.jArr.optJSONObject(posit).optString("monthly_membership"));
        tv5_quarterly.setText(GymClubDetails.jArr.optJSONObject(posit).optString("quaterly_membership"));
        tv6_halfyearly.setText(GymClubDetails.jArr.optJSONObject(posit).optString("halfyearly_membership"));
        tv7_yearlt.setText(GymClubDetails.jArr.optJSONObject(posit).optString("yearly_membership"));
        return view;
    }
}
