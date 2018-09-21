package com.example.bcs.fundmytra;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class AllProductFragmentActivity extends Fragment {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    RecyclerView recyclerView;
    GridView gridView;
    AllProductGridAdapter adapter;
    CirclePageIndicator circlePageIndicator;
    private int currentPage = 0;
    private int NUM_PAGE = 0;
    ViewPager viewPager;

    private Integer[] IMAGES = {R.drawable.prequalityone, R.drawable.prequalityone, R.drawable.prequalityone};
    private ArrayList<Integer> arrayList;


    public AllProductFragmentActivity() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container!=null){
            container.removeAllViews();
        }
        View view= inflater.inflate(R.layout.fragment_all_product, container, false);
        gridView=(GridView)view.findViewById(R.id.gridView);
        viewPager=(ViewPager)view.findViewById(R.id.viewPage);
        circlePageIndicator = (CirclePageIndicator)view. findViewById(R.id.circlePagerIndicator);
        arrayList=new ArrayList<>();
        arrayList=populateList();
        init();
        getImages();

        return view;
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
        initGridView();
    }
    private void initGridView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        adapter=new AllProductGridAdapter(getActivity(),mNames,mImageUrls);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Toast.makeText(getContext(),"position zero",Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(),"position one",Toast.LENGTH_LONG).show();
                        break;
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




        AllProductPageAdapter adapter = new AllProductPageAdapter(getContext(), arrayList);
        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(adapter.getCount());

        viewPager.setClipChildren(false);


        circlePageIndicator.setViewPager(viewPager);
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
                viewPager.setCurrentItem(currentPage++, true);
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

}
