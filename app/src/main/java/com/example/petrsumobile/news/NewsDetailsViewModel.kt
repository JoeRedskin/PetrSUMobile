package com.example.petrsumobile.news

import androidx.lifecycle.ViewModel

class NewsDetailsViewModel (id: Int, repository: NewsRepository) : ViewModel() {
    val currentNews = repository.getNews(id)
}