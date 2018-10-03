package com.example.bcs.fundmytra;

public class LoginModel {
    private String email_mobile;

    public LoginModel(String email_mobile, String password) {
        this.email_mobile = email_mobile;
        this.password = password;
    }

    public String getEmail_phone() {
        return email_mobile;
    }

    public void setEmail_phone(String email_phone) {
        this.email_mobile = email_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


}
