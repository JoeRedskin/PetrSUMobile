package com.example.petrsumobile.news

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petrsumobile.R
import com.example.petrsumobile.news.NewsAdapter.MyViewHolder
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter(private val newsList: ArrayList<News>/*, private val onItemClickListener: OnItemClickListener*/) : RecyclerView.Adapter<MyViewHolder>() {
//    interface OnItemClickListener {
//        fun onItemClicked(position: Int, news: News)
//    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById<View>(R.id.textViewTitleDetails) as TextView
        val textViewDescription: TextView = itemView.findViewById<View>(R.id.textViewDescriptionDetails) as TextView
        val textViewDate: TextView = itemView.findViewById<View>(R.id.textViewDateDetails) as TextView
        val imageView: ImageView = itemView.findViewById<View>(R.id.imageViewNews) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, listPosition: Int) {
        val textViewTitle = holder.textViewTitle
        val textViewDescription = holder.textViewDescription
        val textViewDate = holder.textViewDate
        val imageView = holder.imageView
        val formattedDate = formatDate(newsList[listPosition].date)
        textViewTitle.text = newsList[listPosition].title
        textViewDescription.text = newsList[listPosition].description
        textViewDate.text = formattedDate
        val imageViewURL = newsList[listPosition].imageUrl
        holder.itemView.setOnClickListener { view ->
            val activity = view.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction()
//            val transaction = activity.supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.frame_container, NewsDetailsFragment())
//            transaction.addToBackStack(null)
//            transaction.commit()
//            onItemClickListener.onItemClicked(listPosition, newsList[listPosition])
        }
//        Glide.with(holder.)
//                .load(imageViewURL)
//                .centerCrop() //                .skipMemoryCache(true)
//                //                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .placeholder(R.drawable.ic_placeholder)
//                .into(imageView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    private fun formatDate(dateObject: Date): String {
        val dateFormat = SimpleDateFormat("d MMM, yyyy")
        return dateFormat.format(dateObject)
    }
}