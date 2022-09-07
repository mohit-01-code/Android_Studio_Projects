package com.example.navigationdrawerapp;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationdrawerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public EditText username, email; // login fragment details
    public Button login, chooseImage, logout;
    public TextView usernameText, emailText; // UserDetail fragement details
    public TextView headerText, headerEmail; //Header details
    public ImageView headerImage;



//    public void loginClick(View view){
//        username = view.findViewById(R.id.usernameEditText);
//        email = view.findViewById(R.id.emailEditText);
//
//        usernameText = view.findViewById(R.id.username);
//        emailText = view.findViewById(R.id.user_email);
//
//        headerText = view.findViewById(R.id.header_usernameText);
//        headerEmail = view.findViewById(R.id.header_emailtext);
//
//        headerImage = view.findViewById(R.id.header_image);
//
//        usernameText.setText(username.getText());
//        emailText.setText(email.getText());
//
//        headerText.setText(username.getText());
//        headerEmail.setText(email.getText());
//    }

    public void chooseImageClick(View view){

    }

//    public void logoutClick(View view){
//        headerText.setText(getString(R.string.nav_header_title));
//        headerEmail.setText(getString(R.string.nav_header_subtitle));
//        headerImage.setImageResource(R.drawable.gmail_user);
//
//        usernameText.setText(getString(R.string.nav_header_title));
//        emailText.setText(getString(R.string.nav_header_subtitle));
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_login, R.id.nav_userDetail)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        username = findViewById(R.id.usernameEditText);
        email = findViewById(R.id.emailEditText);

        usernameText = findViewById(R.id.username);
        emailText = findViewById(R.id.user_email);

        headerText = findViewById(R.id.header_usernameText);
        headerEmail = findViewById(R.id.header_emailtext);

        headerImage = findViewById(R.id.header_image);
        login = findViewById(R.id.loginButton);
        logout=findViewById(R.id.logout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameText.setText(username.getText());
        emailText.setText(email.getText());

//        headerText.setText(username.getText());
//        headerEmail.setText(email.getText());
            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}