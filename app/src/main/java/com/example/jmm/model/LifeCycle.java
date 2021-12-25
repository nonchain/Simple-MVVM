package com.example.jmm.model;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifeCycle implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public static void mOnCreate()
    {
        Log.d("ON_CREATE", "ON_CREATE_MVVM");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public static void mOnDestroy()
    {
        Log.d("ON_CREATE", "ON_DESTROY_MVVM");
    }
}
