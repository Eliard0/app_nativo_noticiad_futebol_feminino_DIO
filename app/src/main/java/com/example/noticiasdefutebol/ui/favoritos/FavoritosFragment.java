package com.example.noticiasdefutebol.ui.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.noticiasdefutebol.MainActivity;
import com.example.noticiasdefutebol.databinding.FragmentFavoritosBinding;
import com.example.noticiasdefutebol.dominio.News;
import com.example.noticiasdefutebol.ui.adapter.NewsAdapter;

import java.util.List;

public class FavoritosFragment extends Fragment {

    private FragmentFavoritosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoritosViewModel favoritosViewModel =
                new ViewModelProvider(this).get(FavoritosViewModel.class);

        binding = FragmentFavoritosBinding.inflate(inflater, container, false);

        loadFindFavoriteNews();
        return binding.getRoot();
    }

    private void loadFindFavoriteNews() {
        MainActivity activity = (MainActivity) getActivity();
        if(activity != null) {
            List<News> favoriteNews = activity.getDb().newsDao().loadFavoriteNews();
            binding.recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerViewNews.setAdapter(new NewsAdapter(favoriteNews, updateNews -> {
                activity.getDb().newsDao().save(updateNews);
                loadFindFavoriteNews();
            }));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}