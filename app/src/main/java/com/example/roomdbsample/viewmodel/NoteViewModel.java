package com.example.roomdbsample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.example.roomdbsample.model.Note;
import com.example.roomdbsample.model.NoteEntity;
import com.example.roomdbsample.providers.NoteDatabase;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private  LiveData<List<Note>> list;
    private NoteDatabase database;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        database = Room.databaseBuilder(getApplication(),NoteDatabase.class,"notedb").allowMainThreadQueries().build();
    }

    public LiveData<List<Note>> getAllNote() {
        list = database.noteDao().getAllNote();
        return list;
    }

    public void insert(Note note) {
        NoteEntity entity = NoteEntity.builder().body(note.getText())
                .date(note.getDate()).build();
        database.noteDao().Insert(entity);
    }

    public void delete(Note note) {
        NoteEntity entity = NoteEntity.builder().body(note.getText())
                .date(note.getDate()).build();
        database.noteDao().Delete(entity);
    }
}
