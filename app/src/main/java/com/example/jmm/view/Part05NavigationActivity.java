package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.jmm.R;

public class Part05NavigationActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part05_navigation);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        navController = Navigation.findNavController(Part05NavigationActivity.this, R.id.fragment);
        NavigationUI.setupActionBarWithNavController(Part05NavigationActivity.this, navController); // Then set onSupportNavigateUp
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}