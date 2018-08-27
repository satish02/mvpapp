package com.satish.mvpapp.request;

import com.satish.mvpapp.model.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/*
 * Created by Satish on 8/27/2018
 */
public interface ApiInterface {

    @GET("json")
    Call<CategoryResponse> getCategory();
}
