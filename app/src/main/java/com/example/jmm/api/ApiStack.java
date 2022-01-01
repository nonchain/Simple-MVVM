package com.example.jmm.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiStack {

    String baseUrl = "https://api.stackexchange.com/2.3/";
    static ApiStack apiStack;
    Retrofit retrofit;

    public ApiStack()
    {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl).build();

    }

    public static ApiStack getInstance()
    {
        if(apiStack == null) {
            apiStack = new ApiStack();
        }
        return apiStack;
    }

    public ApiInterFace getApiStack()
    {
        return retrofit.create(ApiInterFace.class);
    }
}
