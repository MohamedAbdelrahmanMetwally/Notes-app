package com.example.notesapp;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.core.database.Note;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Note> list;
    Context context;
    public Adapter(List<Note> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(list.get(position).getId()));
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvDescription.setText(list.get(position).getDescription());
        int pos = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateOrDelete.class);
                intent.putExtra("id", list.get(pos).getId());
                intent.putExtra("title", list.get(pos).getTitle());
                intent.putExtra("description", list.get(pos).getDescription());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTitle, tvDescription;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvtitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            cardView = itemView.findViewById(R.id.cv);
        }
    }
}