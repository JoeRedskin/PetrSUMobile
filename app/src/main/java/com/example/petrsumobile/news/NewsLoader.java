package com.example.petrsumobile.news;

import android.content.Context;
import android.os.AsyncTask;
import androidx.loader.content.AsyncTaskLoader;
import com.example.petrsumobile.DataQuery;

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
        return DataQuery.fetchNewsData();
    }
}
