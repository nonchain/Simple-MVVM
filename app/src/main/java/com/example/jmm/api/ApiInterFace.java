package com.example.jmm.api;

import com.example.jmm.model.MoviesList;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiInterFace {

    @GET("get_movies.php")
    Single<List<MoviesList>> getMovies();
}
