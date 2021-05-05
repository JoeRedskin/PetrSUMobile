package com.example.petrsumobile.news

import android.util.Log
import androidx.lifecycle.LiveData

class NewsRepository (
        private val newsService: NewsService,
        private val newsDao: NewsDao
) {

    fun getAllNews(): LiveData<List<News>> {
        return newsDao.getAllNews
    }

    fun getNews(id: Int): LiveData<News> {
        return newsDao.getNews(id)
    }

    suspend fun deleteNews() {
        newsDao.deleteAll()
    }

    suspend fun fetchNews() {
        try {
            Log.d("TAG","Fetch news")
            val result = newsService.getNews("https://petrsu.ru/rss")
            Log.d("TAG",result.newsList.toString())
            newsDao.insertAll(result.newsList)

        } catch (t: Throwable) {
            Log.e("TAG", t.message.toString())
        }
    }

    companion object {
        const val BASE_SITE = "https://petrsu.ru/rss"
    }
}