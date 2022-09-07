package com.example.navigationdrawerapp.ui.UserDetail;

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
import com.example.navigationdrawerapp.databinding.FragmentGalleryBinding;
import com.example.navigationdrawerapp.ui.Login.LoginFragment;

public class UserDetailFragment extends Fragment {

    private FragmentGalleryBinding binding;
    public TextView username, user_email;
    public Button logoutButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserDetailViewModel galleryViewModel =
                new ViewModelProvider(this).get(UserDetailViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        username = binding.username;
        user_email = binding.userEmail;
        logoutButton = binding.logout;


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                username.setText(getString(R.string.nav_header_title));
//                user_email.setText(getString(R.string.nav_header_subtitle));
            }
        });

        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}