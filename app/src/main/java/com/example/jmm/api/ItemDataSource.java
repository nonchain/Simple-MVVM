package com.example.jmm.api;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.jmm.model.ApiStackResponse;
import com.example.jmm.model.ItemsList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
    PageKeyedDataSource<variable Type, DataList Type>

    variable Type ==> means Sending a String to server or an Integer or ...
    DataList Type ==> means Type of my data that get from server

    variable Type == PAGE number : Integer
    DataList Type == ItemsList

 */
public class ItemDataSource extends PageKeyedDataSource<Integer, ItemsList> {

    public static String SITE_NAME = "stackoverflow";
    public static int PAGE = 1;
    public static int PAGE_SIZE = 20;
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, ItemsList> loadCallback) {
        ApiStack.getInstance().getApiStack().getApiStackResponse(loadParams.key, PAGE_SIZE, SITE_NAME).enqueue(new Callback<ApiStackResponse>() {
            @Override
            public void onResponse(Call<ApiStackResponse> call, Response<ApiStackResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body() != null)
                    {
                        Integer key = response.body().has_more ? loadParams.key + 1 : null;

                        loadCallback.onResult(response.body().items, key);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, ItemsList> loadCallback) {
        // What is the previous page
        ApiStack.getInstance().getApiStack().getApiStackResponse(loadParams.key, PAGE_SIZE, SITE_NAME).enqueue(new Callback<ApiStackResponse>() {
            @Override
            public void onResponse(Call<ApiStackResponse> call, Response<ApiStackResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body() != null)
                    {
                        Integer key = loadParams.key;
                        if(key>1)
                        {
                            key -= 1;
                        }

                        loadCallback.onResult(response.body().items, key);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> loadInitialParams, @NonNull LoadInitialCallback<Integer, ItemsList> loadInitialCallback) {
        // Do we sent a request to the server ? yes or no
        // Is there any response ? yes or no
        // Where we are now on response ? page 1, 2, ...
        // Run loadAfter

        ApiStack.getInstance().getApiStack().getApiStackResponse(PAGE, PAGE_SIZE, SITE_NAME).enqueue(new Callback<ApiStackResponse>() {
            @Override
            public void onResponse(Call<ApiStackResponse> call, Response<ApiStackResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body() != null)
                    {
                        loadInitialCallback.onResult(response.body().items, null, PAGE+1);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse> call, Throwable t) {

            }
        });
    }
}
