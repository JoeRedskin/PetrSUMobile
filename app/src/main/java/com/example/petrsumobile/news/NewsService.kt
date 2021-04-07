package com.example.petrsumobile.news

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET()
    fun getNews(): Call<ArrayList<News>>
}