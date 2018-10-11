package com.example.bcs.fundmytra.Fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.bcs.fundmytra.APIService;
import com.example.bcs.fundmytra.ApiUtils;
import com.example.bcs.fundmytra.MyProfileData;
import com.example.bcs.fundmytra.R;

public class MyProfileFragment extends Fragment {
    private APIService mAPIService;
    ProgressDialog progressBar;
    TextView name,email,num;
    ImageButton updatebtn;
    View view;
    String auth_id,id,edtId,edtName,edtEmail,edtMobile;
    Post post;
    Context context=getActivity();
    AlertDialog.Builder alertDialogBuilder;
    Button savebtn,cancelbtn;
    EditText id1,name1,email1,mobile1;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String mobilePattern = "[0-9]{10}";
    public MyProfileFragment() {

// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences= getContext().getApplicationContext().getSharedPreferences("MyPref",0);
         auth_id=preferences.getString("auth_id","sssss");
         id=preferences.getString("id","defaultValue");
        Log.e("auth_id in Fragment",auth_id);
        Log.e("ID",id);
        mAPIService= ApiUtils.getMyprofile(auth_id);

        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage("Loading...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        mAPIService.myprofile().enqueue(new Callback<MyProfileData>() {
            @Override
            public void onResponse(Call<MyProfileData> call, Response<MyProfileData> response) {
                MyProfileData.ProfileData data=response.body().getData();
                System.out.println("response"+data.getEmail());
                System.out.println("response"+data.getLogin_code());
                System.out.println("response"+data.getMobile_no());
                System.out.println("response"+data.getName());
                System.out.println("response"+response.body());

                if (response.code() == 200) {
                    progressBar.dismiss();

                   if (data.getName()==null){
                       name.setText("No Name");
                    }else {
                      name.setText(data.getName());
                   }
                        if (data.getEmail().length()>20){
                       String email_id=data.getEmail();
                       String[] splitString=email_id.split("@");
                       String afterSplit =splitString[0]+"\n"+splitString[1];
                            email.setText(data.getEmail());
                        }else {
                            email.setText(data.getEmail());
                        }

                        num.setText(data.getMobile_no());

                        Toast.makeText(getContext(),"profile showing",Toast.LENGTH_SHORT).show();

                } else {
                    progressBar.dismiss();
                    System.out.println(response.code());
                    if (response.code() == 406) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyProfileData> call, Throwable t) {

            }
        });

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