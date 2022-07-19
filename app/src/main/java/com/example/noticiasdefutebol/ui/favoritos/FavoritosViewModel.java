package com.example.noticiasdefutebol.ui.favoritos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FavoritosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Favorito");
    }

    public LiveData<String> getText() {
        return mText;
    }
}