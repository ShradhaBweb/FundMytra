package com.example.bcs.fundmytra;

public class DataModel {


    private int prdouct;
    private String name;
    private String searched_on;
    private String time_date;

    public int getPrdouct() {
        return prdouct;
    }

    public void setPrdouct(int prdouct) {
        this.prdouct = prdouct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearched_on() {
        return searched_on;
    }

    public void setSearched_on(String searched_on) {
        this.searched_on = searched_on;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }

    // Constructor that is used to create an instance of the DataModel object
    public DataModel(int product, String name, String searched_on,String time_date) {

        this.prdouct = product;
        this.name = name;
        this.searched_on = searched_on;
        this.time_date=time_date;
    }


}
