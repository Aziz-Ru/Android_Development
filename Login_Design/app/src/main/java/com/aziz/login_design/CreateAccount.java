package com.aziz.login_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {
TextView go_login_interface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        go_login_interface=findViewById(R.id.login_to_login_interface);
        go_login_interface.setOnClickListener(v -> startActivity(new Intent(CreateAccount.this, Login.class)));
    }
}