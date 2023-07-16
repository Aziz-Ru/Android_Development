package com.aziz.zoomcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
ZoomControls xoom;
TextView txt;
float textsize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xoom=findViewById(R.id.zoom);
        txt=findViewById(R.id.txt);
        textsize=txt.getTextSize();
        xoom.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsize+=1;
                txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, textsize);
            }
        });
        xoom.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsize-=1;
                txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, textsize);
            }
        });

    }


}