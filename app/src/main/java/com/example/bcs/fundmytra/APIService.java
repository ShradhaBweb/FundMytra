package com.example.bcs.fundmytra;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({"Content-Type: application/json",
            "Admin-Service: fundmitra-RESTApi",
            "Auth-Key: BwebRestAPI"})
    @POST("/otp_verification")
    @FormUrlEncoded
    Call<Post> verifyPost(@Field("id") String id,
                          @Field("otp")String otp);
}
