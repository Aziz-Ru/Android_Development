package com.aziz.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
FloatingActionButton add;
cyclerAdapter cycle;
ArrayList<NotesModel> notes=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        add=findViewById(R.id.Add_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add.setOnClickListener(v -> addData());

        cycle=new cyclerAdapter(MainActivity.this,notes);
        recyclerView.setAdapter(cycle);
        notes.add(new NotesModel("Aziz","01745593392"));
        notes.add(new NotesModel("kabbo","01745593392"));
        notes.add(new NotesModel("apurba","01745593392"));
        notes.add(new NotesModel("Zahin","01745593392"));

    }

    private void addData() {
        Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custome_add);
        EditText phone_deo,name_deo;
        Button btn;

        btn=dialog.findViewById(R.id.add_deo);
        name_deo=dialog.findViewById(R.id.Name_neo);
        phone_deo=dialog.findViewById(R.id.Phone_neo);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_deo.getText().toString();
                if(name.isEmpty()){
                    name_deo.setError("Enter Name");
                    return;
                }
                String phone=phone_deo.getText().toString();
                if(phone.isEmpty()){
                    phone_deo.setError("Enter Phone");
                    return ;
                }

               else {
                    notes.add(new NotesModel(name,phone));
                    cycle.notifyItemInserted(notes.size()-1);
                    recyclerView.scrollToPosition(notes.size()-1);
                    dialog.dismiss();
                }

            }
        });
        dialog.show();

    }
}