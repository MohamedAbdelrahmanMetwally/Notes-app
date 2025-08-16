package com.example.notesapp.Main.ui;
import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesapp.Main.util.FactoryViewModel;
import com.example.notesapp.Main.util.Repository;
import com.example.notesapp.Main.viewmodel.NotesViewModel;
import com.example.notesapp.R;
import com.example.notesapp.core.database.Note;
import com.example.notesapp.core.database.NoteDatabase;
import com.example.notesapp.databinding.FragmentAddOrUpdateFragemntBinding;

public class AddOrUpdateFragemnt extends Fragment {
    private FragmentAddOrUpdateFragemntBinding binding;
    private Repository repository;
    private FactoryViewModel factoryViewModel;
    private NotesViewModel notesViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddOrUpdateFragemntBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository = new Repository(NoteDatabase.getInstance(getContext()).noteDao());
        factoryViewModel = new FactoryViewModel(repository);
        notesViewModel = factoryViewModel.create(NotesViewModel.class);
        AddOrUpdateFragemntArgs args = AddOrUpdateFragemntArgs.fromBundle(getArguments());
        Note note = args.getNote();
        boolean isUpdate = args.getIsUpdate();
        if (isUpdate) {
            binding.btnaddOrUpdate.setText("Update");
            binding.etDate.setText(note.getTimestamp());
            binding.etTitle.setText(note.getTitle());
            binding.etDescriptionUpdate.setText(note.getDescription());
            binding.btnaddOrUpdate.setOnClickListener(v -> {
                if(binding.etDate.getText().toString().isEmpty() || binding.etTitle.getText().toString().isEmpty() || binding.etDescriptionUpdate.getText().toString().isEmpty())
                {
                    if(binding.etDate.getText().toString().isEmpty()){
                        binding.etDate.setError("Date is required");
                        binding.etDate.requestFocus();
                    }
                    if(binding.etTitle.getText().toString().isEmpty()){
                        binding.etTitle.setError("Title is required");
                        binding.etTitle.requestFocus();
                    }
                    if(binding.etDescriptionUpdate.getText().toString().isEmpty()){
                        binding.etDescriptionUpdate.setError("Description is required");
                        binding.etDescriptionUpdate.requestFocus();
                    }
                    return;
                }
                note.setTimestamp(binding.etDate.getText().toString());
                note.setTitle(binding.etTitle.getText().toString());
                note.setDescription(binding.etDescriptionUpdate.getText().toString());
                notesViewModel.update(note);
                findNavController(view).navigate(R.id.action_nav_graph_to_navigation_show);

            });
        } else {
            binding.btnaddOrUpdate.setText("Add");
            binding.btnaddOrUpdate.setOnClickListener(v -> {
                if(binding.etDate.getText().toString().isEmpty() || binding.etTitle.getText().toString().isEmpty() || binding.etDescriptionUpdate.getText().toString().isEmpty())
                {
                    if(binding.etDate.getText().toString().isEmpty()){
                        binding.etDate.setError("Date is required");
                        binding.etDate.requestFocus();
                    }
                    if(binding.etTitle.getText().toString().isEmpty()){
                        binding.etTitle.setError("Title is required");
                        binding.etTitle.requestFocus();
                    }
                    if(binding.etDescriptionUpdate.getText().toString().isEmpty()){
                        binding.etDescriptionUpdate.setError("Description is required");
                        binding.etDescriptionUpdate.requestFocus();
                    }
                    return;
                }
                notesViewModel.insert(new Note(binding.etTitle.getText().toString(), binding.etDescriptionUpdate.getText().toString(), binding.etDate.getText().toString()));
                findNavController(view).navigate(R.id.action_nav_graph_to_navigation_show);
            });
        }
        binding.btnBack.setOnClickListener(v -> {
            findNavController(v).navigate(R.id.action_nav_graph_to_navigation_show);
        });
    }
}