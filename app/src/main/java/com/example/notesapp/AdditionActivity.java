package com.example.notesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notesapp.core.database.Note;

public class AdditionActivity extends AppCompatActivity {
    private EditText etTitle, etDescription;
    private Button btnSubmit, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addition);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        handleActions();
    }
    private void initViews() {
        etTitle = findViewById(R.id.etTitleAdd);
        etDescription = findViewById(R.id.etDescriptionAdd);
        btnSubmit = findViewById(R.id.btnSubmitAdd);
        btnBack = findViewById(R.id.btnBackAdd);
    }
    private void handleActions() {
        btnSubmit.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String description = etDescription.getText().toString().trim();
            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Note newNote = new Note(title, description);
            NoteDatabase.getInstance(getApplicationContext()).noteDao().insert(newNote);
            Toast.makeText(this, "Note added successfully", Toast.LENGTH_SHORT).show();
            finish();
        });
        btnBack.setOnClickListener(v -> finish());
    }
}