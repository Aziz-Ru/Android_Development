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


public class Vcs_Git extends AppCompatActivity {
    AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcs_git);
        Toolbar vcs_toolbar=findViewById(R.id.toolbar_vcs);
        appBarLayout=findViewById(R.id.layout_vcs);
        vcs_toolbar.setTitle("VCS ও Git এর পরিচিতি");
        setSupportActionBar(vcs_toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.user_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
        }
        if(item.getItemId()==R.id.setting_menu){
            Toast.makeText(this, "We Are Developing App setting ", Toast.LENGTH_SHORT).show();

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