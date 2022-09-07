package com.example.multiplicationtableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private Button button;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        button.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){
                String s = editTextNumber.getText().toString();
                int num = Integer.parseInt(s);
                textView2.setText(num +" X 1 = " +(num * 1));
                textView3.setText(num +" X 2 = " +(num * 2));
                textView4.setText(num +" X 3 = " +(num * 3));
                textView5.setText(num +" X 4 = " +(num * 4));
                textView6.setText(num +" X 5 = " +(num * 5));
                textView7.setText(num +" X 6 = " +(num * 6));
                textView8.setText(num +" X 7 = " +(num * 7));
                textView9.setText(num +" X 8 = " +(num * 8));
                textView10.setText(num +" X 9 = " +(num * 9));
                textView11.setText(num +" X 10 = " +(num * 10));
            }
        });




    }
}