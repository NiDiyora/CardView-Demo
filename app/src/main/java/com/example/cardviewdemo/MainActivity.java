package com.example.cardviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton materialButton,reciclebtn,btnsnack;
    ProgressBar progressBar;
    TextView textView;
    CoordinatorLayout coordinatorLayout;
    String json;
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialButton = findViewById(R.id.mbtncirculer);
        reciclebtn = findViewById(R.id.recyclerview);
        btnsnack = findViewById(R.id.snack);
        coordinatorLayout = new CoordinatorLayout(this);
        materialButton.setOnClickListener(this);
        reciclebtn.setOnClickListener(this);
        btnsnack.setOnClickListener(this);
        textView = findViewById(R.id.jsondata);
        progressBar = new ProgressBar(this);
        progressBar.setVisibility(View.VISIBLE);
        int[] img = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};
        String[] name = {"num of image","num of image","num of image","num of image","num of image","num of image","num of image","num of image","num of image",};

        ArrayList<ModalClass> modalClasses = new ArrayList<>();
        for(int i=0;i<img.length;i++)
        {
            ModalClass modalClass = new ModalClass(img[i],name[i]);
            modalClasses.add(modalClass);
            gson = new Gson();
            json = gson.toJson(modalClasses);
            textView.setText(json);
            }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.mbtncirculer:
                Intent intent = new Intent(this,CirculerShapActivity.class);
                startActivity(intent);
                break;
            case R.id.recyclerview:
                Intent intent1 = new Intent(this,RecycleviewLoadMore.class);
                startActivity(intent1);
                break;
            case R.id.snack:
                Intent intent2 = new Intent(this,SnackBarActivity.class);
                startActivity(intent2);
        }

    }
}