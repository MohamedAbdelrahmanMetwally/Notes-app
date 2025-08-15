package com.example.notesapp.Main.util;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.Main.ui.ShowFragmentDirections;
import com.example.notesapp.Main.viewmodel.NotesViewModel;
import com.example.notesapp.R;
import com.example.notesapp.core.database.Note;

import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Note> list;
    Context context;
    NotesViewModel notesViewModel;
    public Adapter(List<Note> list, Context context, NotesViewModel notesViewModel) {
        this.list = list;
        this.context = context;
        this.notesViewModel = notesViewModel;
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
        holder.tvDate.setText(String.valueOf(list.get(position).getTimestamp()));
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvDescription.setText(list.get(position).getDescription());
        int pos = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = list.get(pos);
                boolean isUpdate = true;
                NavDirections action =
                        ShowFragmentDirections
                                .actionNavGraphToNavigationAddOrUpdate(note, isUpdate);
                Navigation.findNavController(view).navigate(action);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(context).setTitle("Delete").setMessage("Are you sure?").setPositiveButton("Yes", (dialogInterface, i) -> {
                    notesViewModel.delete(list.get(pos));
                }).setNegativeButton("No", (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                }).show();
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvTitle, tvDescription;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvtitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            cardView = itemView.findViewById(R.id.cv);
        }
    }
    public void update(List<Note> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}