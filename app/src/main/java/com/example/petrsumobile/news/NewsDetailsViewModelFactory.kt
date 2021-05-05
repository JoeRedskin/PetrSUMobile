package com.example.petrsumobile.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsDetailsViewModelFactory(private val id: Int, private val repository: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsDetailsViewModel::class.java)) {
            return NewsDetailsViewModel(id, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}