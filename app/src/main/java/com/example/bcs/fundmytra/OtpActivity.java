package com.example.bcs.fundmytra;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.chaos.view.PinView;
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
    String id="32";
    String otp="120765";
    private ProgressBar progressBar;
    private PinView pinview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otp);
        apiService=ApiUrls.getAPIService();

        txt1=(TextView)findViewById(R.id.phone_number);
        txt2=(TextView)findViewById(R.id.text1);
        txt3=(TextView)findViewById(R.id.text2);
        txt4=(TextView)findViewById(R.id.text3);
        txt5=(TextView)findViewById(R.id.text4);
        txt1.append(phone);


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


        
//        btn10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Post post=new Post(id,otp);
//                Log.e("id",post.getId());
//                Log.e("otp",post.getOtp());
//                apiService.verifyPost(post).enqueue(new Callback<Post>() {
//                    @Override
//                    public void onResponse(Call<Post> call, Response<Post> response) {
//                        Post responseUser=response.body();
//                        if (response.code() == 200){
//                            System.out.println(response.code());
//                            System.out.println(response);
//                            System.out.println(response.body());
//                            System.out.println("response"+response.body().toString());
//                            System.out.println("id"+responseUser.getOtp());
//                        }else {
//                            assert responseUser != null;
//                           System.out.println("responseCode"+response.code());
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Post> call, Throwable t) {
//                        System.out.println("response"+t.getMessage());
//
//                    }
//                });
//            }
//
//
//        });




       // listener();

    }


    public void listener(){
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
            }
        });

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
            int numbers1,numbers2,numbers3,numbers4,numbers5,numbers6;

       //    Log.e("number",otpNumbers);
//             numbers2= Integer.valueOf(otpMunbers2);
//             numbers3= Integer.valueOf(otpNumbers3);
//             numbers4= Integer.valueOf(otpMunbers4);
//             numbers5= Integer.valueOf(otpNumbers5);
//             numbers6= Integer.valueOf(otpMunbers6);
            String otp1=otpNumbers1+""+otpNumbers2 +""+otpNumbers3+""+otpNumbers4+""+otpNumbers5+""+otpNumbers6;
           // int otp=Integer.valueOf(otp1);
       //     int n=Integer.parseInt(otp1);
           Log.e("numbers", String.valueOf(otp1));
           int lenght=String.valueOf(otp1).length();
           if (lenght==6){
               Log.e("6 digit",otp1);
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
