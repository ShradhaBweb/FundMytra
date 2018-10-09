package com.example.bcs.fundmytra;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG ="OtpActivity" ;
    EditText edt1,edt2,edt3,edt4,edt5,edt6;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn12,btn10;
    ImageButton imageButton;
    TextView txt1,txt2,txt3,txt4,txt5;
    String phone="123456789";
    APIService apiService;
    String id,email,otp,Auth_id,mobile;
    SharedPreferences sharedPreferences;
    Data c;

    private ProgressDialog progressBar;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otp);

//        Intent intent=getIntent();
//        email=intent.getStringExtra("email");
//        id=intent.getStringExtra("ID");
//        Auth_id=intent.getStringExtra("auth_id");
//        mobile=intent.getStringExtra("mobile");
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("MyPref",0);
       id= preferences.getString("id","1");
       Auth_id=preferences.getString("auth_id","1");
       email=preferences.getString("email","1");
       mobile=preferences.getString("mobile","1");


        Log.e("id",id);
        Log.e("email",email);
        Log.e("auth_id",Auth_id);
        apiService=ApiUtils.getOtpService(Auth_id);



        txt1=(TextView)findViewById(R.id.phone_number);
        txt2=(TextView)findViewById(R.id.text1);
        txt3=(TextView)findViewById(R.id.text2);
        txt4=(TextView)findViewById(R.id.text3);
        txt5=(TextView)findViewById(R.id.text4);
        txt1.append(email);


        edt1=(EditText)findViewById(R.id.otp_text1);
        edt2=(EditText)findViewById(R.id.otp_text2);
        edt3=(EditText)findViewById(R.id.otp_text3);
        edt4=(EditText)findViewById(R.id.otp_text4);
        edt5=(EditText)findViewById(R.id.otp_text5);
        edt6=(EditText)findViewById(R.id.otp_text6);


        btn0=(Button)findViewById(R.id.button0);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        btn10=(Button)findViewById(R.id.button10);
        imageButton=(ImageButton)findViewById(R.id.button12);

    }




    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        int number1=edt1.getText().toString().trim().length();
        int number2=edt2.getText().toString().trim().length();
        int number3=edt3.getText().toString().trim().length();
        int number4=edt4.getText().toString().trim().length();
        int number5=edt5.getText().toString().trim().length();
        int number6=edt6.getText().toString().trim().length();

        if (view.getId()==R.id.button1){
            edt2.requestFocus();
            Log.e("buttom","one");
            if (number1==0){
                edt1.setText("1");
                edt2.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("1");
                    edt3.requestFocus();
                } else {
                    if (number3==0){
                        edt3.setText("1");
                        edt4.requestFocus();
                    } else {
                        if (number4==0){
                            edt4.setText("1");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("1");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("1");
                                }
                            }
                        }
                    }
                }

            }

            Log.e("clicked","button1");
        }else if (view.getId()==R.id.button2){
            if (number1==0){
                edt1.setText("2");
                edt2.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("2");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("2");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("2");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("2");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("2");
                                }
                            }
                        }
                    }
                }
            }

            Log.e("clicked","button2");
        }
        else if (view.getId()==R.id.button3){
            if (number1==0){
                edt1.setText("3");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("3");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("3");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("3");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("3");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("3");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button3");

        }
        else if (view.getId()==R.id.button4){
            if (number1==0){
                edt1.setText("4");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("4");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("4");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("4");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("4");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("4");
                                }
                            }
                        }
                    }
                }
            }

            Log.e("clicked","button4");
        }
        else if (view.getId()==R.id.button5){
            if (number1==0){
                edt1.setText("5");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("5");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("5");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("5");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("5");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("5");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button5");
        }else if (view.getId()==R.id.button6){
            if (number1==0){
                edt1.setText("6");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("6");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("6");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("6");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("6");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("6");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button6");
        }else if (view.getId()==R.id.button7){
            if (number1==0){
                edt1.setText("7");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("7");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("7");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("7");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("7");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("7");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button7");
        }else if (view.getId()==R.id.button8){
            if (number1==0){
                edt1.setText("8");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("8");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("8");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("8");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("8");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("8");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button8");
        }else if (view.getId()==R.id.button9){
            if (number1==0){
                edt1.setText("9");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("9");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("9");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("9");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("9");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("9");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button9");
        }else if (view.getId()==R.id.button10){
            String otpNumbers1=edt1.getText().toString().trim();
            String otpNumbers2=edt2.getText().toString().trim();
            String otpNumbers3=edt3.getText().toString().trim();
            String otpNumbers4=edt4.getText().toString().trim();
            String otpNumbers5=edt5.getText().toString().trim();
            String otpNumbers6=edt6.getText().toString().trim();

            otp=otpNumbers1+""+otpNumbers2 +""+otpNumbers3+""+otpNumbers4+""+otpNumbers5+""+otpNumbers6;

            Log.e("numbers", String.valueOf(otp));
            int lenght=String.valueOf(otp).length();
            if (lenght==6){
                Log.e("6 digit",otp);
                progressBar = new ProgressDialog(view.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("Loading...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();
                Post post=new Post(id,otp);
                apiService.verifyPost(post).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Gson gson =
                                new GsonBuilder()
                                        .registerTypeAdapter(Data.class, new MyDeserializer())
                                        .create();
                        if (response.code()==200){
                            progressBar.dismiss();
//                            Bundle bundle = new Bundle();
//                            bundle.putString("customer_id",id);
//                            bundle.putString("auth_id",Auth_id);
//                            bundle.putString("email",email);
//                            bundle.putString("mobile",mobile);
                            Intent intent=new Intent(OtpActivity.this,PasswordConfirmation.class);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }else if(response.code()==406)
                        {
                            System.out.println(response.code());
                            if (response.code()==406){
                                progressBar.dismiss();

                               
                            }
                        } else {
                            progressBar.dismiss();
                            Toast.makeText(getApplicationContext(),"Invalid otp",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        progressBar.dismiss();
                        System.out.println(t.getMessage());
                        if (t.getMessage().contains("Failed to connect")) {
                            Toast.makeText(OtpActivity.this, "Check your  Internet Connection", Toast.LENGTH_SHORT).show();
                        }
                        call.cancel();

                    }
                });
            }
            // Log.e("integer", String.valueOf(n));

        }
        else if (view.getId()==R.id.button0){
            if (number1==0){
                edt1.setText("0");
                edt1.requestFocus();
            }else {
                if (number2==0){
                    edt2.setText("0");
                    edt3.requestFocus();
                }else {
                    if (number3==0){
                        edt3.setText("0");
                        edt4.requestFocus();
                    }else {
                        if (number4==0){
                            edt4.setText("0");
                            edt5.requestFocus();
                        } else {
                            if (number5==0){
                                edt5.setText("0");
                                edt6.requestFocus();
                            }else {
                                if (number6==0){
                                    edt6.setText("0");
                                }
                            }
                        }
                    }
                }
            }
            Log.e("clicked","button11");
        }else if (view.getId()==R.id.button12){
            if (number6>0){
                edt6.getText().delete(number6-1,number6);
                edt5.requestFocus();

            }else {
                if (number5>0){
                    edt5.getText().delete(number5-1,number5);
                    edt4.requestFocus();
                }else {
                    if (number4>0){
                        edt4.getText().delete(number4-1,number4);
                        edt3.requestFocus();
                    }else {
                        if (number3>0){
                            edt3.getText().delete(number3-1,number3);
                            edt2.requestFocus();
                        }else {
                            if (number2>0){
                                edt2.getText().delete(number2-1,number2);
                                edt1.requestFocus();
                            }else {
                                if (number1>0){
                                    edt1.getText().delete(number1-1,number1);

                                }
                            }
                        }
                    }

                }
            }


            Log.e("clicked","button12");
        }


    }

}