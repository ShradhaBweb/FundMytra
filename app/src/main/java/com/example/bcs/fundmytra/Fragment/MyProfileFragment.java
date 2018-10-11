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

import com.example.bcs.fundmytra.Post;
import com.google.gson.JsonElement;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.bcs.fundmytra.APIService;
import com.example.bcs.fundmytra.ApiUtils;
import com.example.bcs.fundmytra.MyProfileData;
import com.example.bcs.fundmytra.R;

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

public class MyProfileFragment extends DialogFragment {
    private APIService mAPIService,apiService;
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
        apiService=ApiUtils.getUpdateService(auth_id);

        //init();
//        progressBar = new ProgressDialog(getContext());
//        progressBar.setCancelable(true);
//        progressBar.setMessage("Loading...");
//        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressBar.setProgress(0);
//        progressBar.setMax(100);
//        progressBar.show();
//
//        mAPIService.myprofile().enqueue(new Callback<MyProfileData>() {
//            @Override
//            public void onResponse(Call<MyProfileData> call, Response<MyProfileData> response) {
//                MyProfileData.ProfileData data=response.body().getData();
//                System.out.println("response"+data.getEmail());
//                System.out.println("response"+data.getLogin_code());
//                System.out.println("response"+data.getMobile_no());
//                System.out.println("response"+data.getName());
//                System.out.println("response"+response.body());
//
//                if (response.code() == 200) {
//                    progressBar.dismiss();
//
//                    if (data.getName()==null){
//                        name.setText("No Name");
//                    }else {
//                        name.setText(data.getName());
//                    }
//
//                    email.setText(data.getEmail());
//                    num.setText(data.getMobile_no());
//
//                    Toast.makeText(getContext(),"profile showing",Toast.LENGTH_SHORT).show();
//
//                } else {
//                    progressBar.dismiss();
//                    System.out.println(response.code());
//                    if (response.code() == 406) {
//                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MyProfileData> call, Throwable t) {
//
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


// Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_myprofile, container, false);
        name =(TextView)view.findViewById(R.id.customer_name);
        email =(TextView)view.findViewById(R.id.customer_email);
        num =(TextView)view.findViewById(R.id.customer_no);
        updatebtn=(ImageButton)view.findViewById(R.id.write);
        listener();
        init();
        return view;
    }

    private void listener() {
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.updatelayout,null);

                savebtn=(Button)dialogView.findViewById(R.id.save);
                cancelbtn=(Button)dialogView.findViewById(R.id.cancel);

                id1=(EditText)dialogView.findViewById(R.id.id);
                name1=(EditText)dialogView.findViewById(R.id.name);
                email1=(EditText)dialogView.findViewById(R.id.email);
                mobile1=(EditText)dialogView.findViewById(R.id.mobile);
                id1.setText(id);
                id1.setFocusable(false);
                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.MATCH_PARENT;
                boolean focusable = true;
                final PopupWindow popupWindow = new PopupWindow(dialogView, width, height, focusable);
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                cancelbtn.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                savebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtId=id1.getText().toString().trim();
                        edtName=name1.getText().toString().trim();
                        edtEmail=email1.getText().toString().trim();
                        edtMobile=mobile1.getText().toString().trim();
                        Log.e("ID", String.valueOf(edtId));
                        Log.e("name", String.valueOf(edtName));
                        Log.e("email", String.valueOf(edtEmail));
                        Log.e("mobile", String.valueOf(edtMobile));
                        if (!TextUtils.isEmpty(edtName)&& !TextUtils.isEmpty(edtEmail) && !TextUtils.isEmpty(edtMobile)){
                            if (edtEmail.matches(emailPattern) && edtMobile.matches(mobilePattern)){
                                post=new Post(id,edtName,edtEmail,edtMobile);
                                progressBar = new ProgressDialog(v.getContext());
                                progressBar.setCancelable(true);
                                progressBar.setMessage("Loading...");
                                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressBar.setProgress(0);
                                progressBar.setMax(100);
                                progressBar.show();
                                apiService.update(post).enqueue(new Callback<JsonElement>()
                                {
                                    @Override
                                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                                        if (response.code()==200){
                                            progressBar.dismiss();
                                            System.out.println(response.body());
                                            init();
                                            popupWindow.dismiss();
                                        }else {
                                            progressBar.dismiss();
                                            System.out.println(response.code());
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<JsonElement> call, Throwable t) {

                                        System.out.println(t.getMessage());
                                    }
                                });

                            }
                        }
                    }
                });



//                post=new Post(id,name,email,mobile);
////
////                apiService.update(post).enqueue(new Callback<JsonElement>() {
////                    @Override
////                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
////                        if (response.code()==200){
////                            Toast.makeText(getActivity(),"clicked",Toast.LENGTH_LONG).show();
////                            System.out.println(response.body());
////                        }else {
////                            System.out.println(response.code());
////                        }
////                    }
////
////                    @Override
////                    public void onFailure(Call<JsonElement> call, Throwable t) {
////                        System.out.println(t.getMessage());
////
////                    }
////                });
            }
        });


    }
    private void init() {

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

                    email.setText(data.getEmail());
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

}