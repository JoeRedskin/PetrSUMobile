//package com.example.petrsumobile.news
//
//import android.app.Activity
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.TextView
//import com.example.petrsumobile.R
//import java.util.*
//
//class NewsDetailsAdapter(context: Activity, news: ArrayList<News>) : ArrayAdapter<News>(context, 0, news) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var listItemView = convertView
//        if (listItemView == null) {
//            listItemView = LayoutInflater.from(context).inflate(
//                    R.layout.news_list_item, parent, false)
//        }
//        val currentNews = getItem(position)
//        val titleTextView = listItemView!!.findViewById<View>(R.id.textViewTitleDetails) as TextView
//        titleTextView.text = currentNews?.title ?: ""
//        val descriptionTextView = listItemView.findViewById<View>(R.id.textViewDescriptionDetails) as TextView
//        descriptionTextView.text = currentNews?.description ?: ""
//        val dateTextView = listItemView.findViewById<View>(R.id.textViewDateDetails) as TextView
//        dateTextView.text = currentNews?.date.toString()
//
//
//        /* ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
//        iconView.setImageResource(currentAndroidFlavor.getImageResourceId()); */
//        return listItemView
//    }
//}