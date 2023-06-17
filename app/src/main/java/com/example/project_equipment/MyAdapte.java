package com.example.project_equipment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapte extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<EqupmClass>list;

    public MyAdapte(Context context,List<EqupmClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reclyou_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImage()).into(holder.recimage);
        holder.namese.setText(list.get(position).getTitel());
        holder.pricdse.setText(list.get(position).getPrice());
        holder.recdesc.setText(list.get(position).getDescription());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Description_page.class);
                intent.putExtra("image",list.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Titel",list.get(holder.getAdapterPosition()).getTitel());
                intent.putExtra("price",list.get(holder.getAdapterPosition()).getPrice());
                intent.putExtra("description",list.get(holder.getAdapterPosition()).getDescription());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder  extends RecyclerView.ViewHolder{

    ImageView recimage;
    TextView namese,recdesc,pricdse;
    CardView card;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recimage = itemView.findViewById(R.id.recimage);
        namese = itemView.findViewById(R.id.namese);
        recdesc = itemView.findViewById(R.id.recdesc);
        pricdse = itemView.findViewById(R.id.pricdse);
        card = itemView.findViewById(R.id.card);


    }
}