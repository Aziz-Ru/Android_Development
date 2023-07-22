package com.example.wedates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.wedates.databinding.ActivitySplashScreenBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash_screen extends AppCompatActivity {
ActivitySplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                FirebaseUser user=firebaseAuth.getCurrentUser();

                if(user!=null&&user.isEmailVerified()){
                    startActivity(new Intent(splash_screen.this,MainActivity.class));
                }else{
                    startActivity(new Intent(splash_screen.this,Login_Screen.class));
                }
                finish();
            }
        },1000);
    }
}