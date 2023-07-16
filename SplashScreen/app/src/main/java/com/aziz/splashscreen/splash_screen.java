package com.aziz.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ProgressBar progressBar=findViewById(R.id.progress);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.getProgress();
                startActivity(new Intent(splash_screen.this,MainActivity.class));
                finish();
            }
        },2000);

    }
}