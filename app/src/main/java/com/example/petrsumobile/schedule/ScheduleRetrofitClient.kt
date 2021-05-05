package com.example.petrsumobile.schedule

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ScheduleRetrofitClient {
    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val retrofit: ScheduleService = Retrofit.Builder()
            .baseUrl("https://petrsu.egipti.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ScheduleService::class.java)
}