package com.example.noticiasdefutebol.ui.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.noticiasdefutebol.MainActivity;
import com.example.noticiasdefutebol.data.AppDatabase;
import com.example.noticiasdefutebol.databinding.FragmentNewsBinding;
import com.example.noticiasdefutebol.ui.adapter.NewsAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel newsViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
        newsViewModel.getNews().observe(getViewLifecycleOwner(), news -> {
            binding.recyclerViewNews.setAdapter(new NewsAdapter(news, favoritedNews -> {
                MainActivity activity = (MainActivity) getActivity();
                if (activity != null) {
                    activity.getDb().newsDao().save(favoritedNews);
                }
            }));
        });

        newsViewModel.getState().observe(getViewLifecycleOwner(),state->{
            switch (state){
                case DOING:
                    //TODO: incluir swiperRefre
                    break;
                case DONE:
                    //TODO: incluir swiperRefre
                    break;
                case ERROR:
                    //TODO: incluir swiperRefre
                    //TODO: incluir error
                    break;
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}