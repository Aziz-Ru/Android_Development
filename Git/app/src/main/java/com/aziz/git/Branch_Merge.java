package com.aziz.git;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

public class Branch_Merge extends AppCompatActivity {
private AppBarLayout appBarLayout;
float textSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_merge);
        appBarLayout=findViewById(R.id.layout_branch);

        Toolbar toolbar_branch=findViewById(R.id.branch_toolbar);
        toolbar_branch.setTitle("Git Branch ও Merge এর পরিচিতি");
        setSupportActionBar(toolbar_branch);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.user_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
        }
        if(item.getItemId()==R.id.setting_menu){
            Toast.makeText(this, "We Are Developing App setting", Toast.LENGTH_SHORT).show();

        }

        if(item.getItemId()==R.id.menu_yellow_color_background){
            Toast.makeText(this, "Background Is Now Yellow ", Toast.LENGTH_SHORT).show();
            appBarLayout.setBackgroundColor(Color.YELLOW);

        }
        if(item.getItemId()==R.id.menu_green_color_background){
            Toast.makeText(this, "Background Is Now Green ", Toast.LENGTH_SHORT).show();
            appBarLayout.setBackgroundColor(Color.GREEN);

        }

        return super.onOptionsItemSelected(item);
    }


}