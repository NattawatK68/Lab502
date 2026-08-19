package com.example.lab52;

public class TextNote extends Note {
    private String text;

    public TextNote(String title, User user, String text) {
        super(title, user);
        this.text = text;
    }

    @Override
    public String getNoteDetails() {
        return "Type: Text Note\nContent: " + text;
    }
}