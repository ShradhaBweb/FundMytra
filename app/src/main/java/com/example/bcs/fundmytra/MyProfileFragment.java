package com.example.bcs.fundmytra;

import android.app.ProgressDialog;
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
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfileFragment extends Fragment {
    private APIService mAPIService;
    ProgressDialog progressBar;
    TextView name,email,num;
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
        View view=inflater.inflate(R.layout.fragment_myprofile, container, false);
        name =(TextView)view.findViewById(R.id.customer_name);
        email =(TextView)view.findViewById(R.id.customer_email);
         num =(TextView)view.findViewById(R.id.customer_no);
        return view;

    }

}