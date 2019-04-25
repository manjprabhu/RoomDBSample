package com.example.roomdbsample.providers;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.roomdbsample.model.NoteDao;
import com.example.roomdbsample.model.NoteEntity;

@Database(entities = {NoteEntity.class}, version = NoteDatabase.VERSION)

public abstract class NoteDatabase extends RoomDatabase {


    public abstract NoteDao noteDao();

    public static final int VERSION = 1;
}
