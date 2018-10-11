package com.example.bcs.fundmytra.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.bcs.fundmytra.R;

public class LoginSignupActivity extends AppCompatActivity {
    private Button signup, login;

    private static final String PREF_LOGIN = "LOGIN_PREF";
    private static final String FLAG = "FLAG";
    private static final String FLAGOUT = "FLAGOUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // finish();
        setContentView(R.layout.activity_loginsignup);

        init();
        listeners();

    }
    public void init(){
        signup=(Button)findViewById(R.id.signup_1);
        login = (Button)findViewById(R.id.login);
    }

    public void listeners(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginSignupActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }

}
