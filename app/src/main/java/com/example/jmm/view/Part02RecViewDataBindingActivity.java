package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jmm.R;
import com.example.jmm.adapter.AdapterRecView;
import com.example.jmm.databinding.ActivityPart02RecViewDataBindingBinding;
import com.example.jmm.model.UsersInfo;

import java.util.ArrayList;
import java.util.List;

public class Part02RecViewDataBindingActivity extends AppCompatActivity {

    ActivityPart02RecViewDataBindingBinding binding;
    RecyclerView recyclerView_user;
    List<UsersInfo> usersInfo;
    AdapterRecView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_part02_rec_view_data_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_part02_rec_view_data_binding);

        usersInfo = new ArrayList<>();
        setUsersInfo();

        recyclerView_user = binding.recViewPart2;
        recyclerView_user.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        ));
        adapter = new AdapterRecView(this, usersInfo);
        recyclerView_user.setAdapter(adapter);

    }

    public void setUsersInfo()
    {
        usersInfo.add(new UsersInfo("علی", "ali@gmail.com","https://www.uselooper.com/assets/images/avatars/uifaces1.jpg"));
        usersInfo.add(new UsersInfo("ندا", "neda81@gmail.com","https://www.astutemyndz.com/wp-content/uploads/2019/03/4.jpg"));
        usersInfo.add(new UsersInfo("Fighter", "amir.fighter@gmail.com","https://wallpaperaccess.com/full/2213424.jpg"));

    }
}