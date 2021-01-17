package com.example.finalproject_diploma.webServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static final String BASE_URL="http://retail.amit-learning.com/api/";
    private static Retrofit retrofit;
    public  static Retrofit getRetrofit(){
        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                                   .baseUrl(BASE_URL)
                                   .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}
