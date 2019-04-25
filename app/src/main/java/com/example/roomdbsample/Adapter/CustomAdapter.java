package com.example.roomdbsample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdbsample.model.Note;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NoteHolder> {

    private List<Note> mList;
    private Context mContext;

    public CustomAdapter(Context context, List<Note> noteList) {
        this.mList  = noteList;
        this.mContext =  context;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1,null,false);
       return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
        noteHolder.textView.setText(mList.get(i).getText());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    public void updateSource(List<Note> list) {
        mList = list;
        notifyDataSetChanged();
    }
}
