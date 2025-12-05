package com.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,offer,desc;
        public MyHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.cust_recycler_image);
            title = itemView.findViewById(R.id.cust_recycler_title);
            offer = itemView.findViewById(R.id.cust_recycler_offer);
            desc = itemView.findViewById(R.id.cust_recycler_desc);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(titleArray[position]);
        holder.offer.setText(offerArray[position]);
        holder.desc.setText(decArray[position]);

        Glide.with(context).asGif().load(imageArray[position]).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return titleArray.length;
    }



}
