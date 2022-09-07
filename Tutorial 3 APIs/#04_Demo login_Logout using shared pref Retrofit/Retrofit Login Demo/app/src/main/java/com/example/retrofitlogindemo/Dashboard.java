package com.example.retrofitlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView textView;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textView = findViewById(R.id.textView);
        logout = findViewById(R.id.logout);

        checkUserAccess();
    }

    private void checkUserAccess() {
        SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
        if(sp.contains("username") && sp.contains("password"))
            textView.setText(sp.getString("username", "No data to display"));
        else
            startActivity(new Intent(Dashboard.this, MainActivity.class));
    }

    public void logoutClick(View view) {
        SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
        sp.edit().remove("username").apply();
        sp.edit().remove("password").apply();
        sp.edit().apply();
        startActivity(new Intent(Dashboard.this, MainActivity.class));
        finish();
    }
}