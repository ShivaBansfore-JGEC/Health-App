package com.example.shiva.healthapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiva.healthapp.enums.URL;
import com.example.shiva.healthapp.network.HttpClient;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DietChart extends AppCompatActivity {
   EditText et_age,et_wight,et_height,et_goal,et_body,et_exercise;
   RadioGroup rg1_dc,rg2_dc;
   RadioButton rb_male,rb_female,rb_trans_gender,rb_yes,rb_no;
   RadioButton radioButton;
   RadioButton radioBtn;
   String age,weight,height,goal,body_type,sex,exercise_opt,exercise_period;
   Toolbar toolbar;
   Button submit_dc;
  UserSession userSession;
   ImageView iv_toolbar_arrow;
    int radioBtnId;
    int exc_radiobtnId;
    private ArrayList<SpinnerItem> body_list;
    private SpinnerAdapter adapter;
    private  Spinner spinner1;
    private Spinner spinner_fit_goal;
    private ArrayList<SpinnerItem> fit_goal_list;
    private SpinnerAdapter adapter_fit_goal;
    private ArrayList<SpinnerItem> list_exe_period;
    private SpinnerAdapter adapter_exe_period;
    private Spinner spinner_exe_period;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);
        initList();
        initFitGoalList();
        initExePeriodList();
        userSession=new UserSession(this);
        et_age=(EditText)findViewById(R.id.et_age_dc);
        et_wight=(EditText)findViewById(R.id.et_weight_dc);
        et_height=(EditText)findViewById(R.id.et_height_dc);
       // et_body=(EditText)findViewById(R.id.et_body_dc);
        rg1_dc=(RadioGroup)findViewById(R.id.rg_dc);
        rg2_dc=(RadioGroup)findViewById(R.id.rg2_dc);
        rb_male=(RadioButton) findViewById(R.id.rb_male_dc);
        rb_female=(RadioButton)findViewById(R.id.rb_female_dc);
        rb_trans_gender=(RadioButton)findViewById(R.id.rb_transGender_dc);
        rb_yes=(RadioButton)findViewById(R.id.rb_yes_dc);
        rb_no=(RadioButton)findViewById(R.id.rb_no_dc);
       // et_goal=(EditText)findViewById(R.id.et_goal_dc);
       // et_exercise=(EditText)findViewById(R.id.et_exercise_period);
        spinner1=(Spinner)findViewById(R.id.spinner_body_type);
        adapter=new SpinnerAdapter(this,body_list);
        spinner1.setAdapter(adapter);
        spinner_fit_goal=(Spinner)findViewById(R.id.spinner_fitness_goal);
        adapter_fit_goal=new SpinnerAdapter(this,fit_goal_list);
        spinner_fit_goal.setAdapter(adapter_fit_goal);
        spinner_exe_period=(Spinner)findViewById(R.id.spinner_exe_period);
        adapter_exe_period=new SpinnerAdapter(this,list_exe_period);
        spinner_exe_period.setAdapter(adapter_exe_period);
        iv_toolbar_arrow=(ImageView)findViewById(R.id.iv_toolbar_dc);
        submit_dc=(Button)findViewById(R.id.btn_submit_dc);
        submit_dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_age.getText().toString().equals(""))
                {
                    et_age.setError("please fill the blanks");
                }else if (Integer.parseInt(et_age.getText().toString())>120){
                    et_age.setError("Incorrect Age!");

                }else if (et_wight.getText().toString().equals(""))
                {
                    et_wight.setError("please fill the blanks!");
                }else if (et_height.getText().toString().equals(""))
                {

                }else if (Integer.parseInt(et_height.getText().toString())>12)
                {
                    et_height.setError("Incorrect Height..!");

                } else {
                    new MyTaskDiet().execute();
                }

                }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem clkItem=(SpinnerItem)adapterView.getItemAtPosition(i);
                   body_type=clkItem.getTitle();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapterView.getEmptyView();
            }
        });
        spinner_fit_goal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem SelectedItem=(SpinnerItem)adapterView.getItemAtPosition(i);
                goal=SelectedItem.getTitle();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_exe_period.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem Selected_exe_Item=(SpinnerItem)adapterView.getItemAtPosition(i);
                exercise_period=Selected_exe_Item.getTitle();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void goDashbord(View view)
    {
        startActivity(new Intent(this,DashBoard.class));
    }
    public void initList()
    {
        body_list=new ArrayList<>();
        body_list.add(new SpinnerItem("select"));
        body_list.add(new SpinnerItem("Fat"));
        body_list.add(new SpinnerItem("Medium"));
        body_list.add(new SpinnerItem("Thin"));
        body_list.add(new SpinnerItem("OverWeight"));
    }
    public void initFitGoalList()
    {
        fit_goal_list=new ArrayList<>();
        fit_goal_list.add(new SpinnerItem("Weight Loss"));
        fit_goal_list.add(new SpinnerItem("Weight Gain"));
        fit_goal_list.add(new SpinnerItem("Body Building"));
        fit_goal_list.add(new SpinnerItem("Become Fit"));
    }
    public void initExePeriodList()
    {
        list_exe_period=new ArrayList<>();
        list_exe_period.add(new SpinnerItem("Once in a week !"));
        list_exe_period.add(new SpinnerItem("Once in a month !"));
        list_exe_period.add(new SpinnerItem("Daily !"));
        list_exe_period.add(new SpinnerItem("Depends on my mood !"));
    }
    public void init1()
    {
        radioBtnId=rg1_dc.getCheckedRadioButtonId();
        radioButton=(RadioButton)findViewById(radioBtnId);
        sex=radioButton.getText().toString();
        if (sex.equals("Male"))
        {
            sex="m";
        }else if (sex.equals("Female"))
        {
            sex="f";
        }else {
            sex="t";
        }
        exc_radiobtnId=rg2_dc.getCheckedRadioButtonId();
        radioBtn=(RadioButton)findViewById(exc_radiobtnId);
        exercise_opt=radioBtn.getText().toString();
        age=et_age.getText().toString();
        weight=et_wight.getText().toString();
        height=et_height.getText().toString();
       // goal=et_goal.getText().toString();
       // body_type=et_body.getText().toString();
       // exercise_period=et_exercise.getText().toString();
    }

    public class MyTaskDiet extends AsyncTask<String,Void,Boolean>
    {
        JSONObject response;
        ProgressDialog progressDialog=new ProgressDialog(DietChart.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Data sending");
            progressDialog.isIndeterminate();
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            JSONObject jsonObject=new JSONObject();
           init1();
            try {
                jsonObject.put("height",height);
                jsonObject.put("weight",weight);
                jsonObject.put("gender",sex);
                jsonObject.put("fitness_goal",goal);
                jsonObject.put("body_type",body_type);
                jsonObject.put("age",age);
                jsonObject.put("you_excercise", exercise_opt);
                jsonObject.put("exercise_period",exercise_period);
                jsonObject.put("id",userSession.getUserId());
                Log.e("request", String.valueOf(jsonObject));
                response= HttpClient.SendHttpPost(URL.UserDetails.getURL(),jsonObject);
                Log.e("response", String.valueOf(response));
                boolean status=response!=null && response.getInt("is_error")==0;
                return status;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }


        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            progressDialog.dismiss();
            if (status)
            {
                Toast.makeText(getApplicationContext(),"successfully sent",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"sending failed",Toast.LENGTH_SHORT).show();
            }

        }
    }
    }

