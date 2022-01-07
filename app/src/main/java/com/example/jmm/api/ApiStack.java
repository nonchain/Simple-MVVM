package com.example.jmm.api;

import java.io.Serializable;

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

    public static ApiStack getInstance() // Create new Object from ApiStack using function
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
