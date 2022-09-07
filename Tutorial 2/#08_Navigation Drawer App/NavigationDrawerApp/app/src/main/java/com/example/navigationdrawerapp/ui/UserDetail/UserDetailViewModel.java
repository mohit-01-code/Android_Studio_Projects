package com.example.navigationdrawerapp.ui.UserDetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserDetailViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserDetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}