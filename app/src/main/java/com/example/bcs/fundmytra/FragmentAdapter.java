package com.example.bcs.fundmytra;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.my_profile);
            case 1:
                return mContext.getString(R.string.my_searches);
            case 2:
                return mContext.getString(R.string.my_applications);
            case 3:
                return mContext.getString(R.string.salary_info);
            case 4:
                return mContext.getString(R.string.documents);
            case 5:
                return mContext.getString(R.string.your_interest);
            default:
                return null;
        }
    }

    private Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm, int numOfTabs) {
        super(fm);
        mContext = context;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyProfileFragment();
            case 1:
                return new MySearchesFragment();
            case 2:
                return new MyApplicationsFragment();
            case 3:
            return new SalaryInformationFragment();
            case 4:
                return new DocumentsFragment();
            case 5:
                return new YourInterestsFragment();
            default:
                return null;
        }
    }
}
