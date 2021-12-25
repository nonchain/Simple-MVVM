package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.jmm.R;

public class Part06MovieNavigationActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part06_movie_navigation2);

        navController = Navigation.findNavController(Part06MovieNavigationActivity.this, R.id.fragment_movie);
        NavigationUI.setupActionBarWithNavController(Part06MovieNavigationActivity.this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}