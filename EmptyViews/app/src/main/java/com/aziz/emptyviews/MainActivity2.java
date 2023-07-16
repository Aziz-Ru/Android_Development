package com.aziz.emptyviews;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      ActionBar actionBar=getSupportActionBar();
       if(actionBar!=null){
          getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
          getSupportActionBar().setCustomView(R.layout.abs);
          actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ACC1")));
        }
    }

    public void back(View view) {
        this.finish();
    }
}