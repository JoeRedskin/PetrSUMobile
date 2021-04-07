//package com.example.petrsumobile.news
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProviders
//import com.bumptech.glide.Glide
//import com.example.petrsumobile.R
//import java.text.SimpleDateFormat
//import java.util.*
//
///**
// * A simple [Fragment] subclass.
// */
//class NewsDetailsFragment : Fragment() {
//    var textViewDateDetails: TextView? = null
//    var textViewTitleDetails: TextView? = null
//    var textViewDescriptionDetails: TextView? = null
//    var imageView: ImageView? = null
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_news_details, container, false)
//
//        //TODO: navigation not work
//        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
//        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Новости"
//        textViewDateDetails = view.findViewById<View>(R.id.textViewDateDetails) as TextView
//        textViewTitleDetails = view.findViewById<View>(R.id.textViewTitleDetails) as TextView
//        textViewDescriptionDetails = view.findViewById<View>(R.id.textViewDescriptionDetails) as TextView
//        imageView = view.findViewById<View>(R.id.imageViewNewsDetails) as ImageView
//        return view
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val newsViewModel = ViewModelProviders.of(this.activity!!).get(NewsViewModel::class.java)
//
//        /*newsViewModel.getSelectedNews().observe(getViewLifecycleOwner(), item -> {
//            displayDetails(newsViewModel.getNews());
//        });*/
//        displayDetails(newsViewModel.selectedNews)
//    }
//
//    fun displayDetails(news: News) {
//        val formattedDate = formatDate(news.date)
//        val imageViewURL = news.imageUrl
//        textViewDateDetails!!.text = formattedDate
//        textViewTitleDetails.setText(news.getTitle())
//        textViewDescriptionDetails.setText(news.getDescription())
//        Glide.with(this)
//                .load(imageViewURL)
//                .centerCrop() //                .skipMemoryCache(true)
//                //                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .placeholder(R.drawable.ic_placeholder)
//                .into(imageView!!)
//    }
//
//    private fun formatDate(dateObject: Date?): String {
//        val dateFormat = SimpleDateFormat("d MMM, yyyy")
//        return dateFormat.format(dateObject)
//    }
//}