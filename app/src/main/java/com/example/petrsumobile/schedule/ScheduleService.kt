package com.example.petrsumobile.schedule

import com.example.petrsumobile.news.NewsList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ScheduleService {
    @GET("schedule/{group}")
    suspend fun fetchSchedule(@Path("group") groupId: String): ScheduleWeekType
}