package com.example.bcs.fundmytra;

import android.content.SharedPreferences;

import retrofit2.Retrofit;

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "http://192.168.0.101/bweb/F/fund-mytra/";


    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
    public static APIService getOtpService(String authId){

        return RetrofitClient.getOtpClient(BASE_URL,authId).create(APIService.class);

    }
    public static APIService getPasswordService(String authId){

        return RetrofitClient.getPasswordClient(BASE_URL,authId).create(APIService.class);

    }
    public static APIService getLoginService(){

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }

    public static APIService getLogoutService(String authId){
        return RetrofitClient.getLogoutClient(BASE_URL,authId).create(APIService.class);
    }
}