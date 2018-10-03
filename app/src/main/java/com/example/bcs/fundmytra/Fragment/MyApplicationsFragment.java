package com.example.bcs.fundmytra.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.bcs.fundmytra.Activity.DashboardActivity;
import com.example.bcs.fundmytra.R;

public class MyApplicationsFragment extends Fragment {
    Button btn_track;
    public MyApplicationsFragment() {
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

        View view=(View) inflater.inflate(R.layout.fragment_myapplications, container, false);
        btn_track=(Button) view.findViewById(R.id.btn_track);
        listeners();
        return view;

    }
  public  void  listeners(){
      btn_track.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getActivity(), DashboardActivity.class);
              intent.putExtra("send", 1);
              startActivity(intent);
//              TrackApplicationFragment fragment= new TrackApplicationFragment();
//              android.support.v4.app.FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//              transaction.replace(R.id.frag, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
//              transaction.addToBackStack(null);  // this will manage backstack
//              transaction.commit();

          }
      });
    }
}

