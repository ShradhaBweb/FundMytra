package com.example.bcs.fundmytra;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
    public EditText phone_num,email_id;
    public TextView click_here_to_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

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
    }

    private void init() {
        phone_num=(EditText)findViewById(R.id.input_phone);
        email_id=(EditText)findViewById(R.id.input_email);
        click_here_to_login=(TextView)findViewById(R.id.click_here_to_login);
    }
}
