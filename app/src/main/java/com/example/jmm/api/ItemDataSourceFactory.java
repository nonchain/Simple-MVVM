package com.example.jmm.api;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.jmm.model.ItemsList;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ItemsList>> sourceMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<PageKeyedDataSource<Integer, ItemsList>> getSourceMutableLiveData() {
        return sourceMutableLiveData;
    }


    @NonNull
    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        sourceMutableLiveData.postValue(itemDataSource);

        return itemDataSource;
    }
}
