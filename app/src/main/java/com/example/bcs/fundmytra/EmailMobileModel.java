package com.example.bcs.fundmytra;

public class EmailMobileModel {
    private String email;
    private String mobile;
    private String id;

    public EmailMobileModel() {
    }

    public EmailMobileModel(String email, String mobile) {
        this.email = email;
        this.mobile = mobile;
       // this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
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
