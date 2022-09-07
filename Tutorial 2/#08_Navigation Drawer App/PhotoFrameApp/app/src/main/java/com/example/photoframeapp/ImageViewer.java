package com.example.photoframeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class ImageViewer extends AppCompatActivity {
    int position;
    ImageView previewImage;
    Button next, prev;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        previewImage = findViewById(R.id.previewImage);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);

        MainActivity mainActivity = new MainActivity();

        ArrayList<File> images = mainActivity.fetchImages(Environment.getExternalStorageDirectory());


        //fetching data from Main Activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        File picture = (File)getIntent().getExtras().get("picture");
        position = intent.getIntExtra("position", 0);
        setImage(previewImage, picture);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != images.size() - 1) {
                    position = position + 1;
                } else {
                    position = 0;
                }
                setImage(previewImage, images.get(position));
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != 0) {
                    position = position - 1;
                } else {
                    position = images.size() - 1;
                }
                setImage(previewImage, images.get(position));
            }
        });

    }

    public void setImage(ImageView imageView, File file){
        Bitmap bm = BitmapFactory.decodeFile(String.valueOf(file));
        imageView.setImageBitmap(bm);
        textView = findViewById(R.id.textView);
        textView.setText(file.getName().toString());

    }
}