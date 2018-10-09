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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyProfileFragment extends Fragment implements View.OnClickListener {

    private ImageButton editbtn;

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
        View view= inflater.inflate(R.layout.fragment_myprofile, container, false);
        editbtn=(ImageButton)view.findViewById(R.id.write);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Clicked",Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.write){

        }



    }
}