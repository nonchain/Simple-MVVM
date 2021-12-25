package com.example.jmm.api;

import com.example.jmm.model.MoviesList;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    String BaseUrl = "http://192.168.1.147/mvvm/";
    ApiInterFace request;
    Retrofit retrofit;

    public ApiClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request = retrofit.create(ApiInterFace.class);
    }

    public Single<List<MoviesList>> GET_LIST_MOVIES()
    {
        return request.getMovies();
    }
}
