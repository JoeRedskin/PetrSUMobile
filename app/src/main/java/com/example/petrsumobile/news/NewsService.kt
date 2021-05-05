package com.example.petrsumobile.news

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("api.json")
    suspend fun getNews(@Query("rss_url") cityQuery: String): NewsList
}