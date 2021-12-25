package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jmm.R;
import com.example.jmm.model.LifeCycle;

public class Part03LifeCycleActivity extends AppCompatActivity {

    LifeCycle lifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part03_life_cycle);

        lifeCycle = new LifeCycle();
        lifeCycle.mOnCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifeCycle.mOnDestroy();
    }
}