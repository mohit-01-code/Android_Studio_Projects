package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
//    String[] arr = {"Jany", "Mark", "Peter parker", "Tony Stark", "Nikita", "MS Dhoni", "Virat Kohli", "Sanjay Dutt", "PM Modi", "Vacation Trip", "Main Office", "Rahul", "Krunal Pandeya", "MD Sir", "+91 9982111105"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyData data = new MyData();
        MyCustomAdapter ad = new MyCustomAdapter(data);
        recyclerView.setAdapter(ad);
    }
}