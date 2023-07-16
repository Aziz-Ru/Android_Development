package com.aziz.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittxt);
        button = findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = editText.getText().toString();
                if(txt!=null){
                    write_to_file(txt);
                }else {
                    Toast.makeText(MainActivity.this, "Save it", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public  void  write_to_file(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("hello.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void read(){
        try {
            FileInputStream fileInputStream=openFileInput("hello.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer=new StringBuffer();
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\n");
            }
            editText.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
