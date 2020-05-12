package com.example.petrsumobile;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<News>> {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<News> newsList = new ArrayList<News>();
    private RecyclerView.LayoutManager layoutManager;
    private NewsViewModel newsViewModel;

    private static final int NEWS_LOADER_ID = 1;
//    private static final String USGS_REQUEST_URL =
//            "https://petrsu.ru/rss";

    /*
    public NewsFragment() {
        // Required empty public constructor
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsViewModel = ViewModelProviders.of(this.getActivity()).get(NewsViewModel.class);

        //fetchNewsItems();
        recyclerView = (RecyclerView) this.getActivity().findViewById(R.id.recycle_view_news);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new NewsAdapter(getActivity(), newsList, new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position, News itemNews) {
                //Toast.makeText(getContext(), position + " card "+ itemNews.getNewsDate(), Toast.LENGTH_SHORT).show();
                newsViewModel.selectNews(itemNews);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Новости");

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(NEWS_LOADER_ID, null, this);

        return view;
    }

    @NonNull
    @Override
    public Loader<ArrayList<News>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsLoader(this.getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<News>> loader, ArrayList<News> data) {

        newsList.clear();

        if (data != null && !data.isEmpty()) {
            newsList.addAll(data);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<News>> loader) {

        newsList.clear();
        adapter.notifyDataSetChanged();
    }

   /* private void fetchNewsItems(){
        newsList.add(new News(
                "titletitletitletitletitletitletitletitle",
                "descriptriooooooooooooodescriptriooooooooooooo" +
                        "descriptriooooooooooooodescriptriooooooooooooo" +
                        "descriptriooooooooooooodescriptriooooooooooooo",
                "www.ya.ru",
                "28.04.2020",
                "image"));
        newsList.add(new News(
                "BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "1BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "2BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "3BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
    }*/
}

