package com.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.MyHolder> {

    Context context;
    ArrayList<CustomUserList> arrayList;

    public UserRecyclerAdapter(Context context, ArrayList<CustomUserList> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_sqlite_recycler,parent,false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,email,contact;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.custom_lst_name);
            email = itemView.findViewById(R.id.custom_lst_email);
            contact = itemView.findViewById(R.id.custom_lst_contact);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getFirstName()+" "+arrayList.get(position).getLastName()+" ("+arrayList.get(position).getGender()+")");
        holder.email.setText(arrayList.get(position).getEmail());
        holder.contact.setText(arrayList.get(position).getContact());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
