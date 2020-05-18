package com.example.petrsumobile.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.petrsumobile.R;
import java.util.ArrayList;


public class ScheduleWeekdayAdapter extends RecyclerView.Adapter<ScheduleWeekdayAdapter.ScheduleWeekdayViewHolder> {

    private Context context;
    private ArrayList<ScheduleWeekday> scheduleWeekdayArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public static class ScheduleWeekdayViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewScheduleWeekday;
        private RecyclerView rvSubItem;

        public ScheduleWeekdayViewHolder(View itemView) {
            super(itemView);
            this.textViewScheduleWeekday = (TextView) itemView.findViewById(R.id.textViewScheduleWeekday);
            this.rvSubItem = itemView.findViewById(R.id.recycle_view_schedule_subitem);
        }
    }

    public ScheduleWeekdayAdapter(Context context, ArrayList<ScheduleWeekday> data) {
        this.context = context;
        this.scheduleWeekdayArrayList = data;
    }

    @NonNull
    @Override
    public ScheduleWeekdayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_list, parent, false);
        return new ScheduleWeekdayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScheduleWeekdayViewHolder holder, final int listPosition) {

        ScheduleWeekday scheduleWeekday = scheduleWeekdayArrayList.get(listPosition);

        holder.textViewScheduleWeekday.setText(scheduleWeekday.getNameWeekday());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.rvSubItem.getContext());
        layoutManager.setInitialPrefetchItemCount(scheduleWeekday.getScheduleArrayList().size());

        ScheduleAdapter subItemAdapter = new ScheduleAdapter(context, scheduleWeekday.getScheduleArrayList());

        holder.rvSubItem.setLayoutManager(layoutManager);
        holder.rvSubItem.setAdapter(subItemAdapter);
        holder.rvSubItem.setRecycledViewPool(viewPool);

    }

   @Override
    public int getItemCount() {
        return scheduleWeekdayArrayList.size();
    }
}
