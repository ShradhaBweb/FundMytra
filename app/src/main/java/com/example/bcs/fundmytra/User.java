package com.example.bcs.fundmytra;


import com.google.gson.annotations.SerializedName;

public class User {

//    private String email;
//    private String mobile;
//    private String id;
//    private String createdAt;


    @SerializedName("id")
    private String id;

//    @SerializedName("mobile")
    private
    String mobile;

//    @SerializedName("email")
    private
    String email;

    public User(String email, String mobile) {
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return id;
    }

    public void setName(String id) {
        id = id;
    }


}
