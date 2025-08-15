package com.example.notesapp.Main.viewmodel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.notesapp.Main.util.Repository;
import com.example.notesapp.core.database.Note;
import java.util.List;
public class NotesViewModel extends ViewModel {
    private final Repository repository;
    public NotesViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<List<Note>> getAllNotes() {
        return repository.getAllNotes();
    }
    public void insert(Note note) {
        repository.insert(note);
    }
    public void update(Note note) {
        repository.update(note);
    }
    public void delete(Note note) {
        repository.delete(note);
    }
}