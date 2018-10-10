package com.example.bcs.fundmytra;

import retrofit2.http.POST;

public class Post {
    private String id;
    private String otp;
    private String name;
    private String email;
    private String mobile;

    public Post(String id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }



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




    public String toString(){
        return "Post{"+"id='"+id +'\''+
                ",otp='" +otp+'}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
