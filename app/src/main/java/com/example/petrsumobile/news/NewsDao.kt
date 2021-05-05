package com.example.petrsumobile.news

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NewsDao {
    // Добавление News в бд
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: News)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(newsList: List<News>)

    // Удаление News из бд
    @Delete
    suspend fun delete(news: News)

    // Удаление всех данных из бд
    @Query("DELETE FROM news")
    suspend fun deleteAll()

    // Получение News по id
    @Query("SELECT * FROM news WHERE id = :id")
    fun getNews(id: Int): LiveData<News>

    // Получение всех City из бд
    @get:Query("SELECT * FROM news ORDER BY id DESC")
    val getAllNews: LiveData<List<News>>
}