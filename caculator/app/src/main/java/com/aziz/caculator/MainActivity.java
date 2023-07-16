package com.aziz.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonAdd;
    private Button buttonSubtract;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        textViewResult = findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });
    }

    private void calculate(char operator) {
        String number = editText.getText().toString();
        if (!number.isEmpty()) {
            int value = Integer.parseInt(number);
            int result;
            switch (operator) {
                case '+':
                    result = value + value;
                    textViewResult.setText(String.valueOf(result));
                    break;
                case '-':
                    result = value - value;
                    textViewResult.setText(String.valueOf(result));
                    break;
            }
        }
    }
}
