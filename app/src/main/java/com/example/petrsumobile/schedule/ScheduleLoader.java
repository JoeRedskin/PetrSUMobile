package com.example.petrsumobile.schedule;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.petrsumobile.DataQuery;

import java.util.ArrayList;

public class ScheduleLoader extends AsyncTaskLoader<ArrayList<ScheduleWeekType>> {

    private String urlString;
    public ScheduleLoader(@NonNull Context context, String urlString) {
        super(context);
        this.urlString = urlString;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public ArrayList<ScheduleWeekType> loadInBackground() {
        if (urlString == null) {
            return null;
        }

        //String url = "https://petrsu.egipti.com/api/v2/schedule/22407";
        return DataQuery.fetchScheduleData(urlString);
    }
}
