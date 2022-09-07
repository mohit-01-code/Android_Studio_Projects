package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SurfaceView surfaceView;
    private SeekBar seekBar;
    private Button button;
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView2;
    private SeekBar seekBar2;
    private Button button2;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = findViewById(R.id.surfaceView);
        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);
        surfaceView2 = findViewById(R.id.surfaceView2);
        seekBar2 = findViewById(R.id.seekBar2);
        button2 = findViewById(R.id.button2);

        mediaPlayer = MediaPlayer.create(this, R.raw.my_vid);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.my_vid2);

        setSeekBar(seekBar, mediaPlayer);
        setSeekBar(seekBar2, mediaPlayer2);

        setSurface(surfaceView, mediaPlayer);
        setSurface(surfaceView2, mediaPlayer2);

        mediaPlayer.start();
        mediaPlayer.pause();
        mediaPlayer2.start();
        mediaPlayer2.pause();

        buttonClick(button, button2, mediaPlayer, mediaPlayer2);
        buttonClick(button2, button, mediaPlayer2, mediaPlayer);

    }

    public void setSurface(SurfaceView surfaceView, MediaPlayer mediaPlayer) {
        surfaceView.getKeepScreenOn();
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });

    }

    public void setSeekBar(SeekBar seekBar, MediaPlayer mediaPlayer) {
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

    public void buttonClick(Button mainBtn, Button secondBtn, MediaPlayer mainMp, MediaPlayer secondMp) {
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainMp.isPlaying()) {
                    mainMp.pause();
                    mainBtn.setText("Play");
                } else {
                    mainMp.start();
                    secondMp.pause();
                    secondBtn.setText("Play");
                    mainBtn.setText("Pause");
                }
            }
        });
    }
}