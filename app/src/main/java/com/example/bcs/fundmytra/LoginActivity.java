package com.example.bcs.fundmytra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button  login;  
    private EditText email_phone,password;
    String emailPhone,pass;
    LoginModel loginModel;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String mobilePattern = "[0-9]{10}";
    ProgressDialog progressBar;
    APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        mAPIService= ApiUtils.getLoginService();
        init();
        listeners();
        }

    private void listeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailPhone = email_phone.getText().toString().trim();
                pass = password.getText().toString().trim();
                if (!TextUtils.isEmpty(emailPhone) && !TextUtils.isEmpty(pass)) {
                    if (emailPhone.matches(emailPattern) || (emailPhone.matches(mobilePattern))) {

                            loginModel = new LoginModel(emailPhone, pass);
                            progressBar = new ProgressDialog(v.getContext());
                            progressBar.setCancelable(true);
                            progressBar.setMessage("Loading...");
                            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progressBar.setProgress(0);
                            progressBar.setMax(100);
                            progressBar.show();

                            mAPIService.login(loginModel).enqueue(new Callback<JsonElement>() {

                                @Override
                                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                                    Gson gson =
                                            new GsonBuilder()
                                                    .registerTypeAdapter(Data.class, new MyDeserializer())
                                                    .create();

                                    if (response.code() == 200) {
                                        progressBar.dismiss();

                                        Toast.makeText(LoginActivity.this, "Successfully Signed up", Toast.LENGTH_SHORT).show();

                                        Data c = gson.fromJson(new Gson().toJson(response.body()), Data.class);
                                        System.out.println(c.id);
                                        System.out.println(c.auth_id);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("id", c.id);
                                        bundle.putString("auth_id", c.auth_id);
                                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                                        intent.putExtras(bundle);
                                        startActivity(intent);

                                    } else {
                                        progressBar.dismiss();
                                        System.out.println(response.code());
                                        if (response.code() == 406) {
                                            Toast.makeText(LoginActivity.this, "Plz Verify ur email and mobile once again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<JsonElement> call, Throwable t) {
                                    progressBar.dismiss();
                                    System.out.println(t.getMessage());
                                    if (t.getMessage().contains("Failed to connect")) {
                                        Toast.makeText(LoginActivity.this, "Check your  Internet Connection", Toast.LENGTH_SHORT).show();
                                    }
                                    call.cancel();
                                }
                            });

                    } else {
                        Toast.makeText(LoginActivity.this, "enter valid mobile no or email_id", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                    }

            }

        });
    }

    private void init() {
        email_phone=(EditText)findViewById(R.id.email_phone);
        password=(EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.btn_login);
    }
}