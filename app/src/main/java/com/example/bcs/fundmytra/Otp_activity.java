package com.example.bcs.fundmytra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.fxn769.Numpad;

public class Otp_activity extends AppCompatActivity implements View.OnClickListener{
    Numpad numpad;
    EditText editText1,editText2,editText3,editText4;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,button12;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_activity);
        getSupportActionBar().hide();


        editText1=(EditText)findViewById(R.id.otp_text1);
        editText2=(EditText)findViewById(R.id.otp_text2);
        editText3=(EditText)findViewById(R.id.otp_text3);
        editText4=(EditText)findViewById(R.id.otp_text4);

        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        imageButton=(ImageButton)findViewById(R.id.button12);

    }

    @Override
    public void onClick(View view) {
        int number1=editText1.getText().toString().trim().length();
        int number2=editText2.getText().toString().trim().length();
        int number3=editText3.getText().toString().trim().length();
        int number4=editText4.getText().toString().trim().length();
        if (view.getId()==R.id.button1){
            editText2.requestFocus();
            Log.e("buttom","one");
            if (number1==0){
                editText1.setText("1");
                editText2.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("1");
                    editText3.requestFocus();
                } else {
                    if (number3==0){
                        editText3.setText("1");
                        editText4.requestFocus();
                    } else {
                        if (number4==0){
                            editText4.setText("1");
                        }
                    }
                }

            }

            Log.e("clicked","button1");
        }else if (view.getId()==R.id.button2){
            if (number1==0){
                editText1.setText("2");
                editText2.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("2");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("2");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("2");
                        }
                    }
                }
            }

            Log.e("clicked","button2");
        }
        else if (view.getId()==R.id.button3){
            if (number1==0){
                editText1.setText("3");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("3");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("3");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("3");
                        }
                    }
                }
            }
            Log.e("clicked","button3");

        }
        else if (view.getId()==R.id.button4){
            if (number1==0){
                editText1.setText("4");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("4");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("4");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("4");
                        }
                    }
                }
            }

            Log.e("clicked","button4");
        }
        else if (view.getId()==R.id.button5){
            if (number1==0){
                editText1.setText("5");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("5");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("5");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("5");
                        }
                    }
                }
            }
            Log.e("clicked","button5");
        }else if (view.getId()==R.id.button6){
            if (number1==0){
                editText1.setText("6");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("6");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("6");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("6");
                        }
                    }
                }
            }
            Log.e("clicked","button6");
        }else if (view.getId()==R.id.button7){
            if (number1==0){
                editText1.setText("7");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("7");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("7");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("7");
                        }
                    }
                }
            }
            Log.e("clicked","button7");
        }else if (view.getId()==R.id.button8){
            if (number1==0){
                editText1.setText("8");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("8");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("8");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("8");
                        }
                    }
                }
            }
            Log.e("clicked","button8");
        }else if (view.getId()==R.id.button9){
            if (number1==0){
                editText1.setText("9");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("9");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("9");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("9");
                        }
                    }
                }
            }
            Log.e("clicked","button9");
        }else if (view.getId()==R.id.button0){
            if (number1==0){
                editText1.setText("0");
                editText1.requestFocus();
            }else {
                if (number2==0){
                    editText2.setText("0");
                    editText3.requestFocus();
                }else {
                    if (number3==0){
                        editText3.setText("0");
                        editText4.requestFocus();
                    }else {
                        if (number4==0){
                            editText4.setText("0");
                        }
                    }
                }
            }
            Log.e("clicked","button11");
        }else if (view.getId()==R.id.button12){

            if (number4>0){
                editText4.getText().delete(number4-1,number4);
                editText3.requestFocus();
            }else {
                if (number3>0){
                    editText3.getText().delete(number3-1,number3);
                    editText2.requestFocus();
                }else {
                    if (number2>0){
                        editText2.getText().delete(number2-1,number2);
                        editText1.requestFocus();
                    }else {
                        if (number1>0){
                            editText1.getText().delete(number1-1,number1);

                        }
                    }
                }
            }
            Log.e("clicked","button12");
        }
    }


}
