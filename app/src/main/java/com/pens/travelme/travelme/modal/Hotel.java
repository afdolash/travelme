package com.pens.travelme.travelme.modal;

/**
 * Created by afdol on 4/10/2018.
 */

public class Hotel {
    private String title, address, price, phone;
    private int image;

    public Hotel(String title, String address, String price, String phone, int image) {
        this.title = title;
        this.address = address;
        this.price = price;
        this.phone = phone;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }
}
