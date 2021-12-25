package com.example.jmm.viewmodel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class SimpleLiveData extends ViewModel {

    MutableLiveData<String> USER_ID;

    public MutableLiveData<String> getUSER_ID()
    {
        if (USER_ID==null)
        {
            USER_ID = new MutableLiveData<>();
            getRandom_USER_ID();
        }
        return USER_ID;
    }

    public MutableLiveData<String> getRandom_USER_ID()
    {
        Random random_id = new Random();

        USER_ID.setValue("USER ID : "+random_id.nextInt(2021+1400));
        return USER_ID;
    }

    public void OnClick(View vv)
    {
        getRandom_USER_ID();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
