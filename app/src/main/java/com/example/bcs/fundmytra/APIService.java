package com.example.bcs.fundmytra;


import com.example.bcs.fundmytra.Model.EmailMobileModel;
import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

//  /app_signup?"email"="Vasudevan.bweb@gmail.com"&"mobile"="9876543210"


    @POST("admin_app/master_api/app_signup")
    Call<JsonElement>  savePost(@Body EmailMobileModel add);

    @POST("master_api/otp_verification")
    Call<JsonElement> verifyPost(@Body Post post);

    @POST("admin_app/master_api/update_password")
    Call<JsonElement> password(@Body Password post);


}
