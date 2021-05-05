package com.example.petrsumobile.schedule

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class ScheduleWeekType(
        @Expose
        val denominator : List<List<Schedule>>,
        @Expose
        val numerator : List<List<Schedule>>)

data class ScheduleWeek(var scheduleList: List<Schedule>,
                        var nameWeek: String)

@Entity
data class Schedule(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @Expose
        var classroom: String,
        @Expose
        @SerializedName("start_time")
        var startTime: String,
        @Expose
        @SerializedName("end_time")
        var endTime: String,
        @Expose
        var lecturer: String,
        @Expose
        var title: String,
        @Expose
        var type: String,
        @Expose
        var number: Int,
        @Expose
        var group: Int)