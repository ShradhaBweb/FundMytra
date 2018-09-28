package com.example.bcs.fundmytra;


import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

//  /app_signup?"email"="Vasudevan.bweb@gmail.com"&"mobile"="9876543210"


    @POST("admin_app/master_api/app_signup")
   Call<JsonElement>  savePost(@Body EmailMobileModel add);
}
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {



    @POST("master_api/otp_verification")

    Call<Post> verifyPost(@Body Post post);


}
