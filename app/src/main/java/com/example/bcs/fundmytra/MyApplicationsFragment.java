package com.example.bcs.fundmytra;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

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

        RelativeLayout relativeLayout=(RelativeLayout) inflater.inflate(R.layout.fragment_myapplications, container, false);
        btn_track=(Button) relativeLayout.findViewById(R.id.btn_track);
        listeners();
        return relativeLayout;

    }
  public  void  listeners(){
      btn_track.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent=new Intent(getActivity(),DashboardActivity.class);
            intent.putExtra("send",1);
            startActivity(intent);

            //  DashboardActivity da=new DashboardActivity();
             // da.callFragment();

//                SalaryFragment fragment = new SalaryFragment();
            //   FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
             //  transaction.replace(R.id.frame, new TrackApplicationFragment()).commit();
//                transaction.commit();
          }
      });
    }
}

