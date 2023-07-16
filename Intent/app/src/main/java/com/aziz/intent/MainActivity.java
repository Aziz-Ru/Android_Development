package com.aziz.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText number1,number2;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1=findViewById(R.id.first_number);
        number2=findViewById(R.id.second_number);
        btn=findViewById(R.id.add_Button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1= number2.getText().toString();
                String num2=  number1.getText().toString();
                Intent next=new Intent(MainActivity.this, MainActivity2.class);
                next.putExtra("num1",num1);
                next.putExtra("num2",num2);
                startActivity(next);
            }
        });

    }
}