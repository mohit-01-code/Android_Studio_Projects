package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name", text);
                ed.apply();
//                textView.setText(text);
//                SharedPreferences sp2 = getSharedPreferences("Message", MODE_PRIVATE);
                String s = sp.getString("name", "No Data to Display");
                textView.setText(s);
            }
        });
        SharedPreferences sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        String s = sp.getString("name", "No Data to Display");
        textView.setText(s);
    }
}