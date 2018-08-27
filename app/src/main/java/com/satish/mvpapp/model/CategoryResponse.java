package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class CategoryResponse {
    @SerializedName("categories")
    private ArrayList<Category> categoryArrayList;

    @SerializedName("rankings")
    private ArrayList<Ranking> rankingArrayList;

    public ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public ArrayList<Ranking> getRankingArrayList() {
        return rankingArrayList;
    }
}
