package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Screen extends AppCompatActivity {
EditText Email_user,Pass_user;
TextView createAccount;
FirebaseAuth mAuth;
Button Login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mAuth=FirebaseAuth.getInstance();
        Email_user=findViewById(R.id.email_user);
        Pass_user=findViewById(R.id.password_user);
        Login_btn=findViewById(R.id.Login_button);
        createAccount=findViewById(R.id.create_account_txt);
        createAccount.setOnClickListener(view -> startActivity(new Intent(Login_Screen.this, Create_Account.class)));
        Login_btn.setOnClickListener(view -> Login_Main_activity());

    }

    private void Login_Main_activity() {
        String Uemail=Email_user.getText().toString();
        String Upass=Pass_user.getText().toString();
        if(!Patterns.EMAIL_ADDRESS.matcher(Uemail).matches()){
            Email_user.setError("Email is Invalid");
            return;
        }
        else if(Upass.length()<6){
            Pass_user.setError("Password is less than 6");
            return;
        }

        Login_FireBase(Uemail,Upass);

    }

    private void Login_FireBase(String uemail, String upass) {
        mAuth.signInWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(Login_Screen.this, MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(Login_Screen.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}