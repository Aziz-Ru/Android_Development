package com.aziz.git;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

public class Git_State_Repo extends AppCompatActivity {
AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_state_repo);
        Toolbar state_toolbar=findViewById(R.id.toolbar_state);
        appBarLayout=findViewById(R.id.layout_state);
        state_toolbar.setTitle("Git State ও Repository পরিচিতি");
        setSupportActionBar(state_toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.user_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}