package com.example.petrsumobile.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petrsumobile.R
import com.example.petrsumobile.news.NewsAdapter.NewsViewHolder
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<NewsViewHolder>() {
    private val newsList = mutableListOf<News>()

    interface OnItemClickListener {
        fun onItemClicked(news: News)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, listPosition: Int) {
        val textViewTitle = holder.textViewTitle
        val textViewDescription = holder.textViewDescription
        val textViewDate = holder.textViewDate
        val imageView = holder.imageView
//        val formattedDate = formatDate(newsList[listPosition].date)
        textViewTitle.text = newsList[listPosition].title
        textViewDescription.text = newsList[listPosition].description
        textViewDate.text = newsList[listPosition].date
        val imageViewURL = newsList[listPosition].enclosure.urlImage.replace("http", "https")
        imageView.setOnClickListener {
            onItemClickListener.onItemClicked(newsList[listPosition])
        }
        Glide.with(imageView)
                .load(imageViewURL)
                .centerCrop() //                .skipMemoryCache(true)
                //                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView)
    }

    override fun getItemCount(): Int = newsList.size

    fun updateList(list: List<News>) {
        val newsDiffUtilCallback = NewsDiffUtilCallback(list)
        val newsDiffResult = DiffUtil.calculateDiff(newsDiffUtilCallback)
        newsDiffResult.dispatchUpdatesTo(this)
        newsList.clear()
        newsList.addAll(list)
//        notifyDataSetChanged()
    }

//    private fun formatDate(dateObject: Date): String {
//        val dateFormat = SimpleDateFormat("d MMM, yyyy")
//        return dateFormat.format(dateObject)
//    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById<View>(R.id.textViewTitleDetails) as TextView
        val textViewDescription: TextView = itemView.findViewById<View>(R.id.textViewDescriptionDetails) as TextView
        val textViewDate: TextView = itemView.findViewById<View>(R.id.textViewDateDetails) as TextView
        val imageView: ImageView = itemView.findViewById<View>(R.id.imageViewNews) as ImageView
    }

    inner class NewsDiffUtilCallback(private val newList: List<News>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = newsList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldNews = newsList[oldItemPosition]
            val newNews = newList[newItemPosition]
            return oldNews.id === newNews.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldNews = newsList[oldItemPosition]
            val newNews = newList[newItemPosition]
            return oldNews == newNews
        }
    }
}