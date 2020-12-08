package com.example.shiva.healthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

public class ExerciseDetailsPage extends AppCompatActivity {
ImageView iv_exe_detl,iv_goBack;
TextView tv_video_link,tv_desc,tv_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details_page);
        iv_exe_detl=(ImageView)findViewById(R.id.iv_exe_details);
        tv_desc=(TextView)findViewById(R.id.tv_exe_details_description);
        tv_video_link=(TextView)findViewById(R.id.tv_videoLink_exeDetails);
        iv_goBack=(ImageView)findViewById(R.id.iv_toolbar_exe_detl);
        tv_toolbar=(TextView)findViewById(R.id.tv_toolbar_exe_detl);
        try {
            tv_toolbar.setText(ExcerciseList.jsonArray.getJSONObject(0).optString("title"));
            tv_video_link.setText(ExcerciseList.jsonArray.getJSONObject(0).optString("video_link"));
            tv_desc.setText(ExcerciseList.jsonArray.getJSONObject(0).optString("description"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        iv_goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExerciseDetailsPage.this,ExcerciseList.class));
                finish();
            }
        });
    }

}
