package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.jmm.R;
import com.example.jmm.databinding.ActivityPart07ViewPagerBinding;

public class Part07ViewPagerActivity extends AppCompatActivity {

    ActivityPart07ViewPagerBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_part07_view_pager);
        binding = DataBindingUtil.setContentView(Part07ViewPagerActivity.this, R.layout.activity_part07_view_pager);
        binding.setViewPagerData(this);
        binding.setFragmentManager(getSupportFragmentManager());
    }
}