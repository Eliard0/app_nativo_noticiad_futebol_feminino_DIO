package com.example.noticiasdefutebol.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noticiasdefutebol.databinding.NewsItensBinding;
import com.example.noticiasdefutebol.dominio.News;

import java.util.List;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;

    public NewsAdapter(List<News> news){
        this.news = news;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInFlater = LayoutInflater.from(parent.getContext());
        NewsItensBinding binding = NewsItensBinding.inflate(layoutInFlater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = this.news.get(position);
        holder.binding.tvTitulo.setText(news.getTitulo());
        holder.binding.tvDescricao.setText(news.getDescricao());

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final NewsItensBinding binding;

        public ViewHolder(NewsItensBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
