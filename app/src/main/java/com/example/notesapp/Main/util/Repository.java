package com.example.notesapp.Main.util;

import androidx.lifecycle.LiveData;

import com.example.notesapp.core.database.Note;
import com.example.notesapp.core.database.NoteDao;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private NoteDao noteDao;
    private LiveData<List<Note>> notes;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Repository(NoteDao noteDao) {
        this.noteDao = noteDao;
        notes = noteDao.getNotes(); // مفيش casting
    }

    public LiveData<List<Note>> getAllNotes() {
        return notes;
    }

    public void insert(Note note) {
        executor.execute(() -> noteDao.insert(note));
    }

    public void update(Note note) {
        executor.execute(() -> noteDao.update(note));
    }

    public void delete(Note note) {
        executor.execute(() -> noteDao.delete(note));
    }
}
