package com.example.notesapp.Main.ui;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesapp.Main.util.Adapter;
import com.example.notesapp.Main.util.FactoryViewModel;
import com.example.notesapp.Main.util.Repository;
import com.example.notesapp.Main.viewmodel.NotesViewModel;
import com.example.notesapp.R;
import com.example.notesapp.core.database.Note;
import com.example.notesapp.core.database.NoteDatabase;
import com.example.notesapp.databinding.FragmentShowBinding;

import java.util.ArrayList;
import java.util.List;

public class ShowFragment extends Fragment {
    private FragmentShowBinding binding;
    private Repository repository;
    private FactoryViewModel factoryViewModel;
    private NotesViewModel notesViewModel;
    private List<Note> list;
    private Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShowBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        repository = new Repository(NoteDatabase.getInstance(getContext()).noteDao());
        factoryViewModel = new FactoryViewModel(repository);
        notesViewModel = factoryViewModel.create(NotesViewModel.class);
        adapter = new Adapter(list, getContext(), notesViewModel);
        binding.recyclerViewNotes.setAdapter(adapter);
        binding.recyclerViewNotes.setLayoutManager(new LinearLayoutManager(getContext()));
        notesViewModel.getAllNotes().observe(getViewLifecycleOwner(), notes -> {
            adapter.update(notes);
            if(notes == null || notes.isEmpty()){
                binding.textEmpty.setVisibility(View.VISIBLE);
            }
            else{
                binding.textEmpty.setVisibility(View.GONE);
            }
        });
        binding.btnAdd.setOnClickListener(v -> {
            boolean isUpdate = false;
            Note note = new Note();
            Navigation.findNavController(v).navigate(ShowFragmentDirections.actionNavGraphToNavigationAddOrUpdate(note, isUpdate));
        });
    }
}