package com.example.bcs.fundmytra;

import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

public class IntroductionActivity extends AppCompatActivity {

    TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        getSupportActionBar().hide();
        String text1="fund";
        String text2="mytra";
        int h=R.string.logtext_1;

        textView=(TextView)findViewById(R.id.logText_one);

        String text=text1+
                "<b>"+text2+"</b>";
        textView.setText(Html.fromHtml(text));


    }
}
