package com.example.bcs.fundmytra;

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
