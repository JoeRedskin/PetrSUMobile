package com.example.petrsumobile.news

import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository constructor(
        private val newsService: NewsService,
) {

    fun getNews(): LiveData<List<News>> {

        var newsList = ArrayList<News>()
        newsService.getNews().enqueue(object : Callback<ArrayList<News>> {
            override fun onFailure(call: Call<ArrayList<News>>, t: Throwable) {
                Log.e("TAG", t.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<News>>, response: Response<ArrayList<News>>) {
                newsList = response.body()!!
                print(newsList)
            }
        })
        return newsList
    }
}