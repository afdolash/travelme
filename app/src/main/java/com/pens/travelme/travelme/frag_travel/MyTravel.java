package com.pens.travelme.travelme.frag_travel;

import com.pens.travelme.travelme.modal.Kamar;
import com.pens.travelme.travelme.modal.Menu;
import com.pens.travelme.travelme.modal.Wisata;

/**
 * Created by afdol on 4/10/2018.
 */

public class MyTravel {
    private String date, title;
    private Wisata travel;
    private Kamar kamar;
    private Menu menu;

    public MyTravel(String date, String title, Wisata travel, Kamar kamar, Menu menu) {
        this.date = date;
        this.title = title;
        this.travel = travel;
        this.kamar = kamar;
        this.menu = menu;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Wisata getTravel() {
        return travel;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public Menu getMenu() {
        return menu;
    }
}
