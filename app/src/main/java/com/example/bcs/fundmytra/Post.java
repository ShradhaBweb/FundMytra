package com.example.bcs.fundmytra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    private String id;


    private String otp;

    public String getId() {
        return id;
    }

    public String getOtp() {
        return otp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }


    public Post(String id, String otp) {
        this.id = id;
        this.otp = otp;
    }



    public String toString(){
        return "Post{"+"id='"+id +'\''+
                ",otp='" +otp+'}';
    }
}
