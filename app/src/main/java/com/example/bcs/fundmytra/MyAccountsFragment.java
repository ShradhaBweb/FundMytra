package com.example.bcs.fundmytra;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class MyAccountsFragment extends Fragment  {

    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter adapter;

    public MyAccountsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view=(View) inflater.inflate(R.layout.content_myaccounts, container, false);

        TabItem  tabprofile = view.findViewById(R.id.my_profile);
        TabItem tabsearches = view.findViewById(R.id.my_searches);
        TabItem tabaplication = view.findViewById(R.id.my_application);
        TabItem tabinterest = view.findViewById(R.id.salary_info);
        TabItem tabsalaryinformation = view.findViewById(R.id.documents);
        tabLayout = (TabLayout) view.findViewById(R.id.simpleTabLayout);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager);


       init();
       viewPager.setAdapter(adapter);
       tabLayout.setupWithViewPager(viewPager);
       listeners();
       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
       return view;
   }

    private void init() {

         adapter = new FragmentAdapter(getActivity(), getChildFragmentManager(),tabLayout.getTabCount());

    }

    private void listeners() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}

