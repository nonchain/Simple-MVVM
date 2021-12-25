package com.example.jmm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jmm.databinding.ActivityDataBindingBinding;
import com.example.jmm.model.UsersInfo;

public class Part01DataBindingActivity extends AppCompatActivity {

    ActivityDataBindingBinding binding;
    UsersInfo usersInfo;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        usersInfo = new UsersInfo();

        usersInfo.setName("Ali");
        usersInfo.setEmail("ali@gmail.com");
        binding.setUserInfo(usersInfo);

    }
}