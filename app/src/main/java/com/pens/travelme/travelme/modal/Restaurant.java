package com.pens.travelme.travelme.modal;

import java.util.List;

/**
 * Created by afdol on 4/10/2018.
 */

public class Restaurant {
    private String title, address, phone;
    private int image;
    private List<Food> foods;
    private List<Drink> drinks;

    public Restaurant(String title, String address, String phone, int image, List<Food> foods, List<Drink> drinks) {
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.foods = foods;
        this.drinks = drinks;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }


    public static class Food {
        private String title, price;
        private int image;

        public Food(String title, String price, int image) {
            this.title = title;
            this.price = price;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public String getPrice() {
            return price;
        }

        public int getImage() {
            return image;
        }
    }


    public static class Drink {
        private String title, price;
        private int image;

        public Drink(String title, String price, int image) {
            this.title = title;
            this.price = price;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public String getPrice() {
            return price;
        }

        public int getImage() {
            return image;
        }
    }
}
