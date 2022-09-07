package com.example.photoframeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        cardView = findViewById(R.id.cardView);
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        ArrayList<File> myImages = fetchImages(Environment.getExternalStorageDirectory());
                        String[] items = new String[myImages.size()];
                        for (int i = 0; i < myImages.size(); i++) {
                            items[i] = myImages.get(i).getName();
                        }

                        GVadapter adapter = new GVadapter(MainActivity.this, R.layout.card_item, myImages);
                        gridView.setAdapter(adapter);

                        //Switching to the new activity
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                Intent intent = new Intent(MainActivity.this, ImageViewer.class);
                                intent.putExtra("picture", myImages.get(position)); //throwing runtime error...
                                intent.putExtra("position", position);
                                startActivity(intent);
                            }
                        });

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                }).check();

    }

    //fetching all mp3 files from storage
    public ArrayList<File> fetchImages(File file) {
        ArrayList imageUrlList = new ArrayList();
        File[] images = file.listFiles();
        //recursively iterating files and getting mp3 files
        if (images != null) {
            for (File imageUrl : images) {
                if (!imageUrl.isHidden() && imageUrl.isDirectory()) {
                   imageUrlList.addAll(fetchImages(imageUrl));
                } else {
                    if(!imageUrl.getName().startsWith(".")) {
                        if (imageUrl.getName().endsWith(".jpg") || imageUrl.getName().endsWith(".png")) {
                            imageUrlList.add(imageUrl);
                        }
                    }
                }
            }
        }
        return imageUrlList;
    }

}