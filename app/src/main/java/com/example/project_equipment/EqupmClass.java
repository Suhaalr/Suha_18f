package com.example.project_equipment;

public class EqupmClass {

    String image;
    String Titel;
    String price;
    String description;

    public String getImage() {
        return image;
    }

    public String getTitel() {
        return Titel;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public EqupmClass(String image, String Titel, String price, String description) {
        this.image = image;
        this.Titel = Titel;
        this.price = price;
        this.description = description;
    }

    public EqupmClass(){

    }

}