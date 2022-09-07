package com.example.musiclistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hii";
    int[] songs;
    MediaPlayer mediaPlayer;
    int current_index = 0;
    SeekBar seekBar;
    ImageView imageView10;
    ImageView play;
    ImageView pause;
    TextView textView9;
    TextView textView8, song_duration, total_duration;
    ImageButton playAll;
    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    Button button;
    Thread updateSeek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songs = new int[]{R.raw.bekhyali_1, R.raw.kaise_hua_2, R.raw.tujhe_kitna_chahne_lage_3, R.raw.mere_sohneya_4, R.raw.tera_ban_jaunga_5};

        seekBar = findViewById(R.id.seekBar2);
        imageView10 = findViewById(R.id.imageView10);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        playAll = findViewById(R.id.playAll);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        song_duration = findViewById(R.id.song_duration);
        total_duration = findViewById(R.id.total_duration);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mp3SongList.class);
                startActivity(intent);
            }
        });

        mediaPlayer = MediaPlayer.create(this, songs[0]);
        mediaPlayer.setOnCompletionListener(this::onCompletion);

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(0);
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(1);
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(2);
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(3);
            }
        });
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(4);
            }
        });

        playAllClick(playAll, mediaPlayer);
        playPause(play, mediaPlayer);
        playPause(pause, mediaPlayer);
        setSeekBar(seekBar);


    }

    public void setSeekBar(SeekBar seekBar) {
        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                if (b)
//                    mediaPlayer.seekTo(i);
                song_duration.setText(songDuration(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

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
    }

    public void onCompletion(MediaPlayer mp) {
        play();
    }

    public void play() {
        current_index = (current_index + 1) % 5;
        AssetFileDescriptor afd = this.getResources().openRawResourceFd(songs[current_index]);

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
            setSeekBar(seekBar);
            MyData data = new MyData();
            total_duration.setText(songDuration(mediaPlayer.getDuration()));

            imageView10.setImageResource(data.imageViews[current_index]);
            textView9.setText(data.song_name[current_index]);
            textView8.setText(data.artist_name[current_index]);

            playPause(play, mediaPlayer);
            playPause(pause, mediaPlayer);
            playAllClick(playAll, mediaPlayer);

            afd.close();
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        } catch (IllegalStateException e) {
            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        } catch (IOException e) {
            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        }
    }

    public void play(int i) {
        AssetFileDescriptor afd = this.getResources().openRawResourceFd(songs[i]);
        current_index = i;
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
            setSeekBar(seekBar);
            MyData data = new MyData();
            total_duration.setText(songDuration(mediaPlayer.getDuration()));

            imageView10.setImageResource(data.imageViews[i]);
            textView9.setText(data.song_name[i]);
            textView8.setText(data.artist_name[i]);

            playPause(play, mediaPlayer);
            playPause(pause, mediaPlayer);
            playAllClick(playAll, mediaPlayer);

            afd.close();
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        } catch (IllegalStateException e) {
            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        } catch (IOException e) {
            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        }
    }

    public void playPause(View view, MediaPlayer mp) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying())
                    mp.pause();
                else
                    mp.start();
            }
        });
    }

    public void playAllClick(View view, MediaPlayer mp) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_index = 0;
                mp.start();
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