package com.example.bcs.fundmytra;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    public EditText phone_num,email_id;
    public TextView click_here_to_login;
    public Button sign_up;
    String email,mobile;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String mobilePattern = "[0-9]{10}";
    EmailMobileModel model;
    ProgressDialog progressBar;
    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
        listeners();


        mAPIService= ApiUtils.getAPIService();
    }

    private void listeners() {

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=email_id.getText().toString().trim();
                mobile=phone_num.getText().toString().trim();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(mobile)) {
                    if (email.matches(emailPattern)) {
                        if (mobile.matches(mobilePattern)) {
                            model = new EmailMobileModel(email, mobile);
                            progressBar = new ProgressDialog(v.getContext());
                            progressBar.setCancelable(true);
                            progressBar.setMessage("Loading...");
                            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progressBar.setProgress(0);
                            progressBar.setMax(100);
                            progressBar.show();


                            mAPIService.savePost(model).enqueue(new Callback<JsonElement>() {


                                @Override
                                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                                    Gson gson =
                                            new GsonBuilder()
                                                    .registerTypeAdapter(Data.class, new MyDeserializer())
                                                    .create();

                                    if (response.code() == 200) {
                                        progressBar.dismiss();

                                        Toast.makeText(SignupActivity.this,"Successfully Signed up",Toast.LENGTH_SHORT).show();

                                        Data c = gson.fromJson(new Gson().toJson(response.body()), Data.class);
                                        System.out.println(c.id);

                                        Toast.makeText(SignupActivity.this, "Id" + c.id, Toast.LENGTH_SHORT).show();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("ID",c.id);
                                        bundle.putString("email",email);
                                        Intent intent=new Intent(SignupActivity.this,OtpActivity.class);
                                        intent.putExtras(bundle);
                                        startActivity(intent);

                                    } else {
                                        progressBar.dismiss();
                                        System.out.println(response.code());
                                        if (response.code() == 406) {
                                            Toast.makeText(SignupActivity.this, "Plz Verify ur email and mobile once again", Toast.LENGTH_SHORT).show();
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
                                        Toast.makeText(SignupActivity.this, "Check your  Internet Connection", Toast.LENGTH_SHORT).show();
                                    }
                                    call.cancel();
                                }
                            });
                        }
                        else {
                            Toast.makeText(SignupActivity.this,"Enter Valid Mobile number",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignupActivity.this,"Enter Valid Gmail",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignupActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        click_here_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        phone_num=(EditText)findViewById(R.id.input_phone);
        email_id=(EditText)findViewById(R.id.input_email);
        sign_up=(Button)findViewById(R.id.sign_up_2);
        click_here_to_login=(TextView)findViewById(R.id.click_here_to_login);
    }
}