package com.example.bcs.fundmytra;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signup_screen extends AppCompatActivity {
    public EditText phone_num,email_id;
    public TextView click_here_to_login;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        phone_num=(EditText)findViewById(R.id.input_phone);
        email_id=(EditText)findViewById(R.id.input_email);
        click_here_to_login=(TextView)findViewById(R.id.click_here_to_login);
        btn_signup = (Button)findViewById(R.id.btn_signup);


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

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup_screen.this, Otp_activity.class);
                startActivity(intent);
            }
        });
    }
    }
