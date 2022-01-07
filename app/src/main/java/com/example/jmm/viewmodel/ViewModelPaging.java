package com.example.jmm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedList;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.jmm.api.ItemDataSource;
import com.example.jmm.api.ItemDataSourceFactory;
import com.example.jmm.model.ItemsList;

public class ViewModelPaging extends ViewModel {

    public LiveData<PagedList<ItemsList>> items;
    LiveData<PageKeyedDataSource<Integer, ItemsList>> sourceLiveData;

    public ViewModelPaging ()
    {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        sourceLiveData = itemDataSourceFactory.getSourceMutableLiveData();

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();

        items = new LivePagedListBuilder(itemDataSourceFactory, config).build();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
