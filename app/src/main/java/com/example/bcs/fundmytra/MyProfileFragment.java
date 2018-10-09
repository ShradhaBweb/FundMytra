package com.example.bcs.fundmytra;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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