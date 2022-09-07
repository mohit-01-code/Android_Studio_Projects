package com.example.isangeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlaySong extends AppCompatActivity {
    TextView currentSongName, currentTime, TotalTime;
    ImageView pause, previous, next;
    MediaPlayer mediaPlayer;
    int position;
    SeekBar seekBar;
    Thread updateSeek;
    String textContent;

    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        updateSeek.interrupt();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        currentSongName = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        pause = findViewById(R.id.pause);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        currentTime = findViewById(R.id.textView2);
        TotalTime = findViewById(R.id.textView3);
        currentSongName.setSelected(true);

        //fetching data from Main Activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<File> songs = (ArrayList) bundle.getParcelableArrayList("songList");
        textContent = intent.getStringExtra("currentSong");
        currentSongName.setText(textContent);
        position = intent.getIntExtra("position", 0);

        //Playing song using Url
        playSong(songs);


        //Updating SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                int millisecond = i; //mediaPlayer.getCurrentPosition();
                String duration = songDuration(i);
                currentTime.setText(duration);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


        //event listeners on play/pause next previous
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    pause.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                } else {
                    pause.setImageResource(R.drawable.pause);
                    mediaPlayer.start();
                }
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPrevSong(songs);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playNextSong(songs);
            }
        });

    }

    public void playNextSong(ArrayList<File> songs){
        mediaPlayer.stop();
        mediaPlayer.release();
        if (position != songs.size() - 1) {
            position = position + 1;
        } else {
            position = 0;
        }
        playSong(songs);
    }
    public void playPrevSong(ArrayList<File> songs){
        mediaPlayer.stop();
        mediaPlayer.release();
        if (position != 0) {
            position = position - 1;
        } else {
            position = songs.size() - 1;
        }
        playSong(songs);
    }
    public void playSong(ArrayList<File> songs){
        Uri uri = Uri.parse(songs.get(position).toString());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
        mediaPlayer.start();
        pause.setImageResource(R.drawable.pause);
        seekBar.setMax(mediaPlayer.getDuration());
        textContent = songs.get(position).getName().toString();
        currentSongName.setText(textContent);
//        updateSeek.start();
        TotalTime.setText(songDuration(mediaPlayer.getDuration()));

        updateSeek = new Thread() {
            @Override
            public void run() {
                int currentPosition = 0;
                try {
                    while (currentPosition < mediaPlayer.getDuration()) {
                        currentPosition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        sleep(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        updateSeek.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playNextSong(songs);
            }
        });
    }
    public String songDuration(int millisecond){
        String duration = "";
        if (millisecond != 0) {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(millisecond);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisecond);
            if (minutes == 0) {
                duration = "0:" + seconds;
            } else {
                if (seconds >= 60) {
                    long sec = seconds - (minutes * 60);
                    duration = minutes + ":" + sec;
                }
            }
        } else {
            int totalTime = mediaPlayer.getDuration();
            long minutes = TimeUnit.MILLISECONDS.toMinutes(totalTime);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(totalTime);

            if (minutes == 0) {
                duration = "0:" + seconds;
            } else {
                if (seconds >= 60) {
                    long sec = seconds - (minutes * 60);
                    duration = minutes + ":" + sec;
                }
            }
        }
        return duration;
    }
}