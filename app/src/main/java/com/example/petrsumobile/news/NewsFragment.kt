package com.example.petrsumobile.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.petrsumobile.NewsDatabase
import com.example.petrsumobile.R
import com.example.petrsumobile.news.NewsRetrofitClient.retrofit

class NewsFragment : Fragment() {

    private val recyclerView: RecyclerView by lazy {
        view?.findViewById<View>(R.id.recycle_view_news) as RecyclerView
    }
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        setupWithNavController(toolbar, findNavController())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsAdapter(object : NewsAdapter.OnItemClickListener {
            override fun onItemClicked(news: News) {
                val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(news.id)
                findNavController().navigate(action)
            }
        })
        recyclerView.adapter = adapter

        val db = Room.databaseBuilder(view.context,
                NewsDatabase::class.java, "populus-database").fallbackToDestructiveMigration().build()

        viewModel = ViewModelProvider(this, NewsViewModelFactory(NewsRepository(retrofit, db.newsDao))).get(NewsViewModel::class.java)

        viewModel.deleteNews()
        viewModel.fetchNews()
        viewModel.newsList.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                adapter.updateList(it)
                print(it)
            }
        }
    }
}