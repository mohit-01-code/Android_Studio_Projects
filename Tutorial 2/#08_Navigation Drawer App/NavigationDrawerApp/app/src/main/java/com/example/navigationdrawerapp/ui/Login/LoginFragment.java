package com.example.navigationdrawerapp.ui.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawerapp.MainActivity;
import com.example.navigationdrawerapp.R;
import com.example.navigationdrawerapp.databinding.FragmentHomeBinding;
import com.example.navigationdrawerapp.ui.UserDetail.UserDetailFragment;

public class LoginFragment extends Fragment {

    private FragmentHomeBinding binding;
    public EditText usernameEditText, emailEditText;
    public Button loginButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel homeViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        Button login = binding.loginButton;
        usernameEditText = binding.usernameEditText;
        emailEditText = binding.emailEditText;
        loginButton = binding.loginButton;

        UserDetailFragment userDetailFragment = new UserDetailFragment();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                userDetailFragment.username.setText(usernameEditText.getText());
//                userDetailFragment.user_email.setText(emailEditText.getText());
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}