package com.aziz.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
public  DrawerLayout drawerLayout;
public NavigationView navigationView;
Toolbar toolbar;
public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       drawerLayout=findViewById(R.id.draw_layout);
       navigationView=findViewById(R.id.nav_view);
       toolbar=findViewById(R.id.tool_bar);
       setSupportActionBar(toolbar);

       actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
       drawerLayout.addDrawerListener(actionBarDrawerToggle);
       actionBarDrawerToggle.syncState();
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if(item.getItemId()==R.id.nav_account){
                   Toast.makeText(MainActivity.this, "You click Account", Toast.LENGTH_SHORT).show();
               }
               else if (item.getItemId()==R.id.nav_setting){
                   Toast.makeText(MainActivity.this, "you click setting", Toast.LENGTH_SHORT).show();
               }
               else if(item.getItemId()==R.id.nav_logout){
                   Toast.makeText(MainActivity.this, "you click logout", Toast.LENGTH_SHORT).show();
               }
               return true;
           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new  MenuInflater(this).inflate(R.menu.navigation_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}