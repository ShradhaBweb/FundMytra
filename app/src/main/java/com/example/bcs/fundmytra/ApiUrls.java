package com.example.bcs.fundmytra;

public class ApiUrls {


    private ApiUrls(){

    }
    private static String BASE_URL="http://103.21.59.241/fund-mytra/admin_app/";
    private static String SUB_URL=BASE_URL+"master_api/";
    public String OTP_URL=SUB_URL+"otp_verification";

    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
