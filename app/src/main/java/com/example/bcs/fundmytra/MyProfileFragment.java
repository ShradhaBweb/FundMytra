package com.example.bcs.fundmytra;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class MyProfileFragment extends Fragment {

    public MyProfileFragment() {

// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  SharedPreferences preferences=getActivity().getSharedPreferences("MyPref",0);
       String auth_id= PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("auth_id","s");

        Log.e("auth-id",auth_id);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myprofile, container, false);

    }

}