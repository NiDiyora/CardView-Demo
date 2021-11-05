package com.example.cardviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RecycleviewLoadMore extends AppCompatActivity {

    RecyclerView recyclerView;
    LoadMoreAdapter loadMoreAdapter;
    LoadMoreAdapter loadMoreAdapter1;
    LinearLayoutManager linearLayoutManager;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    ArrayList<ModalClass> datalist;
    SwipeRefreshLayout swipeRefreshLayout;
    int count=0;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_load_more);
        recyclerView = findViewById(R.id.recycledata);
        progressBar = findViewById(R.id.simpleProgressBar1);

        linearLayoutManager = new LinearLayoutManager(this);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
         datalist = new ArrayList<>();
        datalist.add(new ModalClass(R.drawable.img1, "WallPaper Hd Live"));
        datalist.add(new ModalClass(R.drawable.img2, "Pink Wallpaper"));
        datalist.add(new ModalClass(R.drawable.img3, "Long Tree Wallpaper"));
        datalist.add(new ModalClass(R.drawable.img4, "Best Nature Filling WallPaper"));
        datalist.add(new ModalClass(R.drawable.img5, "peacock WallPaper Hd"));
        datalist.add(new ModalClass(R.drawable.img6, "Teddy WallPaper Hd"));
        datalist.add(new ModalClass(R.drawable.img7, "Flowers WallPaper Hd Live"));
        datalist.add(new ModalClass(R.drawable.img8, "Night Light WallPaper Hd"));
        datalist.add(new ModalClass(R.drawable.img9, "Night purple WallPaper Hd Live"));
        datalist.add(new ModalClass(R.drawable.img10, "Best Wallpaper"));
        datalist.add(new ModalClass(R.drawable.img1, "WallPaper Hd Live"));
        datalist.add(new ModalClass(R.drawable.img2, "Pink Wallpaper"));
        datalist.add(new ModalClass(R.drawable.img3, "Long Tree Wallpaper"));
        loadMoreAdapter = new LoadMoreAdapter(datalist,getApplicationContext());
        loadMoreAdapter1 = new LoadMoreAdapter(datalist,getApplicationContext());
        recyclerView.setAdapter(loadMoreAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                      //  Toast.makeText(RecycleviewLoadMore.this, String.valueOf(visibleItemCount+pastVisiblesItems), Toast.LENGTH_LONG).show();
                        Log.d("totalitem","total Item is"+totalItemCount);
                        if (visibleItemCount + pastVisiblesItems == totalItemCount) {
                            loading = false;

                            progressBar.setVisibility(View.VISIBLE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    datalist.add(new ModalClass(R.drawable.img1, "WallPaper Hd Live"));
                                    datalist.add(new ModalClass(R.drawable.img2, "Pink Wallpaper"));
                                    datalist.add(new ModalClass(R.drawable.img3, "Long Tree Wallpaper"));
                                    datalist.add(new ModalClass(R.drawable.img6, "Teddy WallPaper Hd"));
                                    datalist.add(new ModalClass(R.drawable.img7, "Flowers WallPaper Hd Live"));
                                    datalist.add(new ModalClass(R.drawable.img8, "Night Light WallPaper Hd"));
                                    datalist.add(new ModalClass(R.drawable.img9, "Night purple WallPaper Hd Live"));
                                    datalist.add(new ModalClass(R.drawable.img10, "Best Wallpaper"));
                                    datalist.add(new ModalClass(R.drawable.img1, "WallPaper Hd Live"));
                                    datalist.add(new ModalClass(R.drawable.img2, "Pink Wallpaper"));
                                    datalist.add(new ModalClass(R.drawable.img3, "Long Tree Wallpaper"));
                                    loadMoreAdapter.notifyDataSetChanged();
                                    loadMoreAdapter1.notifyDataSetChanged();
                                    loading = true;
                                }
                            },2000);

                          //  Toast.makeText(RecycleviewLoadMore.this, String.valueOf(visibleItemCount+pastVisiblesItems), Toast.LENGTH_LONG).show();

                        }
                    }
                }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchdata();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void fetchdata() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Collections.shuffle(datalist,new Random(System.currentTimeMillis()));
                recyclerView.setAdapter(loadMoreAdapter1);
                loadMoreAdapter1.notifyDataSetChanged();
                loadMoreAdapter.notifyDataSetChanged();
            }
        },2000);

    }

}