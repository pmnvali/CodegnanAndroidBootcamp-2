package com.example.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context ct;
    int myImages[];
    String myVersionNames[];
    public MyAdapter(MainActivity mainActivity, int[] images, String[] version_names) {
        ct = mainActivity;
        myImages = images;
        myVersionNames = version_names;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(myImages[position]);
        holder.tv.setText(myVersionNames[position]);


    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.image);
            tv = itemView.findViewById(R.id.name);

        }
    }
}
