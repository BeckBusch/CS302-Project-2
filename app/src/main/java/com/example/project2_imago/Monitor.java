package com.example.project2_imago;

import java.util.Map;

public class Monitor {

    private String name;
    private boolean isBestSelling;
    private int viewCount;

    private int screenSize;
    private String aspectRatio;
    private double price;
    private String brand;
    private Map<Integer,String> Images; //String holds names of images e.g. Samsung_LU28R550U_img1, map to keep it nice and tidy

    public Monitor(String name, int screenSize, String aspectRatio, double price, String brand, Map<Integer, String> images) {
        this.name = name;
        this.screenSize = screenSize;
        this.aspectRatio = aspectRatio;
        this.price = price;
        this.brand = brand;
        this.isBestSelling = false;
        this.viewCount = 0;

        Images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBestSelling() {
        return isBestSelling;
    }

    public void setBestSelling(boolean bestSelling) {
        isBestSelling = bestSelling;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
