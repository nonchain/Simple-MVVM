package com.example.jmm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class MoviesList {
        String id, name, link_img, description, gnere;

    public MoviesList() {
    }

    @BindingAdapter({"android:ImageView"})
    public static void loadImageView(ImageView img, String link_img)
    {
        Picasso.get().load(link_img).into(img);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGnere() {
        return gnere;
    }

    public void setGnere(String gnere) {
        this.gnere = gnere;
    }
}
