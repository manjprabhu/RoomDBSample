package com.example.roomdbsample.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    long Insert(NoteEntity noteEntity);

    @Update
    int Update(NoteEntity noteEntity);

    @Delete
    int Delete(NoteEntity noteEntity);

    @Query("SELECT * from note")
    LiveData<List<Note>> getAllNote();

}
