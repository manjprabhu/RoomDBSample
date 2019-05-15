package com.example.roomdbsample.model;


public class Note {

    private String text;

    private long date;

    public long getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }
}
