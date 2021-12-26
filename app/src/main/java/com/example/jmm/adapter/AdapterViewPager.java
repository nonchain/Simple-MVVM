package com.example.jmm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.jmm.R;
import com.example.jmm.databinding.ItemViewPagerBinding;
import com.example.jmm.model.ViewPagerList;

import java.util.List;

public class AdapterViewPager extends PagerAdapter {

    List<ViewPagerList> data;

    public AdapterViewPager(List<ViewPagerList> data) {
        this.data = data;
    }

    @NonNull
    @Override
    // Connect to xml file
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        ItemViewPagerBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_view_pager,container, false);

        binding.setSliderData(data.get(position));
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  data.get(position).getName();
    }
}
