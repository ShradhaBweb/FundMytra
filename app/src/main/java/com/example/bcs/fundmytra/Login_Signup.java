package com.example.bcs.fundmytra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Login_Signup extends AppCompatActivity {
    private Button signup, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__signup);

        init();
        listeners();

    }
    public void init(){
        signup=(Button)findViewById(R.id.signup);
        login = (Button)findViewById(R.id.login);
    }

    public void listeners(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Signup.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Signup.this,signup_screen.class);
                startActivity(intent);
            }
        });
    }
}
