package com.example.bcs.fundmytra.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bcs.fundmytra.APIService;
import com.example.bcs.fundmytra.ApiUtils;
import com.example.bcs.fundmytra.Password;
import com.example.bcs.fundmytra.PasswordPost;
import com.example.bcs.fundmytra.R;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordConfirmation extends AppCompatActivity {


    public Button btn_save;
    String password,reconfirm_password;
    Password pass;
    String id;
    public APIService mAPIService;
    ProgressDialog progressBar;
    public EditText edit_password,edit_reconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_confirmation);
        Intent intent=getIntent();
//        email=intent.getStringExtra("email");
        id=intent.getStringExtra("customer_id");
        init();

        listener();

        mAPIService= ApiUtils.getAPIService();
    }

    public void listener() {




            btn_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    password=edit_password.getText().toString().trim();
                    reconfirm_password=edit_reconfirm.getText().toString().trim();
                    if(!TextUtils.isEmpty(password) && !TextUtils.isEmpty(reconfirm_password)) {
                        if (password.equals(reconfirm_password)) {
//                            if (mobile.matches(mobilePattern)) {
                        pass = new Password(id, reconfirm_password);
                                progressBar = new ProgressDialog(v.getContext());
                                progressBar.setCancelable(true);
                                progressBar.setMessage("Loading...");
                                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressBar.setProgress(0);
                                progressBar.setMax(100);
                                progressBar.show();


                                mAPIService.password(pass).enqueue(new Callback<JsonElement>() {


                                    @Override
                                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                                        System.out.println("response"+response.code());
//                                        Gson gson =
//                                                new GsonBuilder()
//                                                        .registerTypeAdapter(Data.class, new MyDeserializer())
//                                                        .create();
                                        System.out.println("response"+response.code());
                                        if (response.code() == 200) {
                                            progressBar.dismiss();

                                            Toast.makeText(PasswordConfirmation.this,"Successfully Signed up",Toast.LENGTH_SHORT).show();

//                                            Data c = gson.fromJson(new Gson().toJson(response.body()), Data.class);
//                                            System.out.println(c.id);

//                                            Toast.makeText(SignupActivity.this, "Id" + c.id, Toast.LENGTH_SHORT).show();
//                                            Bundle bundle = new Bundle();
//                                            bundle.putString("ID",c.id);
//                                            bundle.putString("email",email);
                                            Intent intent=new Intent(PasswordConfirmation.this,DashboardActivity.class);
//                                            intent.putExtras(bundle);
                                            startActivity(intent);

                                        } else {
                                            progressBar.dismiss();
                                            System.out.println(response.code());
                                            if (response.code() == 406) {
                                                Toast.makeText(PasswordConfirmation.this, "Plz Verify ur email and mobile once again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<JsonElement> call, Throwable t) {
                                        progressBar.dismiss();
                                        System.out.println(t.getMessage());
                                        Log.e("socket",t.toString());
                                        Log.e("socket",t.getMessage());
                                        if (t.getMessage().contains("Failed to connect")) {
                                            Toast.makeText(PasswordConfirmation.this, "Check your  Internet Connection", Toast.LENGTH_SHORT).show();
                                        }
                                        call.cancel();
                                    }
                                });
                            }
                    else {
                        Toast.makeText(PasswordConfirmation.this,"Enter Correct password",Toast.LENGTH_SHORT).show();
                    }
//                        else {
//                            Toast.makeText(SignupActivity.this,"Enter Valid Gmail",Toast.LENGTH_SHORT).show();
//                        }
                    }else {
                        Toast.makeText(PasswordConfirmation.this,"Empty",Toast.LENGTH_SHORT).show();
                    }
                }
            });

//            click_here_to_login.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
//                    startActivity(intent);
//                }
//            });
        }


    public void init() {

        edit_password=(EditText)findViewById(R.id.edit_password);
        edit_reconfirm=(EditText)findViewById(R.id.edit_reconfirm);
        btn_save=(Button)findViewById(R.id.btn_savePassword);
    }
}
