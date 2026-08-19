package com.example.lab52;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    private EditText etUserName, etNoteTitle, etNoteContent;
    private RadioGroup rgNoteType;
    private RadioButton rbTextNote;
    private Button btnSaveNote;
    private TextView tvDisplayNote;
    
    // Controller in MVC
    private NoteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        
        controller = new NoteController();

        etUserName = findViewById(R.id.etUserName);
        etNoteTitle = findViewById(R.id.etNoteTitle);
        etNoteContent = findViewById(R.id.etNoteContent);
        rgNoteType = findViewById(R.id.rgNoteType);
        rbTextNote = findViewById(R.id.rbTextNote);
        btnSaveNote = findViewById(R.id.btnSaveNote);
        tvDisplayNote = findViewById(R.id.tvDisplayNote);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndDisplayNote();
            }
        });

        Button btnBack = findViewById(R.id.button2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveAndDisplayNote() {
        String userName = etUserName.getText().toString();
        String title = etNoteTitle.getText().toString();
        String content = etNoteContent.getText().toString();
        boolean isTextNote = rbTextNote.isChecked();

        // Delegate logic to Controller
        Note newNote = controller.addNote(userName, title, content, isTextNote);

        // Update View with data from Controller/Model
        tvDisplayNote.setText(controller.getFormattedNote(newNote));
    }
}