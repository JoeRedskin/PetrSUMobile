package com.example.petrsumobile.schedule

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.petrsumobile.news.News

@Dao
interface ScheduleDao {
//    // Добавление News в бд
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(news: News)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(newsList: List<News>)

//    // Удаление News из бд
//    @Delete
//    suspend fun delete(news: News)
//
//    // Удаление всех данных из бд
//    @Query("DELETE FROM schedule")
//    suspend fun deleteAll()
//
//    // Получение News по id
//    @Query("SELECT * FROM schedule WHERE id = :id")
//    fun getNews(id: Int): LiveData<News>

    // Получение всех City из бд
//    @get:Query("SELECT * FROM schedule ORDER BY id DESC")
//    val getSchedule: LiveData<List<Schedule>>
}