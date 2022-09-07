package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
//    Button optA;
//    Button optB;
//    Button optC;
//    Button optD;
//    int score;
//    public static final String EXTRA_SCORE = "com.example.quizapp.extra.score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
//        Intent intent = getIntent();
//        score = Integer.parseInt(intent.getStringExtra(MainActivity5.EXTRA_SCORE));
//        optA = findViewById(R.id.button);
//        optB = findViewById(R.id.button2);
//        optC = findViewById(R.id.button3);
//        optD = findViewById(R.id.button4);
    }

    public void clickButtonNext(View view) {
        Toast.makeText(this, "Next Question", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity7.class);
//        intent.putExtra(EXTRA_SCORE, score);
        startActivity(intent);
    }

    public void clickButtonPrev(View view) {
        Toast.makeText(this, "Previous Question", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}