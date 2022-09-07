package com.example.explicitmultiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText name;
     stapublictic final String EXTRA_NAME = "com.example.explicitmultiscreenapp.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenSecondScreen(View view) {
        button = findViewById(R.id.button);
        name = findViewById(R.id.editTextTextPersonName);
        Toast.makeText(this, "Opening Second Screen", Toast.LENGTH_SHORT).show();
        String textName = name.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_NAME, textName);
        startActivity(intent);

    }
}