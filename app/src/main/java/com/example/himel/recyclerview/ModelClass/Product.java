package com.example.himel.recyclerview.ModelClass;

import java.io.Serializable;

/**
 * Created by HIMEL on 2/21/2018.
 */

public class Product implements Serializable {

   // `pid`, `name`, `qty`, `price`, `image_url`

    public int pid;
    public String name;
    public int qty;
    public double price;
    public String image_url;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
