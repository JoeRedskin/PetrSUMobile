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


public class ScheduleWeekAdapter extends RecyclerView.Adapter<ScheduleWeekAdapter.ScheduleWeekViewHolder> {

    private Context context;
    private ArrayList<ScheduleWeek> scheduleWeekArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public static class ScheduleWeekViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewScheduleWeek;
        private RecyclerView rvSubItem;

        public ScheduleWeekViewHolder(View itemView) {
            super(itemView);
            this.textViewScheduleWeek = (TextView) itemView.findViewById(R.id.textViewScheduleWeek);
            this.rvSubItem = itemView.findViewById(R.id.recycle_view_schedule_subitem);
        }
    }

    public ScheduleWeekAdapter(Context context, ArrayList<ScheduleWeek> data) {
        this.context = context;
        this.scheduleWeekArrayList = data;
    }

    @NonNull
    @Override
    public ScheduleWeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_list, parent, false);
        return new ScheduleWeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScheduleWeekViewHolder holder, final int listPosition) {

        ScheduleWeek scheduleWeek = scheduleWeekArrayList.get(listPosition);

        holder.textViewScheduleWeek.setText(scheduleWeek.getNameWeek());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.rvSubItem.getContext());
        layoutManager.setInitialPrefetchItemCount(scheduleWeek.getScheduleArrayList().size());

        ScheduleAdapter subItemAdapter = new ScheduleAdapter(context, scheduleWeek.getScheduleArrayList());

        holder.rvSubItem.setLayoutManager(layoutManager);
        holder.rvSubItem.setAdapter(subItemAdapter);
        holder.rvSubItem.setRecycledViewPool(viewPool);

    }

   @Override
    public int getItemCount() {
        return scheduleWeekArrayList.size();
    }
}
