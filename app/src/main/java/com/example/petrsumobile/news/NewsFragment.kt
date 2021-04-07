package com.example.petrsumobile.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.petrsumobile.R
import com.example.petrsumobile.news.RetrofitClient.retrofit

class NewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: NewsViewModel
    private val newsList = ArrayList<News>()
    private val adapter = NewsAdapter(newsList)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = this.activity!!.findViewById<View>(R.id.recycle_view_news) as RecyclerView
        viewModel = NewsViewModel(NewsRepository((retrofit)))
//        adapter = NewsAdapter(activity, newsList) { position, itemNews -> //Toast.makeText(getContext(), position + " card "+ itemNews.getNewsDate(), Toast.LENGTH_SHORT).show();
//            newsViewModel!!.selectNews(itemNews)
//        }
        recyclerView.adapter = adapter

        viewModel.newsList.observe(this) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    citiesList.clear()
                    citiesList.addAll(it)
                    updateCityInfo(citiesList[0])
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Новости"
//        initLoaderManager(NEWS_LOADER_ID)
        return view
    }

//    fun initLoaderManager(loaderId: Int) {
//        val loaderManager = loaderManager
//        loaderManager.initLoader(loaderId, null, this)
//    }

//    override fun onCreateLoader(id: Int, args: Bundle?): Loader<ArrayList<News>?> {
//        return NewsLoader(this.context)
//    }

//    override fun onLoadFinished(loader: Loader<ArrayList<News>?>, data: ArrayList<News>?) {
//        newsList.clear()
//        if (data != null && !data.isEmpty()) {
//            newsList.addAll(data)
//            adapter!!.notifyDataSetChanged()
//        }
//    }

//    override fun onLoaderReset(loader: Loader<ArrayList<News>?>) {
//        newsList.clear()
//        adapter!!.notifyDataSetChanged()
//    }

    companion object {
        //        private var adapter: RecyclerView.Adapter<*>? = null
//        private var recyclerView: RecyclerView? = null
        private val newsList = ArrayList<News>()
        private const val NEWS_LOADER_ID = 1
    }
}