package com.example.bcs.fundmytra;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG ="signUp" ;
    public EditText phone_num,email_id;
    public TextView click_here_to_login;
    private Button button;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        apiService=ApiUrls.getAPIService();

        init();
        listeners();

    }

    private void listeners() {
        phone_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        email_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        click_here_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            String id="12";
            String otp="226611";
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void init() {
        phone_num=(EditText)findViewById(R.id.input_phone);
        email_id=(EditText)findViewById(R.id.input_email);
        click_here_to_login=(TextView)findViewById(R.id.click_here_to_login);
    }
}
