package com.example.bcs.fundmytra;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfileFragment extends Fragment {
    private APIService mAPIService;
    ProgressDialog progressBar;
    TextView name,email,num;
    public MyProfileFragment() {

// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences= getContext().getApplicationContext().getSharedPreferences("MyPref",0);
        String s=preferences.getString("auth_id","sssss");
        Log.e("auth_id in Fragment",s);

        mAPIService= ApiUtils.getPasswordService(s);

        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage("Loading...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        mAPIService.myprofile().enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                System.out.println("response"+response.code());
                Gson gson =
                        new GsonBuilder()
                                .registerTypeAdapter(MyProfileData.class, new MyDeserializer1())
                                .create();
                if (response.code() == 200) {
                    progressBar.dismiss();
                    MyProfileData c = gson.fromJson(new Gson().toJson(response.body()), MyProfileData.class);
                    if (c.name==null){
                        name.setText("No Name");
                    }else {
                        name.setText(c.name);
                    }

                        email.setText(c.email);
                        num.setText(c.mobile_no);
                    System.out.println("id"+c.id);
                    System.out.println("name"+c.name);
                    System.out.println("email"+c.email);
                    System.out.println("mobile"+c.mobile_no);
                    System.out.println("login_code"+c.login_code);

                    Toast.makeText(getContext(),"profile showing",Toast.LENGTH_SHORT).show();

                } else {
                    progressBar.dismiss();
                    System.out.println(response.code());
                    if (response.code() == 406) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_myprofile, container, false);
        name =(TextView)view.findViewById(R.id.customer_name);
        email =(TextView)view.findViewById(R.id.customer_email);
         num =(TextView)view.findViewById(R.id.customer_no);
        return view;

    }
    public class MyDeserializer1 implements JsonDeserializer<MyProfileData> {
        @Override
        public MyProfileData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JsonElement data = json.getAsJsonObject().get("data");
            return new Gson().fromJson(data, MyProfileData.class);
        }
    }
}