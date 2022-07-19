package com.example.noticiasdefutebol.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.noticiasdefutebol.dominio.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();
        List<News> news = new ArrayList<>();
        news.add(new News("a volta dos que n foram", "todinho caidowjcwijeiwbcebiwbeibciwe"));
        news.add(new News("os foram", "todinho prontowecwewewecwcwewececw"));
        news.add(new News("foram", "todinhowecewwewcweec"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> geNews() {
        return news;
    }
}