package com.example.petrsumobile;

import android.content.Context;
import android.os.AsyncTask;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<News> loadInBackground() {

        // Perform the network request, parse the response, and extract a list of earthquakes.
        ArrayList<News> newsArrayList = DataQuery.fetchNewsData();
        return newsArrayList;
    }

}
