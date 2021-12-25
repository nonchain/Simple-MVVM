package com.example.jmm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class DetailsMoviesList {
    String name, link_img, description, gnere;

    public DetailsMoviesList(String name, String link_img, String description, String gnere) {
        this.name = name;
        this.link_img = link_img;
        this.description = description;
        this.gnere = gnere;
    }

    @BindingAdapter({"android:ImageView"})
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
