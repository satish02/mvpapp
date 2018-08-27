package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class Product {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String productName;

    @SerializedName("date_added")
    private String dateAdded;

    @SerializedName("tax")
    private Tax tax;

    @SerializedName("variants")
    private ArrayList<Variant> variantArrayList;

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public Tax getTax() {
        return tax;
    }

    public ArrayList<Variant> getVariantArrayList() {
        return variantArrayList;
    }
}
