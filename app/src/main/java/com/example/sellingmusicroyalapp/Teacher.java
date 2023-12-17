package com.example.sellingmusicroyalapp;

public class Teacher {
    int image;
    String Name;
    String Price;

    public Teacher(int image, String name, String price) {
        this.image = image;
        Name = name;
        Price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
