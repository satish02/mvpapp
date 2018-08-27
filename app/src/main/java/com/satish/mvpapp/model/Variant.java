package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

/*
 * Created by Satish on 8/27/2018
 */
public class Variant {

    @SerializedName("id")
    private int id;

    @SerializedName("color")
    private String color;

    @SerializedName("size")
    private int size;

    @SerializedName("price")
    private int price;

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
