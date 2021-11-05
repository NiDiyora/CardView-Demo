package com.example.cardviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;

public class CirculerShapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuler_shap);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}