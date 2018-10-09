package com.example.bcs.fundmytra;

public class UpdateModel {
    private String Id;
    private String name;
    private String email;
    private String mobile;

    public UpdateModel(String id, String name, String email, String mobile) {
        Id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
