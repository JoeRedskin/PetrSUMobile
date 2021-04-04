package com.example.petrsumobile.schedule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petrsumobile.R;
import com.example.petrsumobile.news.News;
import com.example.petrsumobile.news.NewsAdapter;
import com.example.petrsumobile.news.NewsViewModel;
//import com.xwray.groupie.GroupAdapter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<ScheduleWeekType>>{

    private ArrayList<ScheduleWeekType> scheduleWeekTypeArrayList = new ArrayList<>();
    ArrayList<ScheduleWeek> scheduleWeekArrayList = new ArrayList<>();
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private static final String SCHEDULE_REQUEST_URL = "https://petrsu.egipti.com/api/v2/schedule/";
    private static final int SCHEDULE_LOADER_ID = 1;


    public ScheduleFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateRecyclerView();
    }

    public void updateRecyclerView(){
        recyclerView = (RecyclerView) this.getActivity().findViewById(R.id.recycle_view_weeks);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        if (scheduleWeekTypeArrayList.size() != 0) {
            scheduleWeekArrayList = scheduleWeekTypeArrayList.
                    get(0).getScheduleWeekArrayList();
        }

        adapter = new ScheduleWeekAdapter(getActivity(), scheduleWeekArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Расписание");

        initLoaderManager(SCHEDULE_LOADER_ID);
       // Log.d("TAG", String.valueOf(scheduleWeekdayTypeArrayList.size()));

        return view;
    }

    public void initLoaderManager(int loaderId){
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(loaderId, null, this);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.settings_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent settingsIntent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(settingsIntent);
                break;
        }
        return true;
    }

    @NonNull
    @Override
    public Loader<ArrayList<ScheduleWeekType>> onCreateLoader(int id, @Nullable Bundle args) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String groupNumber = sharedPrefs.getString(
                getString(R.string.settings_group_number_key),
                getString(R.string.settings_group_number_default));

        String scheduleUrl = SCHEDULE_REQUEST_URL + groupNumber;

        return new ScheduleLoader(this.getContext(), scheduleUrl);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<ScheduleWeekType>> loader, ArrayList<ScheduleWeekType> data) {
        scheduleWeekTypeArrayList.clear();
        scheduleWeekArrayList.clear();

        if (data != null && !data.isEmpty()) {
            //scheduleWeekdayTypeArrayList.addAll(data);
//            scheduleWeekdayArrayList = scheduleWeekdayTypeArrayList.
////                    get(0).getScheduleWeekdayArrayList();
            scheduleWeekArrayList.addAll(data.get(0).getScheduleWeekArrayList());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<ScheduleWeekType>> loader) {
        scheduleWeekTypeArrayList.clear();
        scheduleWeekArrayList.clear();
        adapter.notifyDataSetChanged();
    }
}
