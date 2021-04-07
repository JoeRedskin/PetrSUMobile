//package com.example.petrsumobile.news
//
//import android.content.Context
//import androidx.loader.content.AsyncTaskLoader
//import com.example.petrsumobile.DataQuery
//import java.util.*
//
//class NewsLoader(context: Context?) : AsyncTaskLoader<ArrayList<News>>(context!!) {
//    override fun onStartLoading() {
//        forceLoad()
//    }
//
//    override fun loadInBackground(): ArrayList<News> {
//        return DataQuery.fetchNewsData()
//    }
//
//}