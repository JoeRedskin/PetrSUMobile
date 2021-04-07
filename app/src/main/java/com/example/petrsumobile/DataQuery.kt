//package com.example.petrsumobile
//
//import android.util.Log
//import com.example.petrsumobile.news.News
//import com.example.petrsumobile.schedule.Schedule
//import com.example.petrsumobile.schedule.ScheduleWeek
//import com.example.petrsumobile.schedule.ScheduleWeekType
//import org.json.JSONObject
//import org.w3c.dom.Element
//import java.io.BufferedReader
//import java.io.IOException
//import java.io.InputStream
//import java.io.InputStreamReader
//import java.net.HttpURLConnection
//import java.net.URL
//import java.nio.charset.StandardCharsets
//import java.util.*
//import javax.xml.parsers.DocumentBuilderFactory
//
//object DataQuery {
//
//    fun fetchNewsData(): ArrayList<News> {
//        val RSS_NEWS_URL = "https://petrsu.ru/rss"
//        val newsArrayList = ArrayList<News>()
//        try {
//            val url = URL(RSS_NEWS_URL)
//            val httpURLConnection = url.openConnection() as HttpURLConnection
//            if (httpURLConnection.responseCode == HttpURLConnection.HTTP_OK) {
//                val inputStream = httpURLConnection.inputStream
//                val dbf = DocumentBuilderFactory.newInstance()
//                val db = dbf.newDocumentBuilder()
//                val document = db.parse(inputStream)
//                val element = document.documentElement
//                val nodeList = element.getElementsByTagName("item")
//                if (nodeList.length > 0) {
//                    for (i in 0..nodeList.length - 1) {
//                        val entry = nodeList.item(i) as Element
//                        val _titleE = entry.getElementsByTagName("title").item(0) as Element
//                        val _descriptionE = entry.getElementsByTagName("description").item(0) as Element
//                        val _pubDateE = entry.getElementsByTagName("pubDate").item(0) as Element
//                        val _linkE = entry.getElementsByTagName("link").item(0) as Element
//                        val _imageURL = entry.getElementsByTagName("enclosure").item(0) as Element
//                        val _title = _titleE.firstChild.nodeValue
//                        val _description = _descriptionE.firstChild.nodeValue
//                        val _pubDate = Date(_pubDateE.firstChild.nodeValue)
//                        val _link = _linkE.firstChild.nodeValue
//                        val _imageULR = _imageURL.getAttribute("url").replace("http", "https")
//                        val news = News(_title, _description, _pubDate, _link, _imageULR)
//                        newsArrayList.add(news)
//                        //                        Log.d("newsList",newsArrayList.get(i).getNewsImageURL());
//                    }
//                }
//            }
//        } catch (e: Exception) {
//            //e.printStackTrace();
//            Log.e("NewsLoader", "Problem parsing the news RSS results", e)
//        }
//        return newsArrayList
//    }
//
//    /*fun fetchScheduleData(stringUrl: String?): ArrayList<ScheduleWeekType> {
//
//        //String JSON_SCHEDULE_URL = "https://petrsu.ru/rss";
//        val scheduleWeekTypeArrayList = ArrayList<ScheduleWeekType>()
//        val weekNames = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")
//        val weekTypes = arrayOf("denominator", "numerator")
//        try {
//            val url = URL(stringUrl)
//            val httpURLConnection = url.openConnection() as HttpURLConnection
//            //httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.requestMethod = "GET"
//            httpURLConnection.connect()
//            if (httpURLConnection.responseCode == HttpURLConnection.HTTP_OK) {
//                val inputStream = httpURLConnection.inputStream
//                val jsonResponse = readFromStream(inputStream)
//                val baseJsonResponse = JSONObject(jsonResponse)
//                // JSONObject scheduleWeekdayObject = baseJsonResponse.getJSONObject("denominator");
//                for (weekType in weekTypes) {
//                    val scheduleWeeks = ArrayList<ScheduleWeek>()
//                    val scheduleWeekTypeJson = baseJsonResponse.getJSONArray(weekType)
//                    for (i in 0 until scheduleWeekTypeJson.length()) {
//                        val scheduleArrayList = ArrayList<Schedule>()
//                        val day = scheduleWeekTypeJson.getJSONArray(i)
//                        if (day.length() != 0) {
//                            for (j in 0 until day.length()) {
//                                val lesson = day.getJSONObject(j)
//                                val classroom = lesson.getString("classroom")
//                                val startTime = lesson.getString("start_time")
//                                val endTime = lesson.getString("end_time")
//                                val lecturer = lesson.getString("lecturer")
//                                val title = lesson.getString("title")
//                                val type = lesson.getString("type")
//                                val number = lesson.getInt("number")
//                                val schedule = Schedule(classroom, startTime, endTime, lecturer, title, type, number)
//                                scheduleArrayList.add(schedule)
//                                //Log.d(LOG_TAG,classroom);
//                            }
//                            val scheduleWeek = ScheduleWeek(scheduleArrayList, weekNames[i])
//                            scheduleWeeks.add(scheduleWeek)
//                        }
//                    }
//                    val scheduleWeekType = ScheduleWeekType(scheduleWeeks, weekType)
//                    scheduleWeekTypeArrayList.add(scheduleWeekType)
//                }
//            }
//        } catch (e: Exception) {
//            //e.printStackTrace();
//            Log.e("fetchScheduleData", "Problem parsing the schedule JSON results", e)
//        }
//        return scheduleWeekTypeArrayList
//    }
//
//    @Throws(IOException::class)
//    private fun readFromStream(inputStream: InputStream?): String {
//        val output = StringBuilder()
//        if (inputStream != null) {
//            val inputStreamReader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
//            val reader = BufferedReader(inputStreamReader)
//            var line = reader.readLine()
//            while (line != null) {
//                output.append(line)
//                line = reader.readLine()
//            }
//        }
//        return output.toString()
//    }*/
//}