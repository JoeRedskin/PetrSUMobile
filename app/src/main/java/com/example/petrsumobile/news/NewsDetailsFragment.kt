package com.example.petrsumobile.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.petrsumobile.NewsDatabase
import com.example.petrsumobile.R
import com.example.petrsumobile.news.NewsRetrofitClient.retrofit

class NewsDetailsFragment : Fragment() {
    private val textViewDateDetails: TextView by lazy {
        view?.findViewById(R.id.textViewDateDetails) as TextView
    }
    private val textViewTitleDetails: TextView by lazy {
        view?.findViewById(R.id.textViewTitleDetails) as TextView
    }
    private val textViewDescriptionDetails: TextView by lazy {
        view?.findViewById(R.id.textViewDescriptionDetails) as TextView
    }
    private val imageView: ImageView by lazy {
        view?.findViewById(R.id.imageViewNewsDetails) as ImageView
    }

    private lateinit var viewModel: NewsDetailsViewModel
    private val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news_details, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        setupWithNavController(toolbar, findNavController())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(view.context,
                NewsDatabase::class.java, "populus-database").fallbackToDestructiveMigration().build()
//        viewModel = NewsDetailsViewModel(args.id, NewsRepository(retrofit, db.newsDao))
        viewModel = ViewModelProvider(this, NewsDetailsViewModelFactory(args.id, NewsRepository(retrofit, db.newsDao))).get(NewsDetailsViewModel::class.java)
        viewModel.currentNews.observe(viewLifecycleOwner, this::displayDetails)
    }

    private fun displayDetails(news: News) {
//        val formattedDate = formatDate(news.date)
        val imageViewURL = news.enclosure.urlImage.replace("http", "https")
        textViewDateDetails.text = news.date
        textViewTitleDetails.text = news.title
        textViewDescriptionDetails.text = news.description
        Glide.with(this)
                .load(imageViewURL)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView)
    }

//    private fun formatDate(dateObject: Date?): String {
//        val dateFormat = SimpleDateFormat("d MMM, yyyy")
//        return dateFormat.format(dateObject)
//    }
}