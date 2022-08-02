package com.example.noticiasdefutebol.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.noticiasdefutebol.dominio.News;

import java.util.List;

@Dao
public interface NewsDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(News news);

        @Query("SELECT * FROM news WHERE favorite = 1")
        List<News>loadFavoriteNews();
}