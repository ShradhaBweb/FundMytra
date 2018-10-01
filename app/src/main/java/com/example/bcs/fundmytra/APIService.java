package com.example.bcs.fundmytra;


import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("admin_app/master_api/app_signup")
   Call<JsonElement>  savePost(@Body EmailMobileModel add);
}