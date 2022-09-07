package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHandler handler = new DbHandler(this, "empdb", null, 1);
        handler.addEmployee(new Employee(1, "Harry", 33.3));
        handler.addEmployee(new Employee(2, "Rocky", 55.23));
        handler.getEmployee(1);
        handler.getEmployee(2);
        handler.close();
    }
}