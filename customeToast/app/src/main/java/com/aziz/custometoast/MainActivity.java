package com.aziz.custometoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "This is Toast", Toast.LENGTH_SHORT).show();
        Toast toast=new Toast(MainActivity.this);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.cutome_toast,(ViewGroup) findViewById(R.id.viewshower));
                toast.setView(view);
                TextView txt=view.findViewById(R.id.txtmsg);
                txt.setText("Want Exit");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
            }
        });

    }
}