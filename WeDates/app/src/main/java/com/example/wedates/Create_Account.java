package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_Account extends AppCompatActivity {
EditText user_Email,user_Name,user_Phone,user_Password,Confirm_pass;
Button Create_btn;
FirebaseAuth firebaseAuth;
DatabaseReference databaseReference;
TextView Login_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        Login_txt=findViewById(R.id.Login_Interface);
        Create_btn=findViewById(R.id.create_account_btn);
        user_Email=findViewById(R.id.user_email);
        user_Name=findViewById(R.id.user_name);
        user_Phone=findViewById(R.id.user_phone);
        user_Password=findViewById(R.id.user_password);
        Confirm_pass=findViewById(R.id.user_confirm_password);
        Login_txt.setOnClickListener(view -> startActivity(new Intent(Create_Account.this,Login_Screen.class)));
        Create_btn.setOnClickListener(view -> Account_create());

    }

    private void Account_create() {
        String user_name =user_Name.getText().toString();
       String Email_Create=user_Email.getText().toString();
       String Pass_Create=user_Password.getText().toString();
       String confirm_pass=Confirm_pass.getText().toString();
       String Phone_number=user_Phone.getText().toString();
       Boolean isDataOk= Check_Data(Email_Create,Pass_Create,confirm_pass,Phone_number, user_name);
       if(!isDataOk){
           return;
       }
       AccountCreateInFireBase(Email_Create,Pass_Create,Phone_number, user_name);

       String key=databaseReference.push().getKey();
       UserData user=new UserData(user_name,Email_Create,Phone_number,Pass_Create);
       databaseReference.child(key).setValue(user);

    }


    private void AccountCreateInFireBase(String email_create, String pass_create, String phone_number, String user) {
        firebaseAuth.createUserWithEmailAndPassword(email_create,pass_create)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Create_Account.this, "Check Your Email To Verify", Toast.LENGTH_SHORT).show();
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                                startActivity(new Intent(Create_Account.this, Login_Screen.class));
                                firebaseAuth.signOut();
                                finish();
                        }else{
                            Toast.makeText(Create_Account.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private Boolean Check_Data(String email_create, String pass_create, String confirm_pass, String phone_number, String user) {
        if(!Patterns.EMAIL_ADDRESS.matcher(email_create).matches()){
            if(user.length()==0){
                user_Name.setError("Name is Empty");
                return false;
            }
            user_Email.setError("Email is Invalid");
            return false;
        } else if (pass_create.length()<6) {
            user_Password.setError("Password Length Less Than 6");
            return false;
        } else if (!confirm_pass.equals(pass_create)) {
            Confirm_pass.setError("Password is'nt mathch");
            return false;
            
        } else if (phone_number.length()<11) {
            user_Phone.setError("Phone Number is Invalid");
            return false;
        }
        return true;
    }
}