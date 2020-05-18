package com.example.petrsumobile.schedule;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.petrsumobile.DataQuery;
import com.example.petrsumobile.R;
import com.xwray.groupie.GroupAdapter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private ArrayList<ScheduleWeekdayType> scheduleWeekdayTypeArrayList;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    public ScheduleFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) this.getActivity().findViewById(R.id.recycle_view_weekdays);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<ScheduleWeekday> scheduleWeekdayArrayList = scheduleWeekdayTypeArrayList.
                                                                get(0).getScheduleWeekdayArrayList();
        adapter = new ScheduleWeekdayAdapter(getActivity(),scheduleWeekdayArrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Расписание");




        scheduleWeekdayTypeArrayList = DataQuery.fetchScheduleData();
       // Log.d("TAG", String.valueOf(scheduleWeekdayTypeArrayList.size()));


        return view;
    }

}
