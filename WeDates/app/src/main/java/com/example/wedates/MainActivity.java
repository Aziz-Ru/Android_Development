package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.wedates.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
TextView profile_name,profile_phone;
View headerView;
DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.mainactivityToolbar);
        getSupportActionBar().setTitle("We Dates");
        binding.mainactivityToolbar.setTitleTextAppearance(this,R.style.toolbar_font);

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.mainActivityTablayout.setupWithViewPager(binding.viewPager);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,binding.mainActivityDrawerLayout,binding.mainactivityToolbar,R.string.nav_open,R.string.nav_close);
        binding.mainActivityDrawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));
        toggle.syncState();
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.logout_menu){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, Login_Screen.class));
                }
                return false;
            }
        });



    }









}


