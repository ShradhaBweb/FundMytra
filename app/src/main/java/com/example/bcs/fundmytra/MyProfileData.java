package com.example.bcs.fundmytra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyProfileData {
    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("mobile_no")
    @Expose
    public String mobile_no;

    @SerializedName("login_code")
    @Expose
    public String login_code;



    // Getter Methods




}

