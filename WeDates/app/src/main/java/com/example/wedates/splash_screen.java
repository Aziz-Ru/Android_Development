package com.example.wedates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash_screen extends AppCompatActivity {
ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progress=findViewById(R.id.progress_bar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    startActivity(new Intent(splash_screen.this,MainActivity.class));
                }else{
                    startActivity(new Intent(splash_screen.this,Create_Account.class));
                }
                finish();
            }
        },1000);
    }
}