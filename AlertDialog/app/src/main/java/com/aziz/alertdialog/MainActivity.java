package com.aziz.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn;
    AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Alert Dialog").setMessage("Do you want to Exit").setIcon(R.drawable.download).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              finish();
          }
      }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
          }
      }).setNeutralButton("After", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(MainActivity.this, "you will do it later", Toast.LENGTH_SHORT).show();
          }
      });
        alertDialog.create().show();
    }
}