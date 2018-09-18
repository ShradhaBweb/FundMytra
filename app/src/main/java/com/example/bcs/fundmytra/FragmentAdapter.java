package com.example.bcs.fundmytra;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
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
                default:
                return null;
        }
    }

    private Context mContext;
    public FragmentAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MyProfileFragment();
        } else if (position == 1) {
            return new MySearchesFragment();
        } else {
            return new MyApplicationsFragment();
        }
    }
}
