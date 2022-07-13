package sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Requests {
    private String Sur_name;
    private String Sur_id;
    private String Sur_price;
    private String Sur_description;
    private String User_id;
    private String Sur_Needed_time;
    private int dep_id;

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public Requests(String Sur_name, String Sur_id, String Sur_price, String Sur_description, String User_id, String Sur_Needed_time, int dep_id) {
        this.Sur_name = Sur_name;
        this.Sur_id = Sur_id;
        this.Sur_price = Sur_price;
        this.Sur_description = Sur_description;
        this.User_id = User_id;
        this.Sur_Needed_time = Sur_Needed_time;
        this.dep_id = dep_id;
    }

    public Requests() {
    }

    public String getSur_name() {
        return Sur_name;
    }

    public void setSur_name(String Sur_name) {
        this.Sur_name = Sur_name;
    }

    public String getSur_id() {
        return Sur_id;
    }

    public void setSur_id(String Sur_id) {
        this.Sur_id = Sur_id;
    }

    public String getSur_price() {
        return Sur_price;
    }

    public void setSur_price(String Sur_price) {
        this.Sur_price = Sur_price;
    }

    public String getSur_description() {
        return Sur_description;
    }

    public void setSur_description(String Sur_description) {
        this.Sur_description = Sur_description;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String User_id) {
        this.User_id = User_id;
    }

    public String getSur_Needed_time() {
        return Sur_Needed_time;
    }

    public void setSur_Needed_time(String Sur_Needed_time) {
        this.Sur_Needed_time = Sur_Needed_time;
    }

}


