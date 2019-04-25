package com.example.roomdbsample.view;

import android.arch.persistence.room.Room;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdbsample.Adapter.CustomAdapter;
import com.example.roomdbsample.R;
import com.example.roomdbsample.databinding.ActivityMainBinding;
import com.example.roomdbsample.model.Note;
import com.example.roomdbsample.model.NoteEntity;
import com.example.roomdbsample.providers.NoteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private CustomAdapter mCustomAdapter;
    private RecyclerView mRecyclerView;
    private Button mSave;
    private EditText mEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_notes);
        mSave =(Button) findViewById(R.id.btn_save);
        mEdit =(EditText)findViewById(R.id.id_text);

        init();
    }

    private void init() {

        mCustomAdapter =  new CustomAdapter(this,new ArrayList<>(0));
        mRecyclerView.setAdapter(mCustomAdapter);
//        binding.rvNotes.setAdapter(mCustomAdapter);
        mRecyclerView.setAdapter(mCustomAdapter);

        NoteDatabase database = Room.databaseBuilder(this,NoteDatabase.class,"notedb").allowMainThreadQueries().build();

        mSave.setOnClickListener(view -> {

            String content = mEdit.getText().toString();

            Note note = new Note();
            note.setText(content);
            note.setDate(System.currentTimeMillis());

            NoteEntity entity = NoteEntity.builder().body(note.getText())
                    .date(note.getDate()).build();

            database.noteDao().Insert(entity);

            List<Note> noteqq = database.noteDao().getAllNote();
            mCustomAdapter.updateSource(noteqq);

        });


    }
}
