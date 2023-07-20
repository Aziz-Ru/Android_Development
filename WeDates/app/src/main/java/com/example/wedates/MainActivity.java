package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout FragmentHolder;
ViewPager viewPager;
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.main_activity_DrawerLayout);
        navigationView=findViewById(R.id.navigation_view);
        FragmentHolder=findViewById(R.id.main_activity_Tablayout);
        toolbar=findViewById(R.id.mainactivity_toolbar);
        viewPager=findViewById(R.id.view_Pager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("We Dates");

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        FragmentHolder.setupWithViewPager(viewPager);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));
        toggle.syncState();


    }








}


