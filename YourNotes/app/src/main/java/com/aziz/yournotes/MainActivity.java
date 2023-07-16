package com.aziz.yournotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
FloatingActionButton add_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn=findViewById(R.id.add_note_button);
        add_btn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,NoteCreate.class)));

    }
}