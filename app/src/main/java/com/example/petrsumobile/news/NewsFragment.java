package com.example.petrsumobile.news;

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
import com.example.petrsumobile.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<News>> {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<News> newsList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private NewsViewModel newsViewModel;

    private static final int NEWS_LOADER_ID = 1;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateRecyclerView();
    }

    public void updateRecyclerView(){
        newsViewModel = ViewModelProviders.of(this.getActivity()).get(NewsViewModel.class);

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

        initLoaderManager(NEWS_LOADER_ID);
        return view;
    }

    public void initLoaderManager(int loaderId){
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(loaderId, null, this);
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
}

