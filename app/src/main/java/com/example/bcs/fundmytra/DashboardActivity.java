package com.example.bcs.fundmytra;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PageItemClickListener;
import me.crosswall.lib.coverflow.core.PagerContainer;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtn1,imgbtn2;

    private CirclePageIndicator circlePageIndicator;
    private int currentPage = 0;
    private int NUM_PAGE = 0;
    RecyclerView recyclerView;

    private Integer[] IMAGES = {R.drawable.employee1, R.drawable.employee1, R.drawable.employee1};
    private ArrayList<Integer> arrayList;
    RecyclerViewAdapter adapter;
    int i;
    int k;


    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imgbtn1=(ImageButton)findViewById(R.id.backButton);
        imgbtn2=(ImageButton)findViewById(R.id.frontButton);
        imgbtn1.setVisibility(View.INVISIBLE);

        getImages();
        arrayList=new ArrayList<>();
        arrayList=populateList();
        init();

    }
    @Override
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

                k=mImageUrls.size()-1;
                Log.e("totalPosition", String.valueOf(k));
                Log.e("firstPosition", String.valueOf(i));
                if (i==k ){
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
<<<<<<< HEAD

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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
=======
>>>>>>> 5bfa5ba9ad4c4486d0704ea18e699e6db718ffbb
}
