package com.aziz.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
   private RadioGroup R1;
    private ProgressBar progressBar,progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        R1=findViewById(R.id.R1);
        progressBar=findViewById(R.id.progress);
        progressBar2=findViewById(R.id.pr2);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    progressBar2.incrementProgressBy(10);
                    SystemClock.sleep(1000);
                }
            }
        });
        thread.start();
        R1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.cse) {
                    Toast.makeText(MainActivity.this, "cse", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar2.setVisibility(View.GONE);
                }

                if(checkedId==R.id.ice) {
                    Toast.makeText(MainActivity.this, "ice", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    progressBar2.setVisibility(View.GONE);
                }

                if(checkedId==R.id.acce) {
                    Toast.makeText(MainActivity.this, "acce", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    progressBar2.setVisibility(View.GONE);
                }
                if(checkedId==R.id.pharmacy) {
                    Toast.makeText(MainActivity.this, "pharmacy", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    progressBar2.setVisibility(View.GONE);
                }

            }
        });



    }


}