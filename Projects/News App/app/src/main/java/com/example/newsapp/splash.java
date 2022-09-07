package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Thread thread = new Thread(){
//            public void run(){
//                try{
//                    sleep(4000);
//                }catch(Exception e){
//                    e.printStackTrace();
//                }finally{
//                    Intent intent = new Intent(splash.this, MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };
//        thread.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(splash.this,
                        MainActivity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, 4000);
    }
}