package com.aziz.mynotes;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageButton imageButton;
    FloatingActionButton add_btn;
    NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn=findViewById(R.id.add_note_button);
        recyclerView=findViewById(R.id.recycler_view);
        imageButton=findViewById(R.id.menu_Button);
        add_btn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,NoteCreate.class)));
        imageButton.setOnClickListener(v -> showMenu());
        setupRecyclerview();

    }

    private void setupRecyclerview() {
        Query query=Utility.getCollectionReferenceNote().orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Notes> options=new FirestoreRecyclerOptions.Builder<Notes>().setQuery(query,Notes.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter=new NoteAdapter(options,this);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

    private void showMenu() {
        PopupMenu popupMenu=new PopupMenu(MainActivity.this,imageButton);
        popupMenu.getMenu().add("Logout");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getTitle()=="Logout"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, Login.class));
                }
                return false;
            }
        });
    }
}