package com.example.bcs.fundmytra;

public class PasswordPost {

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


    public PasswordPost(String id, String otp) {
        this.id = id;
        this.otp = otp;
    }



    public String toString(){
        return "PasswordPost{"+"id='"+id +'\''+
                ",otp='" +otp+'}';
    }
}
