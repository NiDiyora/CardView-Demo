package com.example.cardviewdemo;

import android.content.Context;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LoadMoreAdapter extends RecyclerView.Adapter<LoadMoreAdapter.MyViewHolder> {


ArrayList<ModalClass> modalClasses;
Context context;

    public LoadMoreAdapter(ArrayList<ModalClass> modalClasses, Context context) {
        this.modalClasses = modalClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(modalClasses.get(position).getImage());
        holder.titletext.setText(modalClasses.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return modalClasses.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titletext;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.image);
            titletext = itemView.findViewById(R.id.title);
        }
    }
}
