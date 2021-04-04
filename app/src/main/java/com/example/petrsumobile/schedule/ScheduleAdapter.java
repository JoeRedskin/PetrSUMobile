package com.example.petrsumobile.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.petrsumobile.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>  {

    private Context context;
    private ArrayList<Schedule> scheduleArrayList;

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView textViewScheduleTitle;
        TextView textViewScheduleTimeEnd;
        TextView textViewScheduleTimeStart;
        TextView textViewScheduleType;
        TextView textViewScheduleLecturer;
        TextView textViewScheduleClassroom;
        ImageButton showOnMapButton;
        View lineView;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            this.textViewScheduleTitle = (TextView) itemView.findViewById(R.id.textViewScheduleTitle);
            this.textViewScheduleTimeEnd = (TextView) itemView.findViewById(R.id.textViewScheduleTimeEnd);
            this.textViewScheduleTimeStart = (TextView) itemView.findViewById(R.id.textViewScheduleTimeStart);
            this.textViewScheduleType = (TextView) itemView.findViewById(R.id.textViewScheduleType);
            this.textViewScheduleLecturer = (TextView) itemView.findViewById(R.id.textViewScheduleLecturer);
            this.textViewScheduleClassroom = (TextView) itemView.findViewById(R.id.textViewScheduleClassroom);
            this.showOnMapButton = (ImageButton) itemView.findViewById(R.id.showOnMapButton);
            this.lineView = (View) itemView.findViewById(R.id.lineView);
        }
    }

    public ScheduleAdapter(Context context, ArrayList<Schedule> data) {
        this.context = context;
        this.scheduleArrayList = data;
    }

    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item, parent, false);

        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScheduleAdapter.ScheduleViewHolder holder, final int listPosition) {
        Schedule schedule = scheduleArrayList.get(listPosition);

        TextView textViewScheduleClassroom = holder.textViewScheduleClassroom;
        TextView textViewScheduleLecturer = holder.textViewScheduleLecturer;
        TextView textViewScheduleTitle = holder.textViewScheduleTitle;
        TextView textViewScheduleTimeEnd = holder.textViewScheduleTimeEnd;
        TextView textViewScheduleTimeStart = holder.textViewScheduleTimeStart;
        TextView textViewScheduleType = holder.textViewScheduleType;
        ImageButton showOnMapButton = holder.showOnMapButton;
        View lineView = holder.lineView;


//        String titleBefore = schedule.getTitle().toUpperCase();
//        String[] titles = titleBefore.split(" ");
//        StringBuilder titleAfter = new StringBuilder();
//        for (String title : titles) {
//            switch (title) {
//                case "ЛАБОРАТОРНЫЕ":
//                    titleAfter.append("Лаборарная работа ");
//                    break;
//                case "ЛЕКЦИИ":
//                    titleAfter.append("Лекция ");
//                    break;
//                case "ДИСТАНТ":
//                    titleAfter.append("Дистант ");
//                    break;
//                default:
//                    titleAfter.append("ЛАБ");
//                    break;
//            }
//        }
        if (listPosition == scheduleArrayList.size()-1){
            lineView.setVisibility(View.GONE);
        } else {
            lineView.setVisibility(View.VISIBLE);
        }

        if (schedule.getClassroom().equals("")){
            textViewScheduleClassroom.setVisibility(View.GONE);
            showOnMapButton.setVisibility(View.INVISIBLE);
        } else {
            textViewScheduleClassroom.setVisibility(View.VISIBLE);
            //TODO: убрать эту строку
            showOnMapButton.setVisibility(View.INVISIBLE);
//            showOnMapButton.setVisibility(View.VISIBLE);
        }
        textViewScheduleClassroom.setText(schedule.getClassroom());
        textViewScheduleLecturer.setText(schedule.getLecturer());
        textViewScheduleTitle.setText(schedule.getTitle());
        textViewScheduleTimeEnd.setText(schedule.getEndTime());
        textViewScheduleTimeStart.setText(schedule.getStartTime());
        textViewScheduleType.setText(schedule.getType());
    }

    @Override
    public int getItemCount() {
        return scheduleArrayList.size();
    }
}