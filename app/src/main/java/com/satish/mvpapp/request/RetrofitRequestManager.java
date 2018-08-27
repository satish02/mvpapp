package com.satish.mvpapp.request;

import com.satish.mvpapp.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Created by Satish on 8/27/2018
 */
public class RetrofitRequestManager {
    private static Retrofit requestRetrofit = null;

    public static Retrofit getClient(){
        if(requestRetrofit == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            // add your other interceptors …
            httpClient.readTimeout(90, TimeUnit.SECONDS);
            httpClient.connectTimeout(90, TimeUnit.SECONDS);
            // add logging as last interceptor
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            requestRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(Constants.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            ;

        }
        return requestRetrofit;
    }
}
