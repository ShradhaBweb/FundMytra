package com.example.bcs.fundmytra;
public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.0.101/bweb/F/fund-mytra/";
    private static String SUB_URL=BASE_URL+"master_api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}