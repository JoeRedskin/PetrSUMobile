package com.example.petrsumobile.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsViewModel(
        private val repository: NewsRepository
) : ViewModel() {

    val newsList = repository.getAllNews()

    fun fetchNews() {
        viewModelScope.launch {
            repository.fetchNews()
        }
    }

    fun deleteNews() {
        viewModelScope.launch {
            repository.deleteNews()
        }
    }
}