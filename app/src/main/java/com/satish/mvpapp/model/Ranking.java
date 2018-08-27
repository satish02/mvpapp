package com.satish.mvpapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class Ranking {

    @SerializedName("rankings")
    private String ranking;

    @SerializedName("products")
    private ArrayList<ProductRanking> productRankingArrayList;

    public String getRanking() {
        return ranking;
    }

    public ArrayList<ProductRanking> getProductRankingArrayList() {
        return productRankingArrayList;
    }
}
