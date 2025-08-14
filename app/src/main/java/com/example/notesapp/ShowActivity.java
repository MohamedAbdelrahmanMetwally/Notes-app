package com.example.notesapp;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.core.database.Note;
import com.example.notesapp.core.database.NoteDatabase;

import java.util.List;
public class ShowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        NoteDatabase db = NoteDatabase.getInstance(getApplicationContext());
        List<Note> notes = db.noteDao().getNotes();
        Adapter adapter=new Adapter(notes,this);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            finish();
        });
    }
}