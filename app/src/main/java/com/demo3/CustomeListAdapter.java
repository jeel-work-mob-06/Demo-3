package com.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CustomeListAdapter extends BaseAdapter {
    Context context;
    String[] imageArray;
    String[] titleArray;
    String[] offerArray;
    String[] decArray;
    public CustomeListAdapter(Context context, String[] imageArray, String[] titleArray, String[] offerArray, String[] decArray) {
        this.context = context;
        this.imageArray = imageArray;
        this.titleArray = titleArray;
        this.offerArray = offerArray;
        this.decArray = decArray;
     }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
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

        title.setText(titleArray[position]);
        offer.setText(offerArray[position]);
        desc.setText(decArray[position]);

        Glide.with(context).load(imageArray[position]).placeholder(R.mipmap.ic_launcher).into(image);
        return view;
    }
}
