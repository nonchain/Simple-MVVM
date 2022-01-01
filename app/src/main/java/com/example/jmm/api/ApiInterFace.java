package com.example.jmm.api;

import com.example.jmm.model.ApiStackResponse;
import com.example.jmm.model.MoviesList;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {

    @GET("get_movies.php")
    Single<List<MoviesList>> getMovies();

    @GET("answers")
    Call<ApiStackResponse> getApiStackResponse(
            @Query("page") int page,
            @Query("pagesize") int pageSize,
            @Query("site") String site
    );
}
