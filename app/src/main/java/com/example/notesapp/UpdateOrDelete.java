package com.example.notesapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
public class UpdateOrDelete extends AppCompatActivity {
    private EditText etIdUpdate, etTitleUpdate, etDescriptionUpdate;
    private NoteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etIdUpdate = findViewById(R.id.etIdUpdate);
        etTitleUpdate = findViewById(R.id.etTitleUpdate);
        etDescriptionUpdate = findViewById(R.id.etDescriptionUpdate);
        MaterialButton btnSubmitUpdate = findViewById(R.id.btnUpdateSubmit);
        MaterialButton btnDeleteSubmit = findViewById(R.id.btnDeleteSubmit);
        MaterialButton btnBackUpdate = findViewById(R.id.btnBackUpdate);
        db = NoteDatabase.getInstance(this);
        Intent intent = getIntent();
        if (intent != null) {
            etIdUpdate.setText(String.valueOf(intent.getIntExtra("id", 0)));
            etTitleUpdate.setText(intent.getStringExtra("title"));
            etDescriptionUpdate.setText(intent.getStringExtra("description"));
        }
        btnSubmitUpdate.setOnClickListener(v -> updateNote());
        btnDeleteSubmit.setOnClickListener(v -> deleteNote());
        btnBackUpdate.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
    private void updateNote() {
        String idText = etIdUpdate.getText().toString().trim();
        String title = etTitleUpdate.getText().toString().trim();
        String description = etDescriptionUpdate.getText().toString().trim();
        if (TextUtils.isEmpty(idText) || TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        Note note = new Note(title, description);
        note.setId(Integer.parseInt(idText));
        db.noteDao().update(note);
        Toast.makeText(this, "Note updated successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
    private void deleteNote() {
        String idText = etIdUpdate.getText().toString().trim();
        if (TextUtils.isEmpty(idText)) {
            Toast.makeText(this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();
            return;
        }
        Note note = new Note();
        note.setId(Integer.parseInt(idText));
        db.noteDao().delete(note);
        Toast.makeText(this, "Note deleted successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}