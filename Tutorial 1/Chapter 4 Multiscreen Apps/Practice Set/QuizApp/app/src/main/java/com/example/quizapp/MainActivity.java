package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    Button optA;
//    Button optB;
//    Button optC;
//    Button optD;
//    int score;
//    public static final String EXTRA_SCORE = "com.example.quizapp.extra.score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        optA = findViewById(R.id.button);
//        optB = findViewById(R.id.button2);
//        optC = findViewById(R.id.button3);
//        optD = findViewById(R.id.button4);
    }

    public void clickButtonNext(View view) {
        Toast.makeText(this, "Next Question", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
//        intent.putExtra(EXTRA_SCORE, score);
        startActivity(intent);
    }
}