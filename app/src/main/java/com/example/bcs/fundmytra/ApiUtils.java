package com.example.bcs.fundmytra;
public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.0.101/bweb/F/fund-mytra/";

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
    public static APIService getMyprofile(String authId){

        return RetrofitClient.getMyprofile(BASE_URL,authId).create(APIService.class);
    }

    public static APIService getUpdateService(String authId){
        return RetrofitClient.getUpdateClient(BASE_URL,authId).create(APIService.class);
    }
}