package com.normapp.ui.equipos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EquiposViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EquiposViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is equipos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}