package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private TextView textView;
    private ImageButton play;
    private ImageButton pause;
    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        seekBar = findViewById(R.id.seekBar);
        imageView = findViewById(R.id.imageView);

//        playing local music
//        mediaPlayer = MediaPlayer.create(this, R.raw.on);
//        setSeekBar(seekBar);


//        playing music from web
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://themamaship.com/music/Catalog/Don't%20Let%20Me%20Down%20-%20The%20Chainsmokers%20ft.%20Daya.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImageResource(R.drawable.dont_img);
        textView.setText(R.string.song_name_2);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this, "Ready to Play", Toast.LENGTH_SHORT).show();
//                mediaPlayer.start();
                setSeekBar(seekBar);
            }
        });
        mediaPlayer.prepareAsync();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                if (mediaPlayer.isPlaying()) {
                } else
                    Toast.makeText(MainActivity.this, "Please Check your Internet connection", Toast.LENGTH_SHORT).show();

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
    }

    public void setSeekBar(SeekBar seekBar) {
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b)
                    mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}