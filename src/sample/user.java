package sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class user {
    String Id,money;
    String Fname,Lname,Email,DB,Sex,PhoneNum;
    String image;

    public user(String Id, String Fname, String Lname, String Email, String PhoneNum, String DB, String Sex, String money) {
        this.Id = Id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.PhoneNum = PhoneNum;
        this.DB = DB;
        this.Sex = Sex;
        this.money = money;
    }

    public user() {
    }

    public String getId() {
        return Id;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public String getDB() {
        return DB;
    }

    public String getSex() {
        return Sex;
    }

    public String getMoney() {
        return money;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setMoney(String money) {
        this.money = money;
    }

}

