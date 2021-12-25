package com.example.jmm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ViewPagerModel {
    String name, link_img;

    public ViewPagerModel(){}

    public ViewPagerModel(String name, String link_img) {
        this.name = name;
        this.link_img = link_img;
    }

    @BindingAdapter("Link_Img")
    public static void loadImageView(ImageView img, String link_img)
    {
        Picasso.get().load(link_img).into(img);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }
}
