package com.aziz.yournotes;

import static android.util.Patterns.EMAIL_ADDRESS;

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

public class CreateAccount extends AppCompatActivity {
EditText email,password,confirmPassword;
Button createbtn;
TextView login;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        initid();
        createbtn.setOnClickListener(v -> account_check());
        login.setOnClickListener(v -> startActivity(new Intent(CreateAccount.this, Login.class)));
    }

    private void account_check() {
        String email_name=email.getText().toString();
        String password_name=password.getText().toString();
        String confirm_name=confirmPassword.getText().toString();
        boolean check=checkData(email_name,password_name,confirm_name);
        if(!check){
            return;
        }
        CreateAccountInFireBase(email_name,password_name);

    }

    private void CreateAccountInFireBase(String email_name, String password_name) {
        ChangeInProgressBar(true);
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email_name,password_name).addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                ChangeInProgressBar(false);
                if(task.isSuccessful()){
                    Toast.makeText(CreateAccount.this, "Successfully Create Account ,Check Email To Verify", Toast.LENGTH_SHORT).show();
                    firebaseAuth.getCurrentUser().sendEmailVerification();
                    firebaseAuth.signOut();
                    finish();
                }else {
                    Toast.makeText(CreateAccount.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ChangeInProgressBar(boolean b) {
        if(b){
            progressBar.setVisibility(View.VISIBLE);
            createbtn.setVisibility(View.GONE);
        }
        else{
            progressBar.setVisibility(View.GONE);
            createbtn.setVisibility(View.VISIBLE);
        }
    }

    private boolean checkData(String email_name, String password_name, String confirm_name) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email_name).matches()) {
            email.setError("Email id Invalid");
            return false;
        }
        if(password_name.length()<6){
            password.setError("Password Length less than six");
            return  false;
        } else if (!password_name.equals(confirm_name)) {
            confirmPassword.setError("Not Matched");
            return false;

        }
        return true;
    }

    private void initid() {
        email=findViewById(R.id.email_name_id);
        password=findViewById(R.id.password_id);
        confirmPassword=findViewById(R.id.confirm_password_id);
        createbtn=findViewById(R.id.create_account_btn);
        login=findViewById(R.id.login_id);
        progressBar=findViewById(R.id.progress_bar);
    }
}