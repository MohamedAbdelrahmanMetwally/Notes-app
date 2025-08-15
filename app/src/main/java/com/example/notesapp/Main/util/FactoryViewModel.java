package com.example.notesapp.Main.util;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.notesapp.Main.viewmodel.NotesViewModel;
public class FactoryViewModel implements ViewModelProvider.Factory {
    private final Repository repository;
    public FactoryViewModel(Repository repository) {
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NotesViewModel.class)) {
            return (T) new NotesViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
