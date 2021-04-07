//package com.example.petrsumobile.schedule
//
//import android.content.Context
//import androidx.loader.content.AsyncTaskLoader
//import com.example.petrsumobile.DataQuery
//import java.util.*
//
//class ScheduleLoader(context: Context, private val urlString: String?) : AsyncTaskLoader<ArrayList<ScheduleWeekType>?>(context) {
//    override fun onStartLoading() {
//        forceLoad()
//    }
//
//    override fun loadInBackground(): ArrayList<ScheduleWeekType>? {
//        return if (urlString == null) {
//            null
//        } else DataQuery.fetchScheduleData(urlString)
//
//        //String url = "https://petrsu.egipti.com/api/v2/schedule/22407";
//    }
//}