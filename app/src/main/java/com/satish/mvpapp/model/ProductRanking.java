package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

/*
 * Created by Satish on 8/27/2018
 */
public class ProductRanking {
    @SerializedName("id")
    private int id;

    @SerializedName("shares")
    private int shares;

    @SerializedName("order_count")
    private int orderCount;

    @SerializedName("view_count")
    private int viewCount;

    public int getId() {
        return id;
    }

    public int getShares() {
        return shares;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public int getViewCount() {
        return viewCount;
    }
}
