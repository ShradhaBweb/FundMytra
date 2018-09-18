package com.example.bcs.fundmytra;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MyAccountsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter adapter;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccounts);

        // Toolbar
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        toolbar1.setTitle(R.string.my_accounts);
        setSupportActionBar(toolbar1);

        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        toolbar2.setTitle("");
        setSupportActionBar(toolbar2);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.START);
            }
        });
        toggle.setHomeAsUpIndicator(R.drawable.menu3);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
      //  First Tab
//        TabLayout.Tab firstTab = tabLayout.newTab();
//        firstTab.setText(R.string.my_profile);
//        tabLayout.addTab(firstTab);
//
//        //Second Tab
//        TabLayout.Tab secondTab = tabLayout.newTab();
//        secondTab.setText(R.string.my_searches);
//        tabLayout.addTab(secondTab);
//
//       //Third Tab
//        TabLayout.Tab thirdTab = tabLayout.newTab();
//        thirdTab.setText(R.string.my_applications);
//        tabLayout.addTab(thirdTab);

      //  listeners();

        }

    private void init() {
       // simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);
         viewPager = (ViewPager) findViewById(R.id.viewpager);
         adapter = new FragmentAdapter(this, getSupportFragmentManager());

    }

    private void listeners() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment=null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new MyProfileFragment();
                        break;
                    case 1:
                        fragment = new MySearchesFragment();
                        break;
                    case 2:
                        fragment = new MyApplicationsFragment();
                        break;

                        }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
               // ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
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

