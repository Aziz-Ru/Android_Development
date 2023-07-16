package com.aziz.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
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
TextView title_text,Delete_txt;
String title_intent,content_intent,docId;
boolean ok=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_create);

        save_btn=findViewById(R.id.save_Button);
        title=findViewById(R.id.title_id);
        context=findViewById(R.id.context_id);
        title_text=findViewById(R.id.new_note_txt);
        Delete_txt=findViewById(R.id.delete_text);

        title_intent=getIntent().getStringExtra("title");
        content_intent=getIntent().getStringExtra("content");
        docId=getIntent().getStringExtra("docId");

        if(docId!=null&&!docId.isEmpty()){
            ok=true;

        }
        title.setText(title_intent);
        context.setText(content_intent);

        if(ok){
            title_text.setText("Edit Your Notes");
            Delete_txt.setVisibility(View.VISIBLE);
        }

        save_btn.setOnClickListener(v -> save_note());
        Delete_txt.setOnClickListener(v -> deleteFromFireBase());
    }

    private void deleteFromFireBase() {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceNote().document(docId);
        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(NoteCreate.this, "Note Deleted Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(NoteCreate.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void save_note() {
        String note_title=title.getText().toString();
        String all_context=context.getText().toString();
        if(note_title.isEmpty()){
            title.setError("Title is Required");
            return;
        }
        Notes  note=new Notes ();
        note.setTitle(note_title);
        note.setContent(all_context);
        note.setTimestamp(Timestamp.now());
        save_note_firebase(note);
    }

    private void save_note_firebase(Notes note) {

        DocumentReference documentReference;
        if(ok){
            documentReference = Utility.getCollectionReferenceNote().document(docId);

        }else{
            documentReference = Utility.getCollectionReferenceNote().document();
        }

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(NoteCreate.this, "Note Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(NoteCreate.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}