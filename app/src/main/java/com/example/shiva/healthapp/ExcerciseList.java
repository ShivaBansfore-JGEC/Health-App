package com.example.shiva.healthapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shiva.healthapp.enums.URL;
import com.example.shiva.healthapp.network.HttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExcerciseList extends AppCompatActivity {
  RecyclerView recyclerView;
  int position;
  String development_area;
  RvExerciseListAdapter adapter;
  ImageView iv_back;
  public static JSONArray jsonArray=new JSONArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_list);
        iv_back=(ImageView)findViewById(R.id.iv_toolbar_exeList);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExcerciseList.this,BodyParts.class));
                finish();
            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.rv_exerciseList);
        adapter=new RvExerciseListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        position=intent.getIntExtra("position",0);
        development_area=intent.getStringExtra("development_area");
        new ExersiseTask().execute();
        adapter.setOnItemClickListener(new RvExerciseListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch(position)
                {
                    case 0:
                         startActivity(new Intent(ExcerciseList.this,ExerciseDetailsPage.class));
                        break;
                }
            }
        });
    }
    public class ExersiseTask extends AsyncTask<String,Void,Boolean>
    {
        JSONObject response;
        ProgressDialog progressDialog=new ProgressDialog(ExcerciseList.this);
        JSONObject jsonObject=new JSONObject();
        private String error_msg = "server error";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("please wait..");
            progressDialog.isIndeterminate();
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                jsonObject.put("type",position);
                jsonObject.put("development_area",development_area);
                Log.e("request", String.valueOf(jsonObject));
                response= HttpClient.SendHttpPost(URL.Excercise.getURL(),jsonObject);
                Log.e("response", String.valueOf(response));
                boolean status = response != null && response.getInt("is_error") == 0;
                if (status)
                {
                    jsonArray=response.getJSONArray("body_part");
                }
                Log.e("jsonarray", String.valueOf(jsonArray));
                return status;
            } catch (JSONException e) {
                e.printStackTrace();
                progressDialog.dismiss();
                //       spinner.setVisibility(View.GONE);
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            progressDialog.dismiss();
            if (status) {
                adapter.notifyDataSetChanged();
            } else {

            }
        }
    }
}
