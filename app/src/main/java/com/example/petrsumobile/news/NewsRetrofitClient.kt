package com.example.petrsumobile.news

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object NewsRetrofitClient {
    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val retrofit: NewsService = Retrofit.Builder()
            .baseUrl("https://api.rss2json.com/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(NewsService::class.java)
}