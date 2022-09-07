package com.example.listviewapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCustomAdapter extends ArrayAdapter<String> {
    public static final String EXTRA_DATA = "com.example.listviewapp.extra.data";
    public static final String EXTRA_DATA_2 = "com.example.listviewapp.extra.data2";
    private String[] arr;
    private String[] arr2;
//    private String[] arr2 = {"+91 9125680243", "+91 8140620819", "+91 6356417303", "+91 7041232430", "+91 9680165108", "+91 7069101537", "+91 7874009400", "+91 9999702027", "+91 7260850282", "+91 9810365389", "+91 75698961125", "+91 9125764366"};
    private Context context;
    private TextView textView;
    private ImageButton imageButton;
    private LinearLayout linearLayout;

    public MyCustomAdapter(@NonNull Context context, int resource, @NonNull MyData data) {
        super(context, resource, data.arr1);
        this.context = context;
        this.arr = data.arr1;
        this.arr2 = data.arr2;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_custom_layout, parent, false);
        textView = convertView.findViewById(R.id.textView);
        imageButton = convertView.findViewById(R.id.imageButton);
        linearLayout = convertView.findViewById(R.id.linearLayout);
        textView.setText(getItem(position));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Calling...", Toast.LENGTH_SHORT).show();
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Calling..." + getItem(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra(EXTRA_DATA, getItem(position));
                intent.putExtra(EXTRA_DATA_2, arr2[position]);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

}