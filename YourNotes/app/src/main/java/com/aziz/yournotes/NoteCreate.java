package com.aziz.yournotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NoteCreate extends AppCompatActivity {
ImageButton save_btn;
EditText title,context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_create);
        save_btn=findViewById(R.id.save_Button);
        title=findViewById(R.id.title_id);
        context=findViewById(R.id.context_id);
        save_btn.setOnClickListener(v -> save_note());
    }

    private void save_note() {
        String note_title=title.getText().toString();
        String all_context=context.getText().toString();
        if(note_title.isEmpty()){
            title.setError("Title is Required");
            return;
        }
        NOtesModel note=new NOtesModel();
        note.setTitle(note_title);
        note.setContent(all_context);
        note.setTimestamp(Timestamp.now());
        save_note_firebase(note);
    }

    private void save_note_firebase(NOtesModel note) {
        FirebaseUser currentuser= FirebaseAuth.getInstance().getCurrentUser();
        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("notes")
                .document(currentuser.getUid()).collection("my_notes").document();
        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(NoteCreate.this, "Note Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(NoteCreate.this, "Failed To Add Note", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}