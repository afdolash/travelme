package com.pens.travelme.travelme.modal;

public class Menu {
    private int id_menu;
    private int id_kuliner;
    private String nama;
    private Double harga;
    private String foto;
    private String deskripsi;
    private Kamar kamar;

    public Menu() {
    }

    public Menu(int id_menu, int id_kuliner, String nama, Double harga, String foto, String deskripsi) {
        this.id_menu = id_menu;
        this.id_kuliner = id_kuliner;
        this.nama = nama;
        this.harga = harga;
        this.foto = foto;
        this.deskripsi = deskripsi;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getId_kuliner() {
        return id_kuliner;
    }

    public void setId_kuliner(int id_kuliner) {
        this.id_kuliner = id_kuliner;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
