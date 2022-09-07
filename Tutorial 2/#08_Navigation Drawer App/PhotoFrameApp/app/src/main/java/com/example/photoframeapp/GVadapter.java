package com.example.photoframeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;

public class GVadapter extends ArrayAdapter<File> {
    ArrayList<File> filesArrayList;
    ImageView imageView;

    public GVadapter(@NonNull Context context, int resource, ArrayList<File> filesArrayList) {
        super(context,0, filesArrayList);
        this.filesArrayList=filesArrayList;
    }

    @Nullable
    @Override
    public File getItem(int position) {
        return filesArrayList.get(position);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        imageView = convertView.findViewById(R.id.imageView);

        Bitmap bm = BitmapFactory.decodeFile(String.valueOf(getItem(position)));
        imageView.setImageBitmap(bm);

        return convertView;
    }
}
