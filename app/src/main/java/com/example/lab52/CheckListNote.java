package com.example.lab52;

import java.util.List;

public class CheckListNote extends Note {
    private List<String> items;

    public CheckListNote(String title, User user, List<String> items) {
        super(title, user);
        this.items = items;
    }

    @Override
    public String getNoteDetails() {
        StringBuilder details = new StringBuilder("Type: Checklist Note\nItems:\n");
        for (String item : items) {
            details.append("- ").append(item).append("\n");
        }
        return details.toString();
    }
}