package com.example.roomdbsample.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.roomdbsample.Adapter.CustomAdapter;
import com.example.roomdbsample.R;
import com.example.roomdbsample.viewmodel.NoteViewModel;

import java.util.ArrayList;

public class LauncherActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CustomAdapter mCustomAdapter;
    private NoteViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        mViewModel  = ViewModelProviders.of(this).get(NoteViewModel.class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LauncherActivity.this, CreateNoteActivity.class);
                LauncherActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_note);
        mCustomAdapter =  new CustomAdapter(this,new ArrayList<>(0));
        mRecyclerView.setAdapter(mCustomAdapter);
        mViewModel.getAllNote().observe(this, list -> {
            mCustomAdapter.updateSource(list);
        });
    }
}
