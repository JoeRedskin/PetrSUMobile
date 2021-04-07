package com.example.petrsumobile.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class NewsViewModel constructor(
        private val newsRepository: NewsRepository
) : ViewModel() {

    val newsList = newsRepository.getNews()
}