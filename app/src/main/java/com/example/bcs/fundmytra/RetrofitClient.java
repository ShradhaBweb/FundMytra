package com.example.bcs.fundmytra;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit=null;
    public static Retrofit getClient(String otppUrl){
        if (retrofit==null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(otppUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit;
        }

    }
