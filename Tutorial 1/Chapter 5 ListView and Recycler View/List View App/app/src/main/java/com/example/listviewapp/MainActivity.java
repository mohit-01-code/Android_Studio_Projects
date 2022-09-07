package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
//    String [] arr = {"Peter Parker", "Tony office", "Harsh Beniwal", "Carry Minati", "Harish Khan", "Shubham Patel", "Sakshi Dave", "Deepika", "Peter Uncle", "Sam Curren", "Babu Bhaiya", "Shweta"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

//        using Built in Layout
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
//        listView.setAdapter(ad);

//        Here is a further list of layouts that you can use:
//        http://developer.android.com/reference/android/R.layout.html
//
//        https://github.com/android/platform_frameworks_base/tree/master/core/res/res/layout )
//        You can actually view the code for the layouts.

//        using custom layout
        MyData myData = new MyData();
        MyCustomAdapter ad = new MyCustomAdapter(this, R.layout.my_custom_layout, myData);
        listView.setAdapter(ad);
    }
}