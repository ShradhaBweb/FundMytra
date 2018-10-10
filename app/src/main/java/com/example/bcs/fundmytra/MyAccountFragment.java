package com.example.bcs.fundmytra;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccountFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter adapter;

    public MyAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=(View) inflater.inflate(R.layout.fragment_my_account, container, false);
        SharedPreferences preferences= getContext().getApplicationContext().getSharedPreferences("MyPref",0);
        String s=preferences.getString("auth_id","sssss");
        Log.e("auth_id in Fragment",s);
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