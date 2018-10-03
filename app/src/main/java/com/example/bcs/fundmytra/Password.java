package com.example.bcs.fundmytra;

public class Password {
    //    private String email;
    public String password;
    public String id;

    public Password() {
    }

    public Password(String id, String password) {
        this.id = id;
        this.password = password;
        // this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getEmail() {
//        return email;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getMobile() {
        return password;
    }

    public void setMobile(String password) {
        this.password = password;
    }


}