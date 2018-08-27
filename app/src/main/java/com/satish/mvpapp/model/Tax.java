package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

/*
 * Created by Satish on 8/27/2018
 */
public class Tax {
    @SerializedName("name")
    private String name;

    @SerializedName("tax")
    private int tax;

    public String getName() {
        return name;
    }

    public int getTax() {
        return tax;
    }
}
