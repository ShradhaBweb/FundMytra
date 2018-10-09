package com.example.bcs.fundmytra;

import retrofit2.http.POST;

public class Post {
    private String id;


    private String otp;

    public Post(String id) {
        this.id = id;
    }

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
    public Post(String id){
        this.id=id;
    }



    public String toString(){
        return "Post{"+"id='"+id +'\''+
                ",otp='" +otp+'}';
    }
}
