
package com.example.bcs.fundmytra.Fragment;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.bcs.fundmytra.Adapter.AllProductGridAdapter;
import com.example.bcs.fundmytra.Adapter.AllProductPageAdapter;
import com.example.bcs.fundmytra.R;
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


        getImages();
        arrayList=new ArrayList<>();
        arrayList=populateList();
        init();



        return view;
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.card_loanicon);
        mNames.add("Credit Card");

        mImageUrls.add(R.drawable.two_wheeler);
        mNames.add("Two Wheeler Loan");

        mImageUrls.add(R.drawable.personal_loanicon);
        mNames.add("Personal Loan");

        mImageUrls.add(R.drawable.home_loanicon);
        mNames.add("Home Loan");


        mImageUrls.add(R.drawable.against_property_loanicon);
        mNames.add("Loan Against Property");

        mImageUrls.add(R.drawable.balance_laonicon);
        mNames.add("Home Loan Balance Transfer");


        mImageUrls.add(R.drawable.contraction_loan);
        mNames.add("Site & Contruction Loan");

        mImageUrls.add(R.drawable.car_loanicon);
        mNames.add("Car Loan");

        mImageUrls.add(R.drawable.user_car_loanicon);
        mNames.add("Used Car Loan");

        mImageUrls.add(R.drawable.topcar_loanicon);
        mNames.add("Top up Car Loan");

        mImageUrls.add(R.drawable.commercial_loanicon);
        mNames.add("Commercial Vehicle Loan");

        mImageUrls.add(R.drawable.best_offereicon);
        mNames.add("For Best Offeres");

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
                        Toast.makeText(getActivity(),"position zero",Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(),"position one",Toast.LENGTH_LONG).show();
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




        AllProductPageAdapter adapter = new AllProductPageAdapter(getActivity(), arrayList);
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









//    @Override
//    public boolean onBackPressed() {
//
//        assert getFragmentManager() != null;
//        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        return true;
//    }
//
//    @Override
//    public int getBackPriority() {
//        return LOW_BACK_PRIORITY + 1;
//    }
}