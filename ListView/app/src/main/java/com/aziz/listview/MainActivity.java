package com.aziz.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Spinner District;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
      District=findViewById(R.id.spinner);
//        ArrayList<String> Districts=new ArrayList<>();
//        Districts.add("LalmonirHat");
//        Districts.add("Nilphamary");
//        Districts.add("Netrokona");
//        Districts.add("Rangpur");
//        ArrayAdapter<String> DistrictName=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,Districts);
//        District.setAdapter(DistrictName);
       District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this, District.getSelectedItem().toString()+" selected", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


        ArrayList<String> student=new ArrayList<>();
        student.add("Aziz");
        student.add("Sakib");
        student.add("Kabbo");
        student.add("Apurbo");
        ArrayAdapter<String> studentAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,student);
        listView.setAdapter(studentAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,student.get(position)+" Selected" , Toast.LENGTH_SHORT).show();
            }
        });


    }
}