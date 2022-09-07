package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private EditText editTextNumber2;
    private Button button;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.button);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                String s1 = editTextNumber.getText().toString();
                String s2 = editTextNumber2.getText().toString();
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                textView3.setBackgroundColor(R.color.cool);
                textView3.setText(a + " + " + b + " = " + (a + b));

                textView4.setBackgroundColor(R.color.cool);
                textView4.setText(a + " - " + b + " = " + (a - b));

                textView5.setBackgroundColor(R.color.cool);
                textView5.setText(a + " * " + b + " = " + (a * b));

                textView6.setBackgroundColor(R.color.cool);
                textView6.setText(a + " / " + b + " = " + (a / b));


            }
        });


    }
}