package com.example.lab52;

public abstract class Note {
    private String title;
    private User user;

    public Note(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public abstract String getNoteDetails();

    @Override
    public String toString() {
        return "Title: " + title + "\n" + user.toString() + "\n" + getNoteDetails();
    }
}