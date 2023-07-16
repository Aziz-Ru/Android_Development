package com.aziz.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("My World");
        //step1
        setSupportActionBar(toolbar);
        //step2
        if (getSupportActionBar()!=null){
           // getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new  MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.setting){
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.home){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}