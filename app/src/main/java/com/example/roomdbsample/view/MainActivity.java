package com.example.roomdbsample.view;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdbsample.R;
import com.example.roomdbsample.model.Note;
import com.example.roomdbsample.model.NoteEntity;
import com.example.roomdbsample.providers.NoteDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mSave;
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSave =(Button) findViewById(R.id.btn_save);
        mEdit =(EditText)findViewById(R.id.id_text);
        init();
    }

    private void init() {
        mSave.setOnClickListener(view -> {

            String content = mEdit.getText().toString();

            Note note = new Note();
            note.setText(content);
            note.setDate(System.currentTimeMillis());

            NoteDatabase database = Room.databaseBuilder(this,NoteDatabase.class,"notedb").allowMainThreadQueries().build();

            NoteEntity entity = NoteEntity.builder().body(note.getText())
                    .date(note.getDate()).build();

            database.noteDao().Insert(entity);
        });
    }
}
