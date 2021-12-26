package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.jmm.R;
import com.example.jmm.adapter.AdapterViewPager;
import com.example.jmm.databinding.ActivityPart07ViewPagerBinding;
import com.example.jmm.model.ViewPagerList;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Part07ViewPagerActivity extends AppCompatActivity {

    ActivityPart07ViewPagerBinding binding;
    static AdapterViewPager adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_part07_view_pager);
        binding = DataBindingUtil.setContentView(Part07ViewPagerActivity.this, R.layout.activity_part07_view_pager);
        binding.setViewPagerData(this);
        binding.setFragmentManager(getSupportFragmentManager());


    }

    @BindingAdapter("SET_VIEWPAGER")
    public static void setViewPagerData(ViewPager vp)
    {
        List<ViewPagerList> data = new ArrayList<>();

        data.add(new ViewPagerList("درخت", "https://cdn.mashreghnews.ir/d/2020/02/16/4/2718373.jpg"));
        data.add(new ViewPagerList("پارک", "https://app.akharinkhabar.ir/images/2020/11/28/63342d27-91bf-4e3a-9e03-6c4896a2eafd.jpeg"));

        adapter = new AdapterViewPager(data);
        vp.setAdapter(adapter);
    }

    @BindingAdapter("SET_TABLAYOUT")
    public static void setTabLayout(TabLayout tb, ViewPager vp)
    {
        tb.setupWithViewPager(vp, true);
    }
}