package com.example.petrsumobile.news

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitClient {

    private const val RSS_NEWS_URL = "https://petrsu.ru/rss"
    val retrofit: NewsService = Retrofit.Builder()
            .baseUrl(RSS_NEWS_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(NewsService::class.java)
}