package com.demo3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomeSecoundAdapter extends BaseAdapter {
    Context context;
    ArrayList<CustomList> arrayList;
    public CustomeSecoundAdapter(Context context, ArrayList<CustomList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.custom_list,null);
        TextView title = view.findViewById(R.id.cust_lst_title);
        TextView offer = view.findViewById(R.id.cust_lst_offer);
        TextView desc = view.findViewById(R.id.cust_lst_desc);
        ImageView image = view.findViewById(R.id.cust_image);



        title.setText(arrayList.get(position).getTitle());
        offer.setText(arrayList.get(position).getOffer());
        desc.setText(arrayList.get(position).getDec());
        Glide.with(context).asGif().load(arrayList.get(position).getImage()).placeholder(R.mipmap.ic_launcher).into(image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Image Clicked"+position, Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
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
        return view;
    }
}
