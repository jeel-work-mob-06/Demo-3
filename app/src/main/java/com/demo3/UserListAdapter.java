package com.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {

    Context context;
    ArrayList<CustomUserList> arrayList;

    public UserListAdapter(Context context, ArrayList<CustomUserList> arrayList) {

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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_user_list,null);

        TextView name = convertView.findViewById(R.id.custom_lst_name);
        TextView email = convertView.findViewById(R.id.custom_lst_email);
        TextView contact = convertView.findViewById(R.id.custom_lst_contact);
        name.setText(arrayList.get(position).getFirstName()+" "+arrayList.get(position).getLastName()+" ("+arrayList.get(position).getGender()+")");
        email.setText(arrayList.get(position).getEmail());
        contact.setText(arrayList.get(position).getContact());
        return convertView;
    }
}
