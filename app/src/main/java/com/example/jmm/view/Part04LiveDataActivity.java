package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jmm.R;
import com.example.jmm.databinding.ActivityPart04LiveDataBinding;
import com.example.jmm.viewmodel.SimpleLiveData;

public class Part04LiveDataActivity extends AppCompatActivity {

    ActivityPart04LiveDataBinding binding;
    SimpleLiveData viewModel;
    MutableLiveData<String> SHOW_USER_ID;
    Button btn_userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_part04_live_data);

        btn_userId = binding.btnClick;
        viewModel = new ViewModelProvider(this).get(SimpleLiveData.class);
        binding.setSimpleViewModel(viewModel);

        SHOW_USER_ID = viewModel.getUSER_ID();
        SHOW_USER_ID.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String USER_RANDOM_ID) {
                btn_userId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Part04LiveDataActivity.this, USER_RANDOM_ID, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}