package com.example.petrsumobile.schedule

import android.util.Log

class ScheduleRepository(
        private val scheduleService: ScheduleService,
        private val scheduleDao: ScheduleDao
) {

//    fun getSchedule(): LiveData<List<News>> {
//        return scheduleDao.getSchedule
//    }


//    suspend fun deleteNews() {
//        scheduleDao.deleteAll()
//    }

    suspend fun fetchSchedule(groupId: String): ScheduleWeekType?{
        var result: ScheduleWeekType? = null
        return try {
            Log.d("TAG", "Fetch news")
            result = scheduleService.fetchSchedule(groupId)
            Log.d("TAG", result.toString())
            result
//            scheduleDao.insertAll(result.newsList)

        } catch (t: Throwable) {
            Log.e("TAG", t.message.toString())
            result
        }
    }
}