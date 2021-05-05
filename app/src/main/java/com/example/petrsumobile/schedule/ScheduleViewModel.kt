package com.example.petrsumobile.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ScheduleViewModel(
        private val repository: ScheduleRepository
) : ViewModel() {

    var scheduleWeekType = MutableLiveData<ScheduleWeekType?>()

    fun fetchSchedule(groupId: String){
        viewModelScope.launch {
            val result = repository.fetchSchedule(groupId)
            scheduleWeekType.value = result
        }
    }
}