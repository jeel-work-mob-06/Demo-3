package com.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerDemoAdapter.MyHolder> {

    Context context;
    String[] imageArray;
    String[] titleArray;
    String[] offerArray;
    String[] decArray;
    public RecyclerDemoAdapter(Context context, String[] imageArray, String[] titleArray, String[] offerArray, String[] decArray) {

        this.context = context;
        this.imageArray = imageArray;
        this.titleArray = titleArray;
        this.offerArray = offerArray;
        this.decArray = decArray;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return null;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(@NonNull View itemView) {
            super(itemView);


        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
