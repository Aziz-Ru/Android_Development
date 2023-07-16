package com.aziz.login_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {
TextView Create_Account_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Create_Account_text=findViewById(R.id.Create_account_text);
        Create_Account_text.setOnClickListener(v -> startActivity(new Intent(Login.this, CreateAccount.class)));
    }
}