package com.example.bcs.fundmytra;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {


    @POST("admin_app/master_api/app_signup")
    Call<JsonElement>  savePost(@Body EmailMobileModel add);

    @POST("master_api/otp_verification")
    Call<Post> verifyPost(@Body Post post);


}
