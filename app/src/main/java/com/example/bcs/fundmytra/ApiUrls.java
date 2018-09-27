package com.example.bcs.fundmytra;

public class ApiUrls {


    private ApiUrls(){

    }
    private static String BASE_URL="http://192.168.0.101/bweb/F/fund-mytra/admin_app/";
    private static String SUB_URL=BASE_URL+"master_api/";
    public String OTP_URL=SUB_URL+"otp_verification";

    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
