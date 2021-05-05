package com.example.petrsumobile

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.petrsumobile.news.News
import com.example.petrsumobile.news.NewsDao
import com.example.petrsumobile.schedule.Schedule
import com.example.petrsumobile.schedule.ScheduleDao

@Database(entities = [News::class], version = 2)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao
}

@Database(entities = [Schedule::class], version = 1)
abstract class ScheduleDatabase : RoomDatabase() {
    abstract val scheduleDao: ScheduleDao
}