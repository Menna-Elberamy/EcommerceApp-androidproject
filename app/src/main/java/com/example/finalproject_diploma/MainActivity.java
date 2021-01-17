package com.example.finalproject_diploma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        NavController navController = Navigation.findNavController(MainActivity.this , R.id.nav_host_fragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.home_nav);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }
}