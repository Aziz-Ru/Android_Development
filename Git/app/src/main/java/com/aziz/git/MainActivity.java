package com.aziz.git;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public Button Enter,Exit;
AlertDialog.Builder alertbuilder;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initID(Enter,R.id.Git_Enter);
        initID(Exit,R.id.Git_Exit);
    }
    private void initID(Button btn ,int id){
        Button btn_here=(Button)btn;
        btn_here=findViewById(id);
        btn_here.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     if(v.getId()==R.id.Git_Enter){
         startActivity(new Intent(MainActivity.this, Git_All.class));
     }
     else {
         alertbuilder=new AlertDialog.Builder(this).setTitle(R.string.title).setMessage(R.string.message)
                 .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }
                 }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 });
         alertbuilder.create().show();

     }
    }
}