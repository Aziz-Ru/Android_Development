package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

import com.example.wedates.databinding.ActivityCreateAccountBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_Account extends AppCompatActivity {
    ActivityCreateAccountBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(Create_Account.this);
        progressDialog.setTitle("Creating Your Account");
        progressDialog.setMessage("Verify Your Email");
        binding.LoginTxtBtn.setOnClickListener(view -> startActivity(new Intent(Create_Account.this, Login_Screen.class)));
        binding.createAccountBtn.setOnClickListener(view -> Create_FireBase());
    }


    private void Create_FireBase() {

        Boolean isDataOk= Check_Data();
        if(!isDataOk){
            return;
        }
        progressDialog.show();
            mAuth.createUserWithEmailAndPassword(binding.UserEmail.getText().toString(),binding.UserPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()){
                                String name=binding.UserName.getText().toString();
                                String email=binding.UserEmail.getText().toString();
                                String password=binding.UserPassword.getText().toString();
                                mAuth.getCurrentUser().sendEmailVerification();

                                String id=task.getResult().getUser().getUid();
                                UserData userdata=new UserData(name,email,password);
                                database.getReference("User").child(id).setValue(userdata);
                                mAuth.signOut();
                                finish();

                            }else{
                                Toast.makeText(Create_Account.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    private Boolean Check_Data() {

        if(binding.UserName.getText().toString().length()==0){
            binding.UserName.setError("Name is Empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(binding.UserEmail.getText().toString()).matches()){
            binding.UserEmail.setError("Email is Invalid");
            return false;
        } else if (binding.UserPassword.getText().toString().length()<6) {
            binding.UserPassword.setError("Password Length Less Than 6");
            return false;
        } else if (!binding.UserConfirmPassword.getText().toString().equals(binding.UserPassword.getText().toString())) {
            binding.UserConfirmPassword.setError("Password is'nt mathch");
            return false;

        }
        return true;
    }
}