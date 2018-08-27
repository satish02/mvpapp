package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class Category {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String categoryName;

    @SerializedName("products")
    private ArrayList<Product> productArrayList;

    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
}
