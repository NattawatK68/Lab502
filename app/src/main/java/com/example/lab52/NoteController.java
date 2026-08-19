package com.example.lab52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoteController {
    private List<Note> notes;

    public NoteController() {
        this.notes = new ArrayList<>();
    }

    public Note addNote(String userName, String title, String content, boolean isTextNote) {
        User user = new User(userName);
        Note note;
        if (isTextNote) {
            note = new TextNote(title, user, content);
        } else {
            List<String> items = Arrays.asList(content.split(","));
            note = new CheckListNote(title, user, items);
        }
        notes.add(note);
        return note;
    }

    public List<Note> getAllNotes() {
        return notes;
    }
    
    public String getFormattedNote(Note note) {
        return note.toString();
    }
}