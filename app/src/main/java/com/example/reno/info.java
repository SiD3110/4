package com.example.reno;

public class info {

    String img;
    String date;



    public info() {
    }

    public info(String img,String date) {
        this.img = img;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
