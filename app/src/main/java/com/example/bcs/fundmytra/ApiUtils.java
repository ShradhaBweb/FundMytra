package com.example.bcs.fundmytra;
public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://103.21.59.241/fund-mytra/";
    private static String SUB_URL=BASE_URL+"master_api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }
    public static APIService getOtpService(String authId){

        return RetrofitClient.getOtpClient(BASE_URL,authId).create(APIService.class);

    } public static APIService getPasswordService(String authId){

        return RetrofitClient.getPasswordClient(BASE_URL,authId).create(APIService.class);
        }
    public static APIService getLoginService(){

        return RetrofitClient.getLoginClient(BASE_URL).create(APIService.class);

    }
    public static APIService getLogoutService(String authId){
        return RetrofitClient.getLogoutClient(BASE_URL,authId).create(APIService.class);
    }
}