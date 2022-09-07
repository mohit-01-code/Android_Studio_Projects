package com.example.additionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private EditText editTextNumber2;
    private TextView textView2;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private TextView textView4;
    private Button button;
    int ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textView2 = findViewById(R.id.textView2);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button = findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView2.setText("+");
                ans = cal(1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView2.setText("-");
                ans = cal(2);
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView2.setText("*");
                ans = cal(3);
            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView2.setText("/");
                ans = cal(4);
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView4.setText(ans);
            }
        });
    }
        public int cal(int chk){
            String s1 = editTextNumber.getText().toString();
            String s2 = editTextNumber2.getText().toString();
            if(chk==1)
            return Integer.parseInt(s1) + Integer.parseInt(s2);
            else if(chk == 2)
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            else if(chk == 3)
                return Integer.parseInt(s1) * Integer.parseInt(s2);
            else if(chk == 4)
                return Integer.parseInt(s1) / Integer.parseInt(s2);
            else{
                Toast.makeText(this, "Some Error Occured", Toast.LENGTH_SHORT).show();
                return 0;
            }
        }
}