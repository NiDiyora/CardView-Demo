package com.example.cardviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarActivity extends AppCompatActivity {

    Button btnsnack;
    private CoordinatorLayout coordinatorLayout;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        btnsnack = findViewById(R.id.btnsnackbar);
        coordinatorLayout = findViewById(R.id.corrdinate);

        btnsnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG)
                        .setAction("SEND", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(SnackBarActivity.this,MainActivity.class));
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout,"Message is Restore",Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.show();
            }
        });

    }

}