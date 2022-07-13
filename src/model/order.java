package model;

public class order {
    private String servicename;
    private String useremail;
    private int price;

    public order(String servicename, String useremail, int price, int userid, String buydate) {
        this.servicename = servicename;
        this.useremail = useremail;
        this.price = price;
        this.userid = userid;
        this.buydate = buydate;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public order() {

    }

    private int userid;
    private String buydate;

}
