package com.example.bcs.fundmytra.Model;

public class EmailMobileModel {
    private String email;
    private String mobile;


    public EmailMobileModel() {
    }

    public EmailMobileModel(String email, String mobile) {
        this.email = email;
        this.mobile = mobile;
       // this.id = id;
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
