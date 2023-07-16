package com.aziz.emptyviews;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            SeekBar seekBar=findViewById(R.id.seek_bar);
            TextView textView=findViewById(R.id.txt_id);
            textView.setText("Volume "+seekBar.getProgress()+"/ "+seekBar.getMax());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    textView.setText("Volume "+progress+"/ "+seekBar.getMax());
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Toast.makeText(MainActivity.this, "On Start Tracking Touch", Toast.LENGTH_SHORT).show();

                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Toast.makeText(MainActivity.this, "On Stop Tracking Touch", Toast.LENGTH_SHORT).show();

                }
            });

    }

    public void go(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }
}