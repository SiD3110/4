package com.example.reno;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class infoadapter extends RecyclerView.Adapter<infoadapter.MyViewHolder> {

    Context context;
    ArrayList<info> infos;
    public infoadapter(Context c,ArrayList<info> i)
    {
        context=c;
        infos=i;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.inflatecompany,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        info currentinfo=infos.get(i);
        Picasso.with(context).load(currentinfo.getImg()).into(myViewHolder.img);
        myViewHolder.date.setText(infos.get(i).getDate());

    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img ;
        TextView date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.ttview);
            img=(ImageView)itemView.findViewById(R.id.imageView1234);
        }
    }
}
