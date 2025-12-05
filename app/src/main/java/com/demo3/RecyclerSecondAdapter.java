package com.demo3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerSecondAdapter extends RecyclerView.Adapter<RecyclerSecondAdapter.MyHolder> {

    Context context;
    ArrayList<CustomList> arrayList;
    public RecyclerSecondAdapter(Context context, ArrayList<CustomList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;


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
            title = itemView.findViewById(R.id.cust_recycler_title);
            offer = itemView.findViewById(R.id.cust_recycler_offer);
            desc = itemView.findViewById(R.id.cust_recycler_desc);
            imageView = itemView.findViewById(R.id.cust_recycler_image);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.title.setText(arrayList.get(position).getTitle());
        holder.offer.setText(arrayList.get(position).getOffer());
        holder.desc.setText(arrayList.get(position).getDec());
        Glide.with(context).asGif().load(arrayList.get(position).getImage()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Image Clicked"+position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CustomDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Image",arrayList.get(position).getImage());
                bundle.putString("Title",arrayList.get(position).getTitle());
                bundle.putString("Offer",arrayList.get(position).getOffer());
                bundle.putString("Description",arrayList.get(position).getDec());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }


}
