package com.mad2019.cse18_039.kpmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setTitle("SETTINGS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
