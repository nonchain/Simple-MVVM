package com.example.jmm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jmm.api.ApiClient;
import com.example.jmm.model.MoviesList;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ViewModelMovies extends ViewModel {

    MutableLiveData<List<MoviesList>> mutableLiveData_Movies = new MutableLiveData<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiClient apiClient;

    public MutableLiveData<List<MoviesList>> GET_MOVIES()
    {
        apiClient = new ApiClient();
        compositeDisposable.add(apiClient.GET_LIST_MOVIES()
                .subscribeOn(Schedulers.newThread()) // For Create new Thread for UI
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<List<MoviesList>>() {
            @Override
            public void onSuccess(@NonNull List<MoviesList> moviesLists) {
                mutableLiveData_Movies.setValue(moviesLists);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("ERROR", "LIVE DATA ERROR : "+e.getMessage());
            }
        }));

        return mutableLiveData_Movies;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
