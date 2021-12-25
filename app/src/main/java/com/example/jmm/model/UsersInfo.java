package com.example.jmm.model;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersInfo {
    String name, email, link_img;

    public UsersInfo() {
    }

    public UsersInfo(String name, String email, String link_img) {
        this.name = name;
        this.email = email;
        this.link_img = link_img;
    }

    @BindingAdapter({"android:CircleImageView"})
    public static void LoadCircleImageView(CircleImageView civ, String link)
    {
        Picasso.get().load(link).into(civ);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
