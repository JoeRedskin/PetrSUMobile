package com.example.petrsumobile.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.petrsumobile.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>  {

    private Context context;
    private ArrayList<Schedule> scheduleArrayList;

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView textViewScheduleName;
        TextView textViewScheduleNumber;
        TextView textViewScheduleTime;
        TextView textViewScheduleType;
        TextView textViewScheduleLecturer;
        TextView textViewScheduleClassroom;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            this.textViewScheduleName = (TextView) itemView.findViewById(R.id.textViewScheduleName);
            this.textViewScheduleNumber = (TextView) itemView.findViewById(R.id.textViewScheduleNumber);
            this.textViewScheduleTime = (TextView) itemView.findViewById(R.id.textViewScheduleTime);
            this.textViewScheduleType = (TextView) itemView.findViewById(R.id.textViewScheduleType);
            this.textViewScheduleLecturer = (TextView) itemView.findViewById(R.id.textViewScheduleLecturer);
            this.textViewScheduleClassroom = (TextView) itemView.findViewById(R.id.textViewScheduleClassroom);
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

        ScheduleAdapter.ScheduleViewHolder scheduleViewHolder = new ScheduleAdapter.ScheduleViewHolder(view);
        return scheduleViewHolder;
    }

    @Override
    public void onBindViewHolder(final ScheduleAdapter.ScheduleViewHolder holder, final int listPosition) {

        Schedule schedule = scheduleArrayList.get(listPosition);

        TextView textViewScheduleClassroom = holder.textViewScheduleClassroom;
        TextView textViewScheduleLecturer = holder.textViewScheduleLecturer;
        TextView textViewScheduleName = holder.textViewScheduleName;
        TextView textViewScheduleNumber = holder.textViewScheduleNumber;
        TextView textViewScheduleTime = holder.textViewScheduleTime;
        TextView textViewScheduleType = holder.textViewScheduleType;

        textViewScheduleClassroom.setText(schedule.getClassroom());
        textViewScheduleLecturer.setText(schedule.getLecturer());
        textViewScheduleName.setText(schedule.getName());
        textViewScheduleNumber.setText("№" + Integer.toString(schedule.getNumber()));
        textViewScheduleTime.setText(schedule.getStartTime() + " - " + schedule.getEndTime());
        textViewScheduleType.setText(schedule.getType());

        //Log.v("Tag",scheduleWeekdayArrayList.get(listPosition).getNameWeekday());

    }



    @Override
    public int getItemCount() {
        return scheduleArrayList.size();
    }
}