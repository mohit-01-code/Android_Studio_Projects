package com.example.retrofitlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText mUsername, mPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        login = findViewById(R.id.login);

        userAccess();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyUser(mUsername.getText().toString().trim(), mPassword.getText().toString().trim());
            }
        });
    }

    public void verifyUser(String username, String password){
        Call<Model> call = ApiController.getInstance()
                .getApi()
                .verifyUser(username, password);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                mUsername.setText("");
                mPassword.setText("");
                Model data = response.body();
                String message = data.getMessage();
                if(message.equals("false"))
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                if(message.equals("true")){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, Dashboard.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                mUsername.setText("");
                mPassword.setText("");
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void userAccess(){
        SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
        if(sp.contains("username") && sp.contains("password"))
            startActivity(new Intent(MainActivity.this, Dashboard.class));
    }
}