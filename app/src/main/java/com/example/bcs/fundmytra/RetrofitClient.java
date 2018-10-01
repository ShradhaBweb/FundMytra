package com.example.bcs.fundmytra;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


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

    public static Retrofit getClient1(String subUrl){
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
                .baseUrl(subUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

}



