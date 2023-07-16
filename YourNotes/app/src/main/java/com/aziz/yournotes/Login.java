package com.aziz.yournotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
 EditText create_email,create_pass;
 Button btn_login;
 TextView txtclick;
 ProgressBar p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        create_email=findViewById(R.id.email_create_id);
        create_pass=findViewById(R.id.password_create_id);
        p=findViewById(R.id.progress_login);
        btn_login=findViewById(R.id.final_login_btn);
        txtclick=findViewById(R.id.create_account_text_id);
        btn_login.setOnClickListener(v -> login_user());
        txtclick.setOnClickListener(v -> startActivity(new Intent(Login.this, CreateAccount.class)));
    }

    private void login_user() {
        String e=create_email.getText().toString();
       String pass= create_pass.getText().toString();
       boolean ok=checkData(e,pass);
       if(!ok){
           return;
       }
       loginInFirebase(e,pass);
    }

    private void loginInFirebase(String e, String pass) {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        ChangeInProgressBar(true);
        firebaseAuth.signInWithEmailAndPassword(e,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                ChangeInProgressBar(false);
                if(task.isSuccessful()){
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
                else {
                    Toast.makeText(Login.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void ChangeInProgressBar(boolean b) {
        if(b){
            p.setVisibility(View.VISIBLE);
            btn_login.setVisibility(View.GONE);
        }
        else{
            p.setVisibility(View.GONE);
            btn_login.setVisibility(View.VISIBLE);
        }
    }
    private boolean checkData(String email_name, String password_name) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email_name).matches()) {
            create_email.setError("Email id Invalid");
            return false;
        }
        if(password_name.length()<6){
            create_pass.setError("Password Length less than six");
            return  false;
        }
        return true;
    }
}