package com.example.bcs.fundmytra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PageItemClickListener;
import me.crosswall.lib.coverflow.core.PagerContainer;


public class DashboardActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private ImageButton imgbtn1,imgbtn2;
    private TextView txt1,txt2;

    private CirclePageIndicator circlePageIndicator;
    private int currentPage = 0;
    private int NUM_PAGE = 0;
    RecyclerView recyclerView;

    private Integer[] IMAGES = {R.drawable.employee1, R.drawable.employee1, R.drawable.employee1};
    private ArrayList<Integer> arrayList;
    RecyclerViewAdapter adapter;
    int i;
    int k;
    int l;


    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=new Intent(this,AllProductsActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_dashboard2);


        imgbtn1=(ImageButton)findViewById(R.id.backButton);
        imgbtn2=(ImageButton)findViewById(R.id.frontButton);
        txt1=(TextView)findViewById(R.id.referText);
        txt2=(TextView)findViewById(R.id.referText3);
        imgbtn1.setVisibility(View.INVISIBLE);
        txt1.setText("Refer");
        txt1.append(" & Earn");
        txt2.setText("Personal Loan");
        txt2.append(" | 559506");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.fred));
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        getImages();
        arrayList=new ArrayList<>();
        arrayList=populateList();
        init();


    }



    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backButton:
                LinearLayoutManager llb = (LinearLayoutManager) recyclerView.getLayoutManager();
                llb.scrollToPosition(llb.findFirstVisibleItemPosition() -1);

                int k=mImageUrls.size()-1;
                int l=llb.findLastVisibleItemPosition()-1;
                Log.e("backPosition", String.valueOf(l));
                if (i==0){
                    imgbtn1.setVisibility(View.INVISIBLE);
                    imgbtn2.setVisibility(View.VISIBLE);

                }else if (i>=0){
                    imgbtn1.setVisibility(View.VISIBLE);
                    imgbtn2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.frontButton:
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                llm.scrollToPosition(llm.findLastVisibleItemPosition() +1);

                k=mImageUrls.size()-1;
                Log.e("position", String.valueOf(i));
                if (i==k){
                    imgbtn2.setVisibility(View.INVISIBLE);
                    imgbtn1.setVisibility(View.VISIBLE);
                } else if (i>0){
                    imgbtn1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.home:
                finish();
                break;

            default:
//                showUnsupportedSnackBar();
                break;
        }
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.car_loan);
        mNames.add("Car Loan");

        mImageUrls.add(R.drawable.credit_card);
        mNames.add("Credit Card");

        mImageUrls.add(R.drawable.personal_loan);
        mNames.add("Personal Loan");

        mImageUrls.add(R.drawable.car_loan);
        mNames.add("Car Loan");


        mImageUrls.add(R.drawable.credit_card);
        mNames.add("Credit Card");

        mImageUrls.add(R.drawable.car_loan);
        mNames.add("Personal Loan");


        mImageUrls.add(R.drawable.car_loan);
        mNames.add("Car Loan");

        mImageUrls.add(R.drawable.credit_card);
        mNames.add("Credit Card");

        mImageUrls.add(R.drawable.car_loan);
        mNames.add("Personal Loan");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }

            @Override
            public void onScrolled(RecyclerView recyclerView1, int dx, int dy) {
                super.onScrolled(recyclerView1, dx, dy);
                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                i =llm.findFirstCompletelyVisibleItemPosition();
                l=llm.findLastCompletelyVisibleItemPosition();

                k=mImageUrls.size()-1;
                Log.e("totalPosition", String.valueOf(k));
                Log.e("firstPosition", String.valueOf(i));
                Log.e("lastPosition", String.valueOf(l));
                if (l==k ){
                    imgbtn2.setVisibility(View.INVISIBLE);
                    imgbtn1.setVisibility(View.VISIBLE);
                } else if (i>0 && i<k){
                    imgbtn1.setVisibility(View.VISIBLE);
                    imgbtn2.setVisibility(View.VISIBLE);
                }else if (i==0){
                    imgbtn1.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    private ArrayList<Integer> populateList(){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < IMAGES.length; i++){


            list.add(IMAGES[i]);
        }

        return list;
    }

    public void init() {

        PagerContainer mContainer = (PagerContainer) findViewById(R.id.pager_container);

        final ViewPager pager = mContainer.getViewPager();

        PageAdapter adapter = new PageAdapter(this, arrayList);
        pager.setAdapter(adapter);

        pager.setOffscreenPageLimit(adapter.getCount());

        pager.setClipChildren(false);

        mContainer.setPageItemClickListener(new PageItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(DashboardActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });


        boolean showRotate = getIntent().getBooleanExtra("showRotate", true);

        if (showRotate) {
            new CoverFlow.Builder()
                    .with(pager)
                    .scale(0.3f)
                    .pagerMargin(0f)
                    .spaceSize(0f)
                    .rotationY(0f)
                    .build();
        }
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.circlePagerIndicator);
        circlePageIndicator.setViewPager(pager);
        final float density = getResources().getDisplayMetrics().density;
        circlePageIndicator.setRadius(5 * density);
        NUM_PAGE =arrayList.size();

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == NUM_PAGE) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTime = new Timer();
        swipeTime.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);


        circlePageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentPage = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.dashboard, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
