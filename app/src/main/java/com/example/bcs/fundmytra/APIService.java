package com.example.bcs.fundmytra;


import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("admin_app/master_api/app_signup")
    Call<JsonElement>  savePost(@Body EmailMobileModel add);

    @POST("admin_app/master_api/otp_verification")
    Call<Post> verifyPost(@Body Post post);

    @POST("admin_app/master_api/update_password")
    Call<JsonElement> password(@Body Password post);

    @POST("admin_app/master_api/login_app")
    Call<JsonElement> login(@Body LoginModel login);
}