package com.aziz.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirstInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_interface);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    startActivity(new Intent(FirstInterface.this,MainActivity.class));
                }else{
                    startActivity(new Intent(FirstInterface.this,Login.class));
                }
                finish();
            }
        },1000);

    }
}