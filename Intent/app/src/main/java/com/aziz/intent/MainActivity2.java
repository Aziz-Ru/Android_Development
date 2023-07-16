package com.aziz.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.text_show);
        Intent getNext=getIntent();
        String num1= getNext.getStringExtra("num1");
        String num2= getNext.getStringExtra("num2");
       int add=Integer.parseInt(num1)+Integer.parseInt(num2);

        textView.setText(Integer.toString(add));
    }
}