package com.example.roomdbsample.view;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdbsample.R;
import com.example.roomdbsample.model.Note;
import com.example.roomdbsample.model.NoteEntity;
import com.example.roomdbsample.providers.NoteDatabase;
import com.example.roomdbsample.viewmodel.NoteViewModel;

public class CreateNoteActivity extends AppCompatActivity {

    private Button mSave;
    private EditText mEdit;
    private NoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        mSave =(Button) findViewById(R.id.btn_save);
        mEdit =(EditText)findViewById(R.id.id_title);
        init();
    }

    private void init() {
        mSave.setOnClickListener(view -> {

            String content = mEdit.getText().toString();

            if(!TextUtils.isEmpty(content)) {
                Note note = new Note();
                note.setText(content);
                note.setDate(System.currentTimeMillis());
                viewModel.insert(note);
            }
        });
    }
}
