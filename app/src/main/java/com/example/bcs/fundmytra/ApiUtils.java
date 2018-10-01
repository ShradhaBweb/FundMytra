package com.example.bcs.fundmytra;

import retrofit2.Retrofit;

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "http://192.168.0.101/bweb/F/fund-mytra/";
    private static final String SUB_URL=BASE_URL+"master_api/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
    public static APIService getOtpService(){
        return RetrofitClient.getClient1(SUB_URL).create(APIService.class);

    }
}