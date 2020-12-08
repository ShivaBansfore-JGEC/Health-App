package com.example.shiva.healthapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiva.healthapp.enums.URL;
import com.example.shiva.healthapp.network.HttpClient;
import com.example.shiva.healthapp.network.NetworkConnection;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class GymClubDetails extends AppCompatActivity {
   String phone[]={"+91-033564780","+91-033567999","+91-0335545567"};
    String email[]={"pankaj123@gmail.com","prateek124@gmail.com","milan@456@gmail.com"};
    String contacts[]={"Nirjhar Apartment,31/6,Mahendra Roy Rd,Seal Lane,Gobra Kolkata","Nirjhar Apartment,31/6,Mahendra Roy Rd,Seal Lane,Gobra Kolkata","Nirjhar Apartment,31/6,Mahendra Roy Rd,Seal Lane,Gobra Kolkata"};
   int imgId[]={R.drawable.club_logo,R.drawable.club_logo,R.drawable.club_logo};
    String phone2[]={"+91-033564780","+91-033567999","+91-0335545567"};
    String email2[]={"pankaj123@gmail.com","prateek124@gmail.com","milan@456@gmail.com"};
    String contacts2[]={"Nirjhar Apartment,31/6,Mahendra Roy Rd,Seal Lane,Gobra Kolkata","Nirjhar Apartment,31/6,Mahendra Roy Rd,Seal Lane,Gobra Kolkata","Nirjhar Apartment,31/6,Mahendra Roy Rd,Seal Lane,Gobra Kolkata"};
    int imgId2[]={R.drawable.club_logo,R.drawable.club_logo,R.drawable.club_logo};
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Toolbar toolbar_club_list;
    private ImageView cvToDashboard;
    public static JSONArray jArr=new JSONArray();
    ArrayList<ClubDetailsData> arrayList=new ArrayList<>();
    RecyclerView recyclerView;
    RvClubDetailsAdapter adapter;
    public static JSONArray array=new JSONArray();
    private NetworkConnection networkConnection;
    CoordinatorLayout coordinatorLayout;
    private ShimmerFrameLayout shimmerFrameLayout;
    TextView tv_title;
    CircleImageView profile;
    UserSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT>=19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }*/
        setContentView(R.layout.activity_gym_club_details);
        session=new UserSession(this);
        shimmerFrameLayout=(ShimmerFrameLayout)findViewById(R.id.facebook_siemmer);
        DisplayImageOptions imageOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(imageOptions).build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
        toolbar_club_list=(Toolbar)findViewById(R.id.toolbar_club_list);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_club_list);
        navigationView=(NavigationView)findViewById(R.id.nav_club_list);
        View headeView=navigationView.getHeaderView(0);
        tv_title=(TextView)headeView.findViewById(R.id.tv_header);
        tv_title.setText(session.getEmail());
        recyclerView=(RecyclerView)findViewById(R.id.rv_club_details);
        adapter=new RvClubDetailsAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        networkConnection=new NetworkConnection(this);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.cordinator_layout);
       // initialiseData();
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar_club_list,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        cvToDashboard=(ImageView)findViewById(R.id.iv_cv_toolbar);
        toolbar_club_list.inflateMenu(R.menu.toolbar_menu);
        prepareExecuteAsync();

        adapter.setOnItemClickListener(new RvClubDetailsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                    Intent intent = new Intent(GymClubDetails.this, ClubDetailsView.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                    finish();
                    break;
                    case 1:
                        Intent intent1 = new Intent(GymClubDetails.this, ClubDetailsView.class);
                        intent1.putExtra("position", position);
                        startActivity(intent1);
                        finish();
                        break;
                    case 2:
                        Intent intent2 = new Intent(GymClubDetails.this, ClubDetailsView.class);
                        intent2.putExtra("position", position);
                        startActivity(intent2);
                        finish();
                        break;
                    case 3:
                        Intent intent3 = new Intent(GymClubDetails.this, ClubDetailsView.class);
                        intent3.putExtra("position", position);
                        startActivity(intent3);
                        finish();
                        break;
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item1:
                        startActivity(new Intent(GymClubDetails.this,DietChart.class));
                        break;
                    case R.id.item2:
                        startActivity(new Intent(GymClubDetails.this,AskExpert.class));
                        break;
                    case R.id.item3:
                        startActivity(new Intent(GymClubDetails.this,CalorieTracker.class));
                        break;
                    case R.id.item4:
                        startActivity(new Intent(GymClubDetails.this,ExcerciseType.class));
                        break;
                    case R.id.item5:
                        startActivity(new Intent(GymClubDetails.this,GymClubDetails.class));
                        break;
                    case R.id.item6:
                        startActivity(new Intent(GymClubDetails.this,Shop.class));
                        break;
                    case R.id.item7:
                        startActivity(new Intent(GymClubDetails.this,Professionals.class));
                        break;
                    case R.id.item8:
                        startActivity(new Intent(GymClubDetails.this,TrainerSignUp.class));
                        break;
                    case R.id.item9:
                        session.removeUser();
                        startActivity(new Intent(GymClubDetails.this,LoginPage.class));
                        break;
                }
                return false;
            }
        });
    }
    private boolean prepareExecuteAsync() {
        if (networkConnection.isNetworkConnected()) {
            new MyClublist().execute();
            return true;
        } else if (networkConnection.isNetworkConnectingOrConnected()) {
            Snackbar.make(coordinatorLayout, "network is temporarily unavailable", Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar snackbar=Snackbar.make(coordinatorLayout,"you'are offline",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        return false;
    }

    /* private void initialiseData()
    {
        for (int i=0;i<phone.length;i++)
        {
           ClubDetailsData detailsData=new ClubDetailsData(phone[i],email[i],contacts[i],imgId[i],phone2[i],email2[2],contacts2[i],imgId2[i]);
           arrayList.add(detailsData);
        }
    }*/
    public void cvToDashboard(View view)
    {
        startActivity(new Intent(this,DashBoard.class));
    }
    public class MyClublist extends AsyncTask<String,Void,Boolean>
    {
        private ProgressDialog progressDialog = new ProgressDialog(GymClubDetails.this);
        private String error_msg = "server error";
        private JSONObject response;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            shimmerFrameLayout.startShimmerAnimation();
//            progressDialog.setMessage("please wait...");
//           progressDialog.isIndeterminate();
//            progressDialog.show();
        }
        @Override
        protected Boolean doInBackground(String... strings) {
            JSONObject object=new JSONObject();
            response= HttpClient.SendHttpPost(URL.gymDetails.getURL(),object);
            try {
                boolean status = response != null && response.getInt("is_error") == 0;
                if (status) {
                    jArr = response.getJSONArray("gym");
                }
                return status;
            } catch (JSONException e) {
                e.printStackTrace();
               shimmerFrameLayout.stopShimmerAnimation();
               // progressDialog.dismiss();
                //      spinner.setVisibility(View.GONE);
                return false;
            }
        }
        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
          //  progressDialog.dismiss();
            shimmerFrameLayout.stopShimmerAnimation();
            shimmerFrameLayout.setVisibility(View.GONE);

          //  shimmerFrameLayout.destroyDrawingCache();
            if (status) {
                adapter.notifyDataSetChanged();
               //
            } else {

            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
      //  shimmerFrameLayout.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  shimmerFrameLayout.stopShimmerAnimation();
    }
}
