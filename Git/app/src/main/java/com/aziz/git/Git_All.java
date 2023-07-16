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

public class Git_All extends AppCompatActivity {
    AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_all);
        appBarLayout=findViewById(R.id.layout_gitall);
        Toolbar toolbar=findViewById(R.id.git_all_toolbar);
        setTitle("Home");
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
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
        if(item.getItemId()==android.R.id.home){
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

    public void Clicked(View v){
        if(v.getId()==R.id.Vcs_Git_Btn){
            Toast.makeText(this, "VCS ও Git এর পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Vcs_Git.class));

        }
        else if(v.getId()==R.id.State_Repo_Btn){
            Toast.makeText(this, "Git State ও Repository পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Git_State_Repo.class));
        }
        else if(v.getId()==R.id.Init_Commit_Btn){
            Toast.makeText(this, "Git Branch ও Merge এর পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Init_Commit.class));
        }
       else if(v.getId()==R.id.Branch_Merge_Btn){
            Toast.makeText(this, "Git Branch ও Merge এর পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Branch_Merge.class));
        }
        else if(v.getId()==R.id.Remote_Push_Btn){
            Toast.makeText(this, "Git Remote ও Push এর পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Remote_push.class));
        }
        else if(v.getId()==R.id.Config_btn){
            Toast.makeText(this, "Git Config এর পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Config.class));
        }
        else if(v.getId()==R.id.Ssh_btn){
            Toast.makeText(this, "Ssh-key এর পরিচিতি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Git_All.this, Ssh.class));
        }
    }


}