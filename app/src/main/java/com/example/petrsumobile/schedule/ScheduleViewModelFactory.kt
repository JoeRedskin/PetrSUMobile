package com.example.petrsumobile.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.petrsumobile.news.NewsDetailsViewModel
import com.example.petrsumobile.news.NewsRepository

class ScheduleViewModelFactory (private val repository: ScheduleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            return ScheduleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}