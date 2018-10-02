package com.example.bcs.fundmytra;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class RetrofitClient {
    private static SharedPreferences sharedPreferences;

    public static Retrofit getClient(String url) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Response response = chain.proceed(original);


                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Admin-Service", "fundmitra-RESTApi")
                        .header("Auth-Key", "BwebRestAPI")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });


        OkHttpClient client = httpClient.build();

        Retrofit retrofit;

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    public static Retrofit getOtpClient(String url,final String authId) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Response response = chain.proceed(original);
                Log.e("auth_id",authId);

                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Admin-Service", "fundmitra-RESTApi")
                        .header("Auth-Key", "BwebRestAPI")
                        .header("Auth-Id",authId)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });


        //   Data1 c = gson.fromJson(myDeserializer, Data1.class);
        OkHttpClient client = httpClient.build();

        Retrofit retrofit;

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public  static Retrofit getOtpClient(String subUrl, final String authId){


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Response response = chain.proceed(original);
                String auth_ID=authId;
                Log.e("AuthId",authId);

                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Admin-Service", "fundmitra-RESTApi")
                        .header("Auth-Key", "BwebRestAPI")
                        .header("Auth-Id",auth_ID)
                        .method(original.method(), original.body())
                        .build();
                Log.e("id",request.header("Auth-Id"));

                return chain.proceed(request);
            }
        });


        OkHttpClient client = httpClient.build();

        Retrofit retrofit;

        retrofit = new Retrofit.Builder()
                .baseUrl(subUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public static void getData(Context context){
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        String authId=sharedPreferences.getString("Auth-id","defaultValue");
        Log.e("id",authId);

    }
}



