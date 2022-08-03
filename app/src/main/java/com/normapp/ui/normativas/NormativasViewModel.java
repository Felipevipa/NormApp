package com.normapp.ui.normativas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NormativasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NormativasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is normativas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}