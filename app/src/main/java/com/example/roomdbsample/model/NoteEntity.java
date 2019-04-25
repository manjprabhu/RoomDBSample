package com.example.roomdbsample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Builder;

@Entity(tableName = "note")
@Builder(toBuilder = true)
public class NoteEntity {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    public long _id;

    @ColumnInfo(name = "text")
    public String body;

    @ColumnInfo(name = "date")
    public long date;

}
