package com.aziz.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_home){
                   loadfragment(new HomeFragment());
                }else if (item.getItemId()==R.id.opacity){
                    loadfragment(new opacityFragment());
                } else if (item.getItemId()==R.id.notification) {
                    loadfragment(new NotificationFragment());
                }else if (item.getItemId()==R.id.person){
                    loadfragment(new ProgileFragment());
                }else {
                    loadfragment(new CameraFragment());
                }
                return true;
            }
        });
    }
    public  void loadfragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.frame,fragment);
        ft.commit();
    }
}