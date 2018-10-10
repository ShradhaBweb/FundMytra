package com.example.bcs.fundmytra;


import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {

    @POST("admin_app/master_api/app_signup")
    Call<JsonElement>  savePost(@Body EmailMobileModel add);

    @POST("admin_app/master_api/otp_verification")
    Call<Post> verifyPost(@Body Post post);

    @POST("admin_app/master_api/update_password")
    Call<JsonElement> password(@Body Password post);

    @POST("admin_app/master_api/login_app")
    Call<JsonElement> login(@Body LoginModel login);

    @POST("admin_app/master_api/logout_app")
    Call<Post> logout(@Body Post post);

    @GET("admin_app/master_api/my_profile")
    Call<MyProfileData> myprofile();


    @PUT("admin_app/master_api/logout_app")
    Call<JsonElement>update(@Body UpdateModel updateModel);


}