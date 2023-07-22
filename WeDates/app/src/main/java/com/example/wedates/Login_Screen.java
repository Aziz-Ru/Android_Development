package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wedates.databinding.ActivityLoginScreenBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Screen extends AppCompatActivity {
    ActivityLoginScreenBinding binding;
FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();

        binding.createAccountTxt.setOnClickListener(view -> startActivity(new Intent(Login_Screen.this,Create_Account.class)));
        binding.LoginButton.setOnClickListener(view -> Login_Main_activity());

    }

    private void Login_Main_activity() {
        mAuth.signInWithEmailAndPassword(binding.emailUser.getText().toString(),binding.passwordUser.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){


                    if(mAuth.getCurrentUser().isEmailVerified()){
                        startActivity(new Intent(Login_Screen.this, MainActivity.class));
                        finish();
                    } else {
                        AlertDialog.Builder builder=new AlertDialog.Builder(Login_Screen.this);
                        builder.setTitle("Email is not Verify").setMessage("Please Verify Your Email")
                                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent next=new Intent(Intent.ACTION_MAIN);
                                        next.addCategory(Intent.CATEGORY_APP_EMAIL);
                                        next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(next);
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                        builder.create().show();
                    }
                }
                else {
                    Toast.makeText(Login_Screen.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

}


}