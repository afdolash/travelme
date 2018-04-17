package com.pens.travelme.travelme.frag_travel;

/**
 * Created by afdol on 4/10/2018.
 */

public class MyTravel {
    private String date, title;
    private Travel travel;
    private Hotel hotel;
    private Restaurant restaurant;

    public MyTravel(String date, String title, Travel travel, Hotel hotel, Restaurant restaurant) {
        this.date = date;
        this.title = title;
        this.travel = travel;
        this.hotel = hotel;
        this.restaurant = restaurant;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Travel getTravel() {
        return travel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
